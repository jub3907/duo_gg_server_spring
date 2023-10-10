package duo.gg.server.api.dto.clash;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PlayerApiResult {

    private String summonerId;

    private String teamId;

    private String position;

    private String role;
}
