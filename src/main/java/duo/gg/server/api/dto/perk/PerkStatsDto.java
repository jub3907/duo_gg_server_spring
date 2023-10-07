package duo.gg.server.api.dto.perk;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PerkStatsDto {
    public int defense;
    public int flex;
    public int offense;
}
