package duo.gg.server.api.dto.perk;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PerksDto {
    public PerkStatsDto statPerks;
    public PerkStyleDto styles;
}
