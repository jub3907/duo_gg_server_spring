package duo.gg.server.summoner;

import duo.gg.server.api.dto.summoner.SummonerApiResult;
import duo.gg.server.api.service.ApiService;
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

    public void upsertSummoner(String name) {

        SummonerApiResult summonerApiResult = apiService.getSummonerBySummonerName(name);

        Optional<Summoner> findSummoner = summonerRepository.findById(summonerApiResult.getId());

        if (findSummoner.isEmpty()) {
            Summoner summoner = new Summoner(summonerApiResult);
            summonerRepository.save(summoner);
        } else {
            findSummoner.get()
                    .updateByApiResult(summonerApiResult);
        }
    }
}
