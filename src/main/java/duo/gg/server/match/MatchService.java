package duo.gg.server.match;

import duo.gg.server.api.dto.match.MatchApiResult;
import duo.gg.server.api.service.ApiService;
import duo.gg.server.match.dto.MatchBasicDto;
import duo.gg.server.match.dto.MatchDetailDto;
import duo.gg.server.match.entity.MatchInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class MatchService {

    private final ApiService apiService;
    private final MatchRepository matchRepository;

    public List<String> getMatchIdsByPuuid(String puuid, Integer start, Integer count) {
        start = start == null? 0 : start;
        count = count == null? 10 : count;

        return apiService.getMatchIdsByPuuid(puuid, start, count);
    }

    public List<String> getMatchIdsNotInDb(List<String> matchIds) {
        List<String> matchIdsInDb = matchRepository.findMatchIdsInDb(matchIds);
        return matchIds.stream()
                .filter((id) -> !matchIdsInDb.contains(id))
                .collect(Collectors.toList());
    }

    public void updateMatches(List<String> matchIds) {
        List<MatchApiResult> matchApiResults = matchIds.stream()
                .map(apiService::getMatchByMatchId)
                .toList();

        matchRepository.updateMatchesByApiResults(matchApiResults);
    }

    public List<MatchBasicDto> getMatchBasics(List<MatchInfo> matches, String puuid) {
        return matches.stream()
                .map(match -> new MatchBasicDto(match, puuid))
                .collect(Collectors.toList());
    }

    public MatchDetailDto getMatchDetail(MatchInfo match, String puuid) {
        return new MatchDetailDto(match, puuid);
    }

}
