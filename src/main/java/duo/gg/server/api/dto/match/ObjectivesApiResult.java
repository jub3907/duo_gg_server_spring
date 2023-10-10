package duo.gg.server.api.dto.match;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ObjectivesApiResult {

    private ObjectiveApiResult baron;
    private ObjectiveApiResult champion;
    private ObjectiveApiResult dragon;
    private ObjectiveApiResult inhibitor;
    private ObjectiveApiResult riftHerald;
    private ObjectiveApiResult tower;
}
