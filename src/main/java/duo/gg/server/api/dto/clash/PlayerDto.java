package duo.gg.server.api.dto.clash;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDto {

    private String summonerId;

    private String teamId;

    private String position;

    private String role;
}
