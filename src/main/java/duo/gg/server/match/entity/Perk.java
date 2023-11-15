package duo.gg.server.match.entity;

import duo.gg.server.api.dto.perk.PerkStyleApiResult;
import duo.gg.server.api.dto.perk.PerksApiResult;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Perk {
//    @Id @GeneratedValue
//    @Column(name = "perk_id")
//    private Long id;

    private Integer offense;
    private Integer flex;
    private Integer defense;

    private Integer primaryStyle;
    private Integer primary_1;
    private Integer primary_2;
    private Integer primary_3;

    private Integer subStyle;
    private Integer sub_1;
    private Integer sub_2;

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
