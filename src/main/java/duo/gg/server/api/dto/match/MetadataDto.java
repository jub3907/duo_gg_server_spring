package duo.gg.server.api.dto.match;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MetadataDto {

    public String dataVersion;
    public String matchId;
    public List<String> participants;

}

