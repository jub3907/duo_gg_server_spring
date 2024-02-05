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

    @Transactional
    @PostMapping("/league/{puuid}")
    public ResponseEntity<String> upsertByPuuid(@PathVariable String puuid) {
        String summonerId = summonerService.getSummonerIdByPuuid(puuid);
        leagueService.upsertBySummonerId(summonerId);
        return new ResponseEntity<>(ResponseBody.SUCCESS, HttpStatus.OK);
    }

    @GetMapping("/league/{puuid}")
    public List<LeagueDto> getLeagueInfosByPuuid(@PathVariable String puuid) {
        String summonerId = summonerService.getSummonerIdByPuuid(puuid);
        return leagueService.getLeagueInfos(summonerId);
    }


    @GetMapping("/league/{puuid}/solo")
    public LeagueDto getSoloLeagueInfoByPuuid(@PathVariable String puuid) {
        String summonerId = summonerService.getSummonerIdByPuuid(puuid);
        return leagueService.getLeagueInfo(summonerId, QueueEnum.RANKED_SOLO_5x5);
    }

    @GetMapping("/league/{puuid}/free")
    public LeagueDto getFreeLeagueInfoByPuuid(@PathVariable String puuid) {
        String summonerId = summonerService.getSummonerIdByPuuid(puuid);
        return leagueService.getLeagueInfo(summonerId, QueueEnum.RANKED_FLEX_SR);
    }
}
