package duo.gg.server;

import duo.gg.server.match.MatchRepository;
import duo.gg.server.match.MatchService;
import duo.gg.server.match.entity.MatchInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static duo.gg.server.TestConstant.*;
import static org.assertj.core.api.Assertions.*;

@Slf4j
@Transactional
@SpringBootTest
public class MatchInfoTest {

    @Autowired
    MatchService service;

    @Autowired
    MatchRepository repository;

    @Test
    @Rollback(value = false)
    public void updateAndGetRecentMatches() {
        //given
        List<String> ids = service.getMatchIdsByPuuid(puuid, 0, 3);
        List<String> matchIdsNotInDb = service.getMatchIdsNotInDb(ids);

        service.updateMatches(matchIdsNotInDb);
        //when

        List<String> recentMatchIds = service.getMatchIdsByPuuid(puuid, 0, 3);
        List<MatchInfo> matches = repository.findByIds(recentMatchIds);

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
