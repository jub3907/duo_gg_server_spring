package duo.gg.server.api.dto.clash;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PlayerDto {

    public String summonerId;

    public String teamId;

    public String position;

    public String role;
}
