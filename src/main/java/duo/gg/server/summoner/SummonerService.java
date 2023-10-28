package duo.gg.server.summoner;

import duo.gg.server.api.dto.summoner.SummonerApiResult;
import duo.gg.server.api.service.ApiService;
import duo.gg.server.league.LeagueRepository;
import duo.gg.server.league.dto.RankingDto;
import duo.gg.server.summoner.dto.SummonerDto;
import duo.gg.server.summoner.entity.Summoner;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public String getPuuidByName(String name) {
        Optional<Summoner> findSummoner = summonerRepository.findByName(name);

        if (findSummoner.isEmpty()) {
            return apiService.getSummonerBySummonerName(name).getPuuid();
        } else {
            return findSummoner.get().getPuuid();
        }
    }

    public String getSummonerIdByName(String name) {
        Optional<Summoner> findSummoner = summonerRepository.findByName(name);

        if (findSummoner.isEmpty()) {
            return apiService.getSummonerBySummonerName(name).getId();
        } else {
            return findSummoner.get().getId();
        }
    }

    public SummonerDto getSummonerByName(String name) {
        Optional<Summoner> findSummoner = summonerRepository.findByName(name);
        return findSummoner.map(SummonerDto::new).orElse(null);
    }
}
