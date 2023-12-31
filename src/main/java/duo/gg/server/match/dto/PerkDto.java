package duo.gg.server.match.dto;

import duo.gg.server.match.entity.Perk;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PerkDto {
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

    public PerkDto(Perk perk) {
        offense = perk.getOffense();
        flex = perk.getFlex();
        defense = perk.getDefense();
        primaryStyle = perk.getPrimaryStyle();
        primary_1 = perk.getPrimary_1();
        primary_2 = perk.getPrimary_2();
        primary_3 = perk.getPrimary_3();
        subStyle = perk.getSubStyle();
        sub_1 = perk.getSub_1();
        sub_2 = perk.getSub_2();
    }
}
