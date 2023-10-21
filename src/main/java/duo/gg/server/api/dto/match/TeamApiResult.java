package duo.gg.server.api.dto.match;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TeamApiResult {
    private List<BanApiResult> bans;
    private ObjectivesApiResult objectives;
    private Integer teamId;
    private Boolean win;
}
