package duo.gg.server;

import duo.gg.server.mastery.Mastery;
import duo.gg.server.mastery.MasteryRepository;
import duo.gg.server.mastery.MasteryService;
import duo.gg.server.mastery.dto.MasteryDto;
import duo.gg.server.summoner.SummonerService;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static duo.gg.server.TestConstant.*;
import static org.assertj.core.api.Assertions.*;

@Slf4j
@SpringBootTest
public class MasteryTest {

    @Autowired
    MasteryService masteryService;

    @Autowired
    MasteryRepository masteryRepository;

    @Autowired
    SummonerService summonerService;

    @Test
    @Rollback(value = false)
    public void MasteryTest() {
        //given
        masteryService.upsertMasteriesByPuuid(puuid);

        //when
        List<MasteryDto> masteriesByPuuid = masteryService.findMasteriesByPuuid(puuid, 10);
        List<MasteryDto> masteriesByName = masteryService.findMasteriesByName(name, 10);
        List<MasteryDto> masteriesBySummonerId = masteryService.findMasteriesBySummonerId(summonerId, 10);

        //then
        assertThat(masteriesByPuuid.size()).isEqualTo(10);
        assertThat(masteriesByName.size()).isEqualTo(10);
        assertThat(masteriesBySummonerId.size()).isEqualTo(10);


    }

}
