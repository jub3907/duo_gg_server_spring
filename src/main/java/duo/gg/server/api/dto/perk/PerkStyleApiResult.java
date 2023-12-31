package duo.gg.server.api.dto.perk;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PerkStyleApiResult {
    private String description;
    private List<PerkStyleSelectionApiResult> selections;
    private Integer style;
}
