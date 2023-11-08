package duo.gg.server;

import duo.gg.server.constant.QueueEnum;
import duo.gg.server.league.LeagueRepository;
import duo.gg.server.league.LeagueService;
import duo.gg.server.league.dto.RankingDto;
import duo.gg.server.league.entry.League;
import duo.gg.server.post.contant.PostRankType;
import duo.gg.server.summoner.SummonerService;
import duo.gg.server.summoner.dto.SummonerDto;
import duo.gg.server.summoner.entity.Summoner;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
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
    EntityManager em;

    @Test
    @Rollback(value = false)
    public void test() {

        String name = "스트레스유발협곡";
        Integer offset = 0;
        Integer limit = 5;

        leagueService.upsertRanking();

        //given
        summonerService.upsertSummoner(name);

    }

    @Test
    public void test2() {
        LocalDateTime now = LocalDateTime.now();

        log.info("{}", now.atZone(ZoneId.of("Asia/Seoul")).toInstant().toEpochMilli());
        //given

        //when

        //then

    }
}
