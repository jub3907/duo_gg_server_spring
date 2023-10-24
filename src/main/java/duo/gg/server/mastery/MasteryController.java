package duo.gg.server.mastery;

import duo.gg.server.common.Result;
import duo.gg.server.mastery.dto.MasteryDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
public class MasteryController {

    private final MasteryService service;


    @Transactional
    @PostMapping("/mastery/by-puuid/{puuid}")
    public void upsertByPuuid(@PathVariable String puuid) {
        service.upsertMasteriesByPuuid(puuid);
    }

    @Transactional
    @PostMapping("/mastery/by-summoner/{summonerId}")
    public void upsertBySummonerId(@PathVariable String summonerId) {
        service.upsertMasteriesBySummonerId(summonerId);
    }

    @Transactional
    @PostMapping("/mastery/by-name/{name}")
    public void upsertByName(@PathVariable String name) {
        service.upsertMasteriesByName(name);
    }

    @GetMapping("/mastery/by-puuid/{puuid}")
    public List<MasteryDto> getByPuuid(@PathVariable String puuid, @RequestParam(required = false) Integer limit) {
        return service.findMasteriesByPuuid(puuid, limit);
    }

    @GetMapping("/mastery/by-summoner/{summonerId}")
    public List<MasteryDto> getBySummonerId(@PathVariable String summonerId, @RequestParam(required = false) Integer limit) {
        return service.findMasteriesBySummonerId(summonerId, limit);
    }

    @GetMapping("/mastery/by-name/{name}")
    public List<MasteryDto> getByName(@PathVariable String name, @RequestParam(required = false) Integer limit) {
        return service.findMasteriesByName(name, limit);
    }
}
