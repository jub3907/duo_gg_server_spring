package duo.gg.server.summoner;

import duo.gg.server.summoner.entity.Summoner;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
@Transactional
class SummonerControllerTest {

    @Autowired
    SummonerRepository repository;

    @Autowired
    SummonerService service;

    @Test
    void upsertByName() {
    }

}