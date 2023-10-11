package duo.gg.server.match;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MatchController {
    //TODO: Post - puuid, start, count를 사용해 match ids api call
    //TODO: After, Match ID중 DB에 존재하지 않는 match들만 api call, DB Update

    //TODO: Get - name? puuid?, paging을 사용해 최근 전적 불러옴
    //리턴 내용은 추후 좀 더 고민.
}
