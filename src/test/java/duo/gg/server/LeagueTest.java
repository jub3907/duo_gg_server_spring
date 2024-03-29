package duo.gg.server;


import duo.gg.server.league.LeagueRepository;
import duo.gg.server.league.LeagueService;
import duo.gg.server.league.RankingService;
import duo.gg.server.league.dto.LeagueDto;
import duo.gg.server.league.dto.RankingDto;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Transactional
@SpringBootTest
public class LeagueTest {


    @Autowired
    LeagueService service;

    @Autowired
    LeagueRepository repository;

    @Autowired
    RankingService rankingService;

//    @Test
//    @Rollback(value = false)
//    public void upsertRanking() {
//        //given
//        rankingService.upsertRanking();
//
//        //when
//        List<RankingDto> ranking = rankingService.getRanking(0, 10);
//
//        List<RankingDto> ranking20 = rankingService.getRanking(0, 20);
//        //then
//        Assertions.assertThat(ranking.size()).isEqualTo(10);
//        Assertions.assertThat(ranking20.size()).isEqualTo(20);
//    }

//    @Test
//    public void upsertBySummonerId() {
//        //given
//        service.upsertBySummonerId(TestConstant.summonerId);
//
//        //when
//        List<LeagueDto> leaguesInfo = service.getLeagueInfos(TestConstant.summonerId);
//
//        //then
//
//    }
}
