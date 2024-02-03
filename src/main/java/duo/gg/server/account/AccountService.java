package duo.gg.server.account;

import duo.gg.server.account.dto.AccountDto;
import duo.gg.server.account.entity.Account;
import duo.gg.server.api.dto.account.AccountApiResult;
import duo.gg.server.api.service.ApiService;
import duo.gg.server.comment.error.NoSummonerInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountService {

    private final ApiService apiService;
    private final AccountRepository repository;

    public void upsertAccountByRiotId(String gameName, String tagLine) {
        AccountApiResult apiResult = apiService.getAccountByRiotId(gameName, tagLine == null ? "KR1" : tagLine);

        Optional<Account> findAccount = repository.findByPuuid(apiResult.getPuuid());
        if (findAccount.isEmpty()) {
            Account account = new Account(apiResult);
            repository.save(account);
        } else {
            findAccount.get().updateByApiResult(apiResult);
        }
    }

    public void upsertAccountByPuuid(String puuid) {
        AccountApiResult apiResult = apiService.getAccountByPuuid(puuid);

        Optional<Account> findAccount = repository.findByPuuid(apiResult.getPuuid());
        if (findAccount.isEmpty()) {
            Account account = new Account(apiResult);
            repository.save(account);
        } else {
            findAccount.get().updateByApiResult(apiResult);
        }
    }


    public AccountDto getAccountByRiotId(String gameName, String tagLine) {
        Optional<Account> findAccount = repository.findByRiotId(gameName, tagLine);
        return findAccount.map(AccountDto::new).orElseThrow(NoSummonerInfo::new);
    }

    public AccountDto getAccountByPuuid(String puuid) {
        Optional<Account> findAccount = repository.findByPuuid(puuid);
        return findAccount.map(AccountDto::new).orElseThrow(NoSummonerInfo::new);
    }

}
