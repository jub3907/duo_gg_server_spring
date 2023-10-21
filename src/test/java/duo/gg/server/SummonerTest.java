package duo.gg.server;

import duo.gg.server.summoner.SummonerRepository;
import duo.gg.server.summoner.SummonerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class SummonerTest {

    @Autowired
    SummonerService service;

    @Autowired
    SummonerRepository repository;
}
