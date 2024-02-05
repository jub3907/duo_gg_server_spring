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
import duo.gg.server.summoner.SummonerService;
import duo.gg.server.summoner.dto.SummonerDto;
import duo.gg.server.summoner.entity.Summoner;
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
    private final LeagueRepository repository;

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
