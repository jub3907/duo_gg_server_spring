package duo.gg.server.api.dto.match;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MatchDto {
    public MetadataDto metadata;

    public InfoDto info;
}
