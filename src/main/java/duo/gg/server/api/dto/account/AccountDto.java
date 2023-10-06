package duo.gg.server.api.dto.account;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AccountDto {
    public String puuid;

    // This field may be excluded from the response if the account doesn't have a gameName.
    public String gameName;

    // This field may be excluded from the response if the account doesn't have a gameName.
    public String tagLine;
}
