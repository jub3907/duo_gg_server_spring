package duo.gg.server.api.dto.clash;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDto {

    public String summonerId;

    public String teamId;

    public String position;

    public String role;
}
