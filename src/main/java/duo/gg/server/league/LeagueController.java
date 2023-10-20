package duo.gg.server.league;

import duo.gg.server.summoner.SummonerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LeagueController {

    private final LeagueService leagueService;
    private final SummonerService summonerService;
    private final LeagueRepository leagueRepository;

    //TODO: Schedule: 챌린저 리그 API CALL, DB 업데이트

    @PostMapping("/league/{name}")
    public void upsertByName(@PathVariable String name) {
        String summonerId = summonerService.getSummonerIdByName(name);
        leagueService.upsertBySummonerId(summonerId);
    }


    //TODO: Get - 랭킹 20등까지의 정보 추출
    //아이콘, 이름, 티어, 점수, 레벨, 승, 패, 랭킹, 승률

    //TODO: Get - summoner id를 사용해 랭크 정보 추출
    //아이콘, 이름, 랭킹, 솔로랭크(티어, 점수, 승, 패, 승률), 자유랭크(티어, 점수, 승, 패, 승률)


}
