package duo.gg.server.mastery;

import duo.gg.server.common.Result;
import duo.gg.server.mastery.dto.MasteryDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MasteryController {

    private final MasteryRepository repository;
    private final MasteryService service;


    @PostMapping("/mastery/by-puuid/{puuid}")
    public void upsertByPuuid(@PathVariable String puuid) {
        service.upsertMasteryByPuuid(puuid);
    }

    @PostMapping("/mastery/by-summoner/{summonerId}")
    public void upsertBySummonerId(@PathVariable String summonerId) {
        service.upsertMasteryBySummonerId(summonerId);
    }

    //TODO: Get - puuid / id, count?를 사용해 챔피언 숙련도 가져오기
    //챔피언이름, 점수, 레벨, 마지막 플레이 시간

    @GetMapping("/mastery/by-name/{name}")
    public Result<MasteryDto> getByName(@PathVariable String name, @RequestParam int limit) {
        return new Result<MasteryDto>(
                new MasteryDto().masteryMapper(
                        repository.findByName(name, limit)
                )
        );
    }
}
