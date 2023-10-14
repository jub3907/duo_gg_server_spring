package duo.gg.server.mastery;

import duo.gg.server.api.dto.mastery.MasteryApiResult;
import duo.gg.server.api.service.ApiService;
import duo.gg.server.common.Result;
import duo.gg.server.mastery.dto.MasteryDto;
import duo.gg.server.summoner.SummonerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class MasteryService {

    private final MasteryRepository masteryRepository;
    private final ApiService apiService;
    private final SummonerService summonerService;

    public void upsertMasteriesByName(String name) {
        String puuid = summonerService.getPuuidByName(name);
        upsertMasteriesByPuuid(puuid);
    }
    
    public void upsertMasteriesByPuuid(String puuid) {
        List<MasteryApiResult> masteryApiResult = apiService.getMasteriesByPuuid(puuid);

        List<Mastery> findMastery = masteryRepository.findByPuuid(puuid);

        if (findMastery.size() == 0) {
            masteryRepository.insertMasteriesByApiResults(masteryApiResult);
        } else {
            masteryRepository.upsertMasteries(masteryApiResult, findMastery);
        }
    }

    public void upsertMasteriesBySummonerId(String summonerId) {
        List<MasteryApiResult> masteryApiResult = apiService.getMasteriesBySummonerId(summonerId);

        List<Mastery> findMastery = masteryRepository.findBySummonerId(summonerId);

        if (findMastery.size() == 0) {
            masteryRepository.insertMasteriesByApiResults(masteryApiResult);
        } else {
            masteryRepository.upsertMasteries(masteryApiResult, findMastery);
        }
    }


    public Result<MasteryDto> findMasteriesByPuuid(String puuid, Integer limit) {
        if (limit == null) {
            return new Result<MasteryDto>(
                    new MasteryDto().masteryMapper(
                            masteryRepository.findByPuuid(puuid)
                    )
            );
        } else {
            return new Result<MasteryDto>(
                    new MasteryDto().masteryMapper(
                            masteryRepository.findByPuuid(puuid, limit)
                    )
            );
        }
    }

    public Result<MasteryDto> findMasteriesBySummonerId(String summonerId, Integer limit) {
        if (limit == null) {
            return new Result<MasteryDto>(
                    new MasteryDto().masteryMapper(
                            masteryRepository.findBySummonerId(summonerId)
                    )
            );
        } else {
            return new Result<MasteryDto>(
                    new MasteryDto().masteryMapper(
                            masteryRepository.findBySummonerId(summonerId, limit)
                    )
            );
        }
    }

    public Result<MasteryDto> findMasteriesByName(String name, Integer limit) {
        String puuid = summonerService.getPuuidByName(name);

        if (limit == null) {
            return new Result<MasteryDto>(
                    new MasteryDto().masteryMapper(
                            masteryRepository.findByPuuid(puuid)
                    )
            );
        } else {
            return new Result<MasteryDto>(
                    new MasteryDto().masteryMapper(
                            masteryRepository.findByPuuid(puuid, limit)
                    )
            );
        }
    }

}
