package duo.gg.server.api.dto.league;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MiniSeriesApiResult {

    private String progress;
    private int target;
    private int wins;
    private int losses;
}
