package duo.gg.server.api.dto.perk;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PerkStyleDto {
    public String description;
    public List<PerkStyleSelectionDto> selections;
    public int style;
}
