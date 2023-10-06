package duo.gg.server.api.dto.league;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MiniSeriesDto {

    public String progress;
    public int target;
    public int wins;
    public int losses;
}
