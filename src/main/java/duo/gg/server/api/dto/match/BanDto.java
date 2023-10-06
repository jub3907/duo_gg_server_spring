package duo.gg.server.api.dto.match;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BanDto {
    public int championId;
    public int pickTurn;
}
