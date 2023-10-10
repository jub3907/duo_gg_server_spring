package duo.gg.server.summoner;

import duo.gg.server.summoner.entity.Summoner;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
public class SummonerController {

    private final SummonerService service;
    private final SummonerRepository repository;

    @Transactional
    @PostMapping("/api/summoner/{name}")
    public void upsertByName(@PathVariable String name) {
        service.upsertSummoner(name);
    }

    // TODO: Entity to DTO
    @GetMapping("/api/summoner/{name}")
    public Summoner findByName(@PathVariable String name) {
        Optional<Summoner> byName = repository.findByName(name);
        log.info("{}", byName.get());
        return byName.get();
    }

}
