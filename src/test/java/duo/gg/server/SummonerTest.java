package duo.gg.server;

import duo.gg.server.summoner.SummonerRepository;
import duo.gg.server.summoner.SummonerService;
import duo.gg.server.summoner.dto.SummonerDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@Slf4j
@Transactional
@SpringBootTest
public class SummonerTest {
    @Autowired
    SummonerService service;

    @Autowired
    SummonerRepository repository;

//    @Test
//    @Rollback(value = false)
//    public void upsertSummoner() {
//        String name = "스트레스유발협곡";
//        String summonerId = "SRL_HuA_zVNrjtrC1KG7agCfgEH53gwqBc3OT5qWGKkA5Pc";
//        //given
//        service.upsertSummonerByName(name);
//
//        //when
//        SummonerDto summoner = service.getSummonerByName(name);
//
//        //then
//        assertThat(summoner.getSummonerId()).isEqualTo(summonerId);
//    }

//    @Test
//    public void upsertSummonerByPuuid() {
//        String name = "Radiohead";
//        String tagLine = "KR1";
//        String puuid = "qgTVX3hVfRwxEfMUB_tGNN3rzTjPcy8GeRxlIsZw-vwJBFhKwXTYQLM1Zl10lgaXq2NODmkOO_TkAQ";
//
//        service.upsertSummonerByPuuid(puuid);
//        SummonerDto summoner = service.getSummonerByPuuid(puuid);
//        assertThat(summoner.getName()).isEqualTo(name);
//
//    }
}
