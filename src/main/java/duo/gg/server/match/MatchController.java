package duo.gg.server.match;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MatchController {
    @PostMapping("/match/{name}")
    public void updateRecentMatches(@PathVariable String name,
                                    @RequestParam(required = false) Integer start,
                                    @RequestParam(required = false) Integer count) {

        // 0. get puuid of summoner by name

        // 1. get match ids by puuid

        // 2. select matchs db with ids

        // 3. update matches where id is not in DB
    }

    @GetMapping("/match/{name}")
    public List<MatchBasicDto> getRecentMatches(@PathVariable String name,
                                                @RequestParam(required = false) Integer start,
                                                @RequestParam(required = false) Integer count) {
        // 1. get recent matches

        // 2. reshape Match entity List to MatchBasicDto List, return.
        return null;
    }

    @GetMapping("/match/detail/{matchId}")
    public MatchDetailDto getMatchDetail(@PathVariable String matchId) {
        // 1. get match by matchId
        // reshape Match entity to MatchDetailDto, return.
        return null;
    }

}
