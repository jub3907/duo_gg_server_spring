package duo.gg.server.datadragon.service;

import duo.gg.server.api.constant.DivisionEnum;
import duo.gg.server.api.constant.QueueEnum;
import duo.gg.server.api.constant.TierEnum;
import duo.gg.server.api.dto.account.AccountDto;
import duo.gg.server.api.dto.champion.ChampionInfoDto;
import duo.gg.server.api.dto.championMastery.ChampionMasteryDto;
import duo.gg.server.api.dto.league.LeagueEntryDto;
import duo.gg.server.api.dto.league.LeagueListDto;
import duo.gg.server.api.dto.match.MatchDto;
import duo.gg.server.api.dto.match.MatchTimelineDto;
import duo.gg.server.api.dto.summoner.SummonerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class DDService {

    @Value("${riot.api-key}")
    private String apiKey;

    private WebClient getWebClient(String baseUrl) {
        return getWebClient(baseUrl, null);
    }

    private ExchangeStrategies getExchangeStrategies() {
        return ExchangeStrategies.builder()
                .codecs(codecConfigure ->
                        codecConfigure
                        .defaultCodecs()
                        .maxInMemorySize(10 * 1024 * 1024))
                .build();
    }

    private WebClient getWebClient(String baseUrl, String token) {
        return WebClient.builder()
                .baseUrl(baseUrl)
                .defaultHeaders(
                        httpHeaders -> {
                            httpHeaders.add("Accept-Language", "ko,en-US;q=0.9,en;q=0.8,ko-KR;q=0.7,vi;q=0.6");
                            httpHeaders.add("Accept-Charset", "application/x-www-form-urlencoded; charset=UTF-8");
                            httpHeaders.add("Origin", "https://developer.riotgames.com");
                            httpHeaders.add("X-Riot-Token", apiKey);
                            if (token != null) {
                                httpHeaders.add("Authorization", token);
                            }
                        }
                )
                .exchangeStrategies(getExchangeStrategies())
                .build();
    }

    // TODO: Data Dragon 구현 고민 필요.
}
