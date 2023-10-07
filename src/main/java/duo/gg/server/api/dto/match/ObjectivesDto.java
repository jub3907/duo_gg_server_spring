package duo.gg.server.api.dto.match;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ObjectivesDto {

    public ObjectiveDto baron;
    public ObjectiveDto champion;
    public ObjectiveDto dragon;
    public ObjectiveDto inhibitor;
    public ObjectiveDto riftHerald;
    public ObjectiveDto tower;
}
