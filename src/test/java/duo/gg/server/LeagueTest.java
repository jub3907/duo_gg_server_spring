package duo.gg.server;


import duo.gg.server.league.LeagueRepository;
import duo.gg.server.league.LeagueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class LeagueTest {

    @Autowired
    LeagueService service;

    @Autowired
    LeagueRepository repository;
}
