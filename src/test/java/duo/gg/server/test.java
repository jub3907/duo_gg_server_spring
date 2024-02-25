package duo.gg.server;

import duo.gg.server.league.LeagueService;
import duo.gg.server.match.MatchRepository;
import duo.gg.server.match.entity.MatchInfo;
import duo.gg.server.summoner.SummonerService;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@Transactional
@SpringBootTest
public class test {

    @Autowired
    SummonerService summonerService;

    @Autowired
    LeagueService leagueService;

    @Autowired
    MatchRepository matchRepository;

    @Autowired
    EntityManager em;

//    @Test
//    @Rollback(value = false)
//    public void test() {
//
//        String name = "스트레스유발협곡";
//        Integer offset = 0;
//        Integer limit = 5;
//
//        leagueService.upsertRanking();
//
//        //given
//        summonerService.upsertSummonerByName(name);
//
//    }

//    @Test
//    public void test2() {
//        String name = "스트레스유발협곡";
//        String puuid = summonerService.getPuuidByName(name);
//
//        List<String> recentMatchIds = new ArrayList<String>();
//        recentMatchIds.add("KR_6791339388");
//
//        List<MatchInfo> byMatchIds = matchRepository.findByMatchIds(recentMatchIds);
//
//        for (MatchInfo byMatchId : byMatchIds) {
//            log.info("{}", byMatchId);
//        }
//    }
}
