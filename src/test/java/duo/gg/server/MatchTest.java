package duo.gg.server;

import duo.gg.server.match.MatchRepository;
import duo.gg.server.match.MatchService;
import duo.gg.server.match.entity.Match;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static duo.gg.server.TestConstant.*;
import static org.assertj.core.api.Assertions.*;

@Slf4j
@SpringBootTest
public class MatchTest {

    @Autowired
    MatchService service;

    @Autowired
    MatchRepository repository;

    @Test
    public void updateAndGetRecentMatches() {
        //given
        List<String> ids = service.getMatchIdsByPuuid(puuid, 0, 3);
        List<String> matchIdsNotInDb = service.getMatchIdsNotInDb(ids);

        service.updateMatches(matchIdsNotInDb);
        //when

        List<String> recentMatchIds = service.getMatchIdsByPuuid(puuid, 0, 3);
        List<Match> matches = repository.findByIds(recentMatchIds);

        //then
        assertThat(ids.size()).isEqualTo(3);
        assertThat(matchIdsNotInDb.size()).isLessThanOrEqualTo(3);
        assertThat(matches.size()).isLessThanOrEqualTo(3);

    }

    @Test
    public void getMatchDetail() {
        //TODO: 추가
        //given

        //when

        //then

    }




}
