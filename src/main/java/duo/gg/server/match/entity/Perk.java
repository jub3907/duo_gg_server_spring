package duo.gg.server.match.entity;

import duo.gg.server.api.dto.perk.PerkStyleApiResult;
import duo.gg.server.api.dto.perk.PerksApiResult;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Perk {
    private int offense;
    private int flex;
    private int defense;

    private int primaryStyle;
    private int primary_1;
    private int primary_2;
    private int primary_3;

    private int subStyle;
    private int sub_1;
    private int sub_2;

    public Perk(PerksApiResult apiResult) {
        offense = apiResult.getStatPerks().getOffense();
        flex = apiResult.getStatPerks().getFlex();
        defense = apiResult.getStatPerks().getDefense();

        for (PerkStyleApiResult style : apiResult.getStyles()) {
            if (style.getDescription().equals("primaryStyle")) {
                primaryStyle = style.getStyle();
                primary_1 = style.getSelections().get(0).getPerk();
                primary_2 = style.getSelections().get(1).getPerk();
                primary_3 = style.getSelections().get(2).getPerk();
            } else {
                subStyle = style.getStyle();
                sub_1 = style.getSelections().get(0).getPerk();
                sub_2 = style.getSelections().get(1).getPerk();
            }
        }

    }
}
