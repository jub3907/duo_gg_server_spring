package duo.gg.server.api.dto.match;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BanApiResult {
    private Integer championId;
    private Integer pickTurn;
}
