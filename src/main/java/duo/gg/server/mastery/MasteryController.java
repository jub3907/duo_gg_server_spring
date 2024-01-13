package duo.gg.server.mastery;

import duo.gg.server.common.ResponseBody;
import duo.gg.server.mastery.dto.MasteryDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> upsertByPuuid(@PathVariable String puuid) {
        service.upsertMasteriesByPuuid(puuid);
        return new ResponseEntity<>(ResponseBody.SUCCESS, HttpStatus.OK);
    }

//    @Transactional
//    @PostMapping("/mastery/by-summoner/{summonerId}")
//    public ResponseEntity<String> upsertBySummonerId(@PathVariable String summonerId) {
//        service.upsertMasteriesBySummonerId(summonerId);
//        return new ResponseEntity<>(ResponseBody.SUCCESS, HttpStatus.OK);
//    }

//    @Transactional
//    @PostMapping("/mastery/by-name/{name}")
//    public ResponseEntity<String> upsertByName(@PathVariable String name) {
//        service.upsertMasteriesByName(name);
//        return new ResponseEntity<>(ResponseBody.SUCCESS, HttpStatus.OK);
//    }

    @GetMapping("/mastery/by-puuid/{puuid}")
    public List<MasteryDto> getByPuuid(@PathVariable String puuid, @RequestParam(required = false) Integer limit) {
        return service.findMasteriesByPuuid(puuid, limit);
    }

//    @GetMapping("/mastery/by-summoner/{summonerId}")
//    public List<MasteryDto> getBySummonerId(@PathVariable String summonerId, @RequestParam(required = false) Integer limit) {
//        return service.findMasteriesBySummonerId(summonerId, limit);
//    }
//
//    @GetMapping("/mastery/by-name/{name}")
//    public List<MasteryDto> getByName(@PathVariable String name, @RequestParam(required = false) Integer limit) {
//        return service.findMasteriesByName(name, limit);
//    }
}
