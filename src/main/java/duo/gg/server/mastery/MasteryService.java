package duo.gg.server.mastery;

import duo.gg.server.api.dto.mastery.MasteryApiResult;
import duo.gg.server.api.service.ApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MasteryService {

    private final MasteryRepository masteryRepository;
    private final ApiService apiService;
    
    public void upsertMasteryByPuuid(String puuid) {
        List<MasteryApiResult> masteryApiResult = apiService.getMasteriesByPuuid(puuid);

        List<Mastery> findMastery = masteryRepository.findByPuuid(puuid);

        //TODO
    }

    public void upsertMasteryBySummonerId(String summonerId) {
        List<MasteryApiResult> masteryApiResult = apiService.getMasteriesBySummonerId(summonerId);

        List<Mastery> findMastery = masteryRepository.findBySummonerId(summonerId);

        //TODO
    }
}
