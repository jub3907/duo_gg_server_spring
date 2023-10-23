package duo.gg.server.league;

import duo.gg.server.league.dto.RankingDto;
import duo.gg.server.summoner.SummonerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LeagueController {

    private final LeagueService leagueService;
    private final SummonerService summonerService;
    private final LeagueRepository leagueRepository;

    @Transactional
    @PostMapping("/league/{name}")
    public void upsertByName(@PathVariable String name) {
        String summonerId = summonerService.getSummonerIdByName(name);
        leagueService.upsertBySummonerId(summonerId);
    }

    @GetMapping("/ranking")
    public List<RankingDto> ranking(@RequestParam Integer offset, @RequestParam Integer limit) {
        return leagueService.getRanking(offset, limit);
    }


    //TODO: Get - 랭킹 20등까지의 정보 추출
    //아이콘, 이름, 티어, 점수, 레벨, 승, 패, 랭킹, 승률
}
