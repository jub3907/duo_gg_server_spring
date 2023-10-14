package duo.gg.server;

import duo.gg.server.mastery.Mastery;
import duo.gg.server.mastery.MasteryRepository;
import duo.gg.server.mastery.MasteryService;
import duo.gg.server.summoner.SummonerService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

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
        String puuid = summonerService.getPuuidByName("21세기광부");
        masteryService.upsertMasteriesByPuuid(puuid);

        //when

        //then

    }

}
