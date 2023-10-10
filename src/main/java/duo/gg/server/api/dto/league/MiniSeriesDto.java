package duo.gg.server.api.dto.league;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MiniSeriesDto {

    private String progress;
    private int target;
    private int wins;
    private int losses;
}
