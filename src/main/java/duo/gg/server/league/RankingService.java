package duo.gg.server.league;

import duo.gg.server.account.AccountService;
import duo.gg.server.api.dto.league.LeagueItemApiResult;
import duo.gg.server.api.dto.league.LeagueListApiResult;
import duo.gg.server.api.service.ApiService;
import duo.gg.server.constant.QueueEnum;
import duo.gg.server.league.dto.RankingDto;
import duo.gg.server.league.entry.League;
import duo.gg.server.summoner.SummonerRepository;
import duo.gg.server.summoner.SummonerService;
import duo.gg.server.summoner.dto.SummonerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RankingService {

    private final ApiService apiService;
    private final SummonerService summonerService;
    private final AccountService accountService;
    private final LeagueRepository repository;

    public void upsertRanking() {
        LeagueListApiResult result = apiService.getChallengerLeaguesByQueue(QueueEnum.RANKED_SOLO_5x5);
        String leagueId = result.getLeagueId();
        String tier = result.getTier();
        String queueType = result.getQueue();

        List<LeagueItemApiResult> top10 = result.getEntries()
                .stream()
                .sorted(Comparator.comparing(LeagueItemApiResult::getLeaguePoints).reversed())
                .limit(10).toList();

        for (LeagueItemApiResult entry : top10) {
            String summonerId = entry.getSummonerId();
            // League Update.
            Optional<League> findLeague = repository.findBySummonerIdAndQueueType(summonerId, QueueEnum.valueOf(queueType));

            if (findLeague.isEmpty()) {
                repository.insertByItemApiResult(entry, leagueId, tier, queueType);
            } else {
                repository.updateByItemApiResult(findLeague.get(), entry, leagueId, tier, queueType);
            }

            // Summoner Update.
            summonerService.upsertSummonerBySummonerId(summonerId);
            SummonerDto findSummoner = summonerService.getSummonerBySummonerId(summonerId);

            // Account Update.
            accountService.upsertAccountByPuuid(findSummoner.getPuuid());
        }
    }

    public List<RankingDto> getRanking(Integer offset, Integer limit) {
        return repository.findRanking(offset, limit);
    }

}
