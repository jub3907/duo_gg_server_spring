package duo.gg.server.api.dto.perk;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PerkStatsDto {
    private int defense;
    private int flex;
    private int offense;
}
