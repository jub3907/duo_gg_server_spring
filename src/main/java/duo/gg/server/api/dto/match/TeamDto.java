package duo.gg.server.api.dto.match;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TeamDto {
    public List<BanDto> bans;
    public ObjectivesDto objectives;
    public int teamId;
    public boolean win;
}
