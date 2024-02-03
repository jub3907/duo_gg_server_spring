package duo.gg.server.account;

import duo.gg.server.account.dto.AccountDto;
import duo.gg.server.account.entity.Account;
import duo.gg.server.common.ResponseBody;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AccountContoller {

    public final AccountService service;

    @Transactional
    @PostMapping("/account/by-riot-id")
    public ResponseEntity<String> upsertByRiotId(@RequestParam String gameName, @RequestParam(required = false) String tagLine) {
        service.upsertAccountByRiotId(gameName, tagLine);
        return new ResponseEntity<>(ResponseBody.SUCCESS, HttpStatus.OK);
    }

    @GetMapping("/account/by-riot-id")
    public AccountDto findByRiotId(@RequestParam String gameName, @RequestParam(required = false) String tagLine) {
        return service.getAccountByRiotId(gameName, tagLine);
    }

    @Transactional
    @PostMapping("/account/by-puuid")
    public ResponseEntity<String> upsertByPuuid(@RequestParam String puuid) {
        service.upsertAccountByPuuid(puuid);
        return new ResponseEntity<>(ResponseBody.SUCCESS, HttpStatus.OK);
    }

    @GetMapping("/account/by-puuid")
    public AccountDto findByRiotId(@RequestParam String puuid) {
        return service.getAccountByPuuid(puuid);
    }
}
