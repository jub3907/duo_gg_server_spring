package duo.gg.server.league;

import duo.gg.server.common.ResponseBody;
import duo.gg.server.constant.QueueEnum;
import duo.gg.server.league.dto.LeagueDto;
import duo.gg.server.league.dto.RankingDto;
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
public class LeagueController {

    private final LeagueService leagueService;
    private final SummonerService summonerService;
    private final LeagueRepository leagueRepository;

    @GetMapping("/ranking")
    public List<RankingDto> ranking(@RequestParam Integer offset, @RequestParam Integer limit) {
        return leagueService.getRanking(offset, limit);
    }

    @Transactional
    @PostMapping("/league/by-name/{name}")
    public ResponseEntity<String> upsertByName(@PathVariable String name) {
        String summonerId = summonerService.getSummonerIdByName(name);
        leagueService.upsertBySummonerId(summonerId);
        return new ResponseEntity<>(ResponseBody.SUCCESS, HttpStatus.OK);
    }

    @GetMapping("/league/by-name/{name}")
    public List<LeagueDto> getLeagueInfosByName(@PathVariable String name) {
        String summonerId = summonerService.getSummonerIdByName(name);
        return leagueService.getLeagueInfos(summonerId);
    }

    @GetMapping("/league/by-name/{name}/solo")
    public LeagueDto getSoloLeagueInfoByName(@PathVariable String name) {
        String summonerId = summonerService.getSummonerIdByName(name);
        return leagueService.getLeagueInfo(summonerId, QueueEnum.RANKED_SOLO_5x5);
    }

    @GetMapping("/league/by-name/{name}/free")
    public LeagueDto getFreeLeagueInfoByName(@PathVariable String name) {
        String summonerId = summonerService.getSummonerIdByName(name);
        return leagueService.getLeagueInfo(summonerId, QueueEnum.RANKED_FLEX_SR);
    }

}
