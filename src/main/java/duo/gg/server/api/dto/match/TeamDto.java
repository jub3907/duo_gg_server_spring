package duo.gg.server.api.dto.match;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class TeamDto {
    public List<BanDto> bans;
    public ObjectivesDto objectives;
    public int teamId;
    public boolean win;
}
