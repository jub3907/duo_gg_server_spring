package duo.gg.server.summoner;

import duo.gg.server.api.dto.summoner.SummonerApiResult;
import duo.gg.server.api.service.ApiService;
import duo.gg.server.comment.error.NoSummonerInfo;
import duo.gg.server.summoner.dto.SummonerDto;
import duo.gg.server.summoner.entity.Summoner;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class SummonerService {

    private final ApiService apiService;
    private final SummonerRepository summonerRepository;

    public void upsertSummonerByName(String name) {

        SummonerApiResult summonerApiResult = apiService.getSummonerBySummonerName(name);

        Optional<Summoner> findSummoner = summonerRepository.findById(summonerApiResult.getId());

        if (findSummoner.isEmpty()) {
            log.info("Error: summoner not found, {}", name);
            Summoner summoner = new Summoner(summonerApiResult);
            summonerRepository.save(summoner);
        } else {
            findSummoner.get()
                    .updateByApiResult(summonerApiResult);
        }
    }

    public String getPuuidByName(String name) {
        Optional<Summoner> findSummoner = summonerRepository.findByName(name);

        if (findSummoner.isEmpty()) {
            log.info("Error: summoner not found, {}", name);
            return apiService.getSummonerBySummonerName(name).getPuuid();
        } else {
            return findSummoner.get().getPuuid();
        }
    }

    public String getSummonerIdByName(String name) {
        Optional<Summoner> findSummoner = summonerRepository.findByName(name);

        if (findSummoner.isEmpty()) {
            log.info("Error: summoner not found, {}", name);
            return apiService.getSummonerBySummonerName(name).getId();
        } else {
            return findSummoner.get().getId();
        }
    }

    public SummonerDto getSummonerByName(String name) {
        Optional<Summoner> findSummoner = summonerRepository.findByName(name);
        return findSummoner.map(SummonerDto::new).orElseThrow(NoSummonerInfo::new);
    }


    public void upsertSummonerByPuuid(String puuid) {

        SummonerApiResult summonerApiResult = apiService.getSummonerByPuuid(puuid);

        Optional<Summoner> findSummoner = summonerRepository.findById(summonerApiResult.getId());

        if (findSummoner.isEmpty()) {
            log.info("Error: summoner not found, {}", puuid);
            Summoner summoner = new Summoner(summonerApiResult);
            summonerRepository.save(summoner);
        } else {
            findSummoner.get()
                    .updateByApiResult(summonerApiResult);
        }
    }

    public String getSummonerIdByPuuid(String puuid) {
        Optional<Summoner> findSummoner = summonerRepository.findByPuuid(puuid);

        if (findSummoner.isEmpty()) {
            log.info("Error: summoner not found, {}", puuid);
            return apiService.getSummonerBySummonerName(puuid).getId();
        } else {
            return findSummoner.get().getId();
        }
    }

    public SummonerDto getSummonerByPuuid(String puuid) {
        Optional<Summoner> findSummoner = summonerRepository.findByPuuid(puuid);
        return findSummoner.map(SummonerDto::new).orElseThrow(NoSummonerInfo::new);
    }
}
