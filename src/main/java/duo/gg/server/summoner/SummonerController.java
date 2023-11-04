package duo.gg.server.summoner;

import duo.gg.server.common.ResponseBody;
import duo.gg.server.summoner.dto.SummonerDto;
import duo.gg.server.summoner.entity.Summoner;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @PostMapping("/summoner/{name}")
    public ResponseEntity<String> upsertByName(@PathVariable String name) {
        service.upsertSummoner(name);
        return new ResponseEntity<>(ResponseBody.SUCCESS, HttpStatus.OK);
    }

    @GetMapping("/summoner/{name}")
    public SummonerDto findByName(@PathVariable String name) {
        return service.getSummonerByName(name);
    }
}
