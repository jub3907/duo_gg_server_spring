package duo.gg.server.account;

import duo.gg.server.account.dto.AccountDto;
import duo.gg.server.common.ResponseBody;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AccountContoller {

    public final AccountService service;

    @Transactional
    @PostMapping("/account/by-riot-id")
    public ResponseEntity<String> upsertByRiotId(@RequestParam String gameName, @RequestParam(required = false) String tagLine) {
        service.upsertAccount(gameName, tagLine);
        return new ResponseEntity<>(ResponseBody.SUCCESS, HttpStatus.OK);
    }

    @GetMapping("/account/by-riot-id")
    public AccountDto findByRiotId(@RequestParam String gameName, @RequestParam(required = false) String tagLine) {
        return service.getAccountByRiotId(gameName, tagLine);
    }
}
