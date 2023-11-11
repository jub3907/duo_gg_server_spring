package duo.gg.server.match;

import duo.gg.server.common.ResponseBody;
import duo.gg.server.match.dto.MatchBasicDto;
import duo.gg.server.match.dto.MatchDetailDto;
import duo.gg.server.match.entity.MatchInfo;
import duo.gg.server.match.entity.Participant;
import duo.gg.server.summoner.SummonerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MatchController {
    private final SummonerService summonerService;
    private final MatchService matchService;
    private final MatchRepository matchRepository;

    @Transactional
    @PostMapping("/match/{puuid}")
    public ResponseEntity<String> updateRecentMatches(@PathVariable String puuid,
                                                      @RequestParam(required = false) Integer start,
                                                      @RequestParam(required = false) Integer count) {
        List<String> recentMatchIds = matchService.getMatchIdsByPuuid(puuid, start, count);

        List<String> matchIdsNotInDb = matchService.getMatchIdsNotInDb(recentMatchIds);

        matchService.updateMatches(matchIdsNotInDb);
        
        return new ResponseEntity<>(ResponseBody.SUCCESS, HttpStatus.OK);
    }

    @GetMapping("/match/{puuid}")
    public List<MatchBasicDto> getRecentMatches(@PathVariable String puuid,
                                                @RequestParam(required = false) Integer start,
                                                @RequestParam(required = false) Integer count) {
        List<String> recentMatchIds = matchService.getMatchIdsByPuuid(puuid, start, count);
        List<MatchInfo> matches = matchRepository.findByMatchIds(recentMatchIds);

        return matchService.getMatchBasics(matches, puuid);
    }


    @GetMapping("/match/detail")
    public MatchDetailDto getMatchDetail(@RequestParam String matchId,
                                         @RequestParam String puuid) {
        MatchInfo match = matchRepository.findById(matchId).get();

        return matchService.getMatchDetail(match, puuid);
    }

}
