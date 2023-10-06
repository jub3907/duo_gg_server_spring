package duo.gg.server.api.dto.match;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class MetadataDto {

    public String dataVersion;
    public String matchId;
    public List<String> participants;

}

