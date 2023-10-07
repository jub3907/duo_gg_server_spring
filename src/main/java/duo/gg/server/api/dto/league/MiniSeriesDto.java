package duo.gg.server.api.dto.league;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MiniSeriesDto {

    public String progress;
    public int target;
    public int wins;
    public int losses;
}
