package duo.gg.server.league;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
@RequiredArgsConstructor
public class RankingScheduler {

    private final RankingService service;

    @Transactional
    @Scheduled(initialDelay = 1000, fixedDelay = 600000)
    public void updateRanking() {
        service.upsertRanking();
        log.info("ranking updated");
    }

}
