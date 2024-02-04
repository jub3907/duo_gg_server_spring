package duo.gg.server.league;

import duo.gg.server.api.dto.league.LeagueEntryApiResult;
import duo.gg.server.api.dto.league.LeagueItemApiResult;
import duo.gg.server.api.dto.league.LeagueListApiResult;
import duo.gg.server.api.service.ApiService;
import duo.gg.server.comment.error.NoLeagueInfo;
import duo.gg.server.constant.QueueEnum;
import duo.gg.server.league.dto.LeagueDto;
import duo.gg.server.league.dto.RankingDto;
import duo.gg.server.league.entry.League;
import duo.gg.server.summoner.SummonerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LeagueService {
    
    private final ApiService apiService;
    private final SummonerRepository summonerRepository;
    private final LeagueRepository repository;
    
    public void upsertRanking() {
        LeagueListApiResult result = apiService.getChallengerLeaguesByQueue(QueueEnum.RANKED_SOLO_5x5);
        String leagueId = result.getLeagueId();
        String tier = result.getTier();
        String queueType = result.getQueue();

        List<LeagueItemApiResult> top20 = result.getEntries()
                .stream()
                .sorted(Comparator.comparing(LeagueItemApiResult::getLeaguePoints).reversed())
                .limit(20).toList();

        for (LeagueItemApiResult entry : top20) {
            String summonerId = entry.getSummonerId();
            Optional<League> findLeague = repository.findBySummonerIdAndQueueType(summonerId, QueueEnum.valueOf(queueType));

            if (findLeague.isEmpty()) {
                repository.insertByItemApiResult(entry, leagueId, tier, queueType);
            } else {
                repository.updateByItemApiResult(findLeague.get(), entry, leagueId, tier, queueType);
            }
        }
    }

    public void upsertBySummonerId(String summonerId) {
        List<LeagueEntryApiResult> leagueEntriesApiResults = apiService.getLeagueEntriesBySummonerId(summonerId);
        List<League> findLeagues = repository.findBySummonerId(summonerId);

        for (LeagueEntryApiResult result : leagueEntriesApiResults) {
            QueueEnum queueType = QueueEnum.valueOf(result.getQueueType());
            Optional<League> filteredLeague = findLeagues.stream().filter(league -> league.getQueueType().equals(queueType)).findAny();

            if (filteredLeague.isEmpty()) {
                repository.insertByEntryApiResult(result);
            } else {
                repository.updateByEntryApiResult(filteredLeague.get(), result);
            }

        }
    }


    public List<RankingDto> getRanking(Integer offset, Integer limit) {
        return repository.findRanking(offset, limit);
    }

    public List<LeagueDto> getLeagueInfos(String summonerId) {
        List<League> leagues = repository.findBySummonerId(summonerId);
        return leagues.stream().map(LeagueDto::new)
                .collect(Collectors.toList());
    }

    public LeagueDto getLeagueInfo(String summonerId, QueueEnum queue) {
        Optional<League> league = repository.findBySummonerIdAndQueueType(summonerId, queue);

        return league.map(LeagueDto::new).orElseThrow(NoLeagueInfo::new);
    }
}
