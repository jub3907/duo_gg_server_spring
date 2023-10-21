package duo.gg.server.match;

import duo.gg.server.api.service.ApiService;
import duo.gg.server.match.dto.MatchBasicDto;
import duo.gg.server.match.dto.MatchDetailDto;
import duo.gg.server.match.entity.Match;
import duo.gg.server.summoner.SummonerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MatchController {
    private final SummonerService summonerService;
    private final MatchService matchService;
    private final MatchRepository matchRepository;

    @Transactional
    @PostMapping("/match/{name}")
    public void updateRecentMatches(@PathVariable String name,
                                    @RequestParam(required = false) Integer start,
                                    @RequestParam(required = false) Integer count) {
        String puuid = summonerService.getPuuidByName(name);

        List<String> recentMatchIds = matchService.getMatchIdsByPuuid(puuid, start, count);

        List<String> matchIdsNotInDb = matchService.getMatchIdsNotInDb(recentMatchIds);

        matchService.updateMatches(matchIdsNotInDb);
    }

    @GetMapping("/match/{name}")
    public List<MatchBasicDto> getRecentMatches(@PathVariable String name,
                                                @RequestParam(required = false) Integer start,
                                                @RequestParam(required = false) Integer count) {

        String puuid = summonerService.getPuuidByName(name);
        List<String> recentMatchIds = matchService.getMatchIdsByPuuid(puuid, start, count);
        List<Match> matches = matchRepository.findByIds(recentMatchIds);

        return matchService.getMatchBasics(matches, puuid);
    }

    @GetMapping("/match/detail")
    public MatchDetailDto getMatchDetail(@RequestParam String matchId,
                                         @RequestParam String name) {
        String puuid = summonerService.getPuuidByName(name);
        Match match = matchRepository.findById(matchId).get();

        return matchService.getMatchDetail(match, puuid);
    }

}
