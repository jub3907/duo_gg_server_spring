package duo.gg.server.api.dto.account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    public String puuid;

    // This field may be excluded from the response if the account doesn't have a gameName.
    public String gameName;

    // This field may be excluded from the response if the account doesn't have a gameName.
    public String tagLine;
}
