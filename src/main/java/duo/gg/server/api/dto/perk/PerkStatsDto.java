package duo.gg.server.api.dto.perk;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PerkStatsDto {
    public int defense;
    public int flex;
    public int offense;
}
