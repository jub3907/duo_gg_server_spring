package duo.gg.server.league;

import duo.gg.server.league.dto.RankingDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class RankingController {

    private final RankingService rankingService;

    @GetMapping("/ranking")
    public List<RankingDto> ranking(@RequestParam Integer offset, @RequestParam Integer limit) {
        return rankingService.getRanking(offset, limit);
    }

}
