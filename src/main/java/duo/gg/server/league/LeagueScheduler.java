package duo.gg.server.league;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LeagueScheduler {

    private final LeagueService service;

    @Scheduled(fixedDelay = 300000)
    public void updateRanking() {
        service.upsertRanking();
    }

}
