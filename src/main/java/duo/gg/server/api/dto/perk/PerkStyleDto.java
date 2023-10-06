package duo.gg.server.api.dto.perk;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PerkStyleDto {
    public String description;
    public List<PerkStyleSelectionDto> selections;
    public int style;
}
