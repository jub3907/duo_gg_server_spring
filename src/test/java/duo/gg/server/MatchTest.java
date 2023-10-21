package duo.gg.server;

import duo.gg.server.match.MatchRepository;
import duo.gg.server.match.MatchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class MatchTest {

    @Autowired
    MatchService service;

    @Autowired
    MatchRepository repository;

}
