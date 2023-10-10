package duo.gg.server.api.dto.account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AccountApiResult {
    private String puuid;

    // This field may be excluded from the response if the account doesn't have a gameName.
    private String gameName;

    // This field may be excluded from the response if the account doesn't have a gameName.
    private String tagLine;
}
