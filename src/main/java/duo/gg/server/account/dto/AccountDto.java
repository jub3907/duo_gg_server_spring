package duo.gg.server.account.dto;

import duo.gg.server.account.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {

    private String puuid;
    private String gameName;
    private String tagLine;

    public AccountDto(Account account) {
        this.puuid = account.getPuuid();
        this.gameName = account.getGameName();
        this.tagLine = account.getTagLine();
    }
}
