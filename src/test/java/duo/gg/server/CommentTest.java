package duo.gg.server;

import duo.gg.server.comment.Comment;
import duo.gg.server.comment.CommentRepository;
import duo.gg.server.comment.CommentService;
import duo.gg.server.comment.dto.CommentDeleteForm;
import duo.gg.server.comment.dto.CommentDto;
import duo.gg.server.comment.dto.CommentForm;
import duo.gg.server.constant.TierEnum;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Transactional
@SpringBootTest
public class CommentTest {
    private final String name = "21세기광부";
    private final String puuid = "WhX0_L0SzY-UpxFTZFvHASktCbDc-loiJln6RnMNU5Ptwj_6lw98sE-iOPamqp_GNs71T37LFIndLg";
    private final String summonerId = "JlGUV6boigRMNJTG25zAzGRjFMbwnl6XDKbbzqrShuH1Jw";
    private final String accountId = "274o8M0Xs6IGliyTC6k6t6DgKL3JZ6azB9hrR9eNECdL";
    private final String tagLine = "KR1";

    private final Long championId = 412L;
    private final String championName = "Thresh";

    private final String leagueId = "966df365-7dea-34ca-839a-2cec050ba64a";
    private final String leagueTier = TierEnum.CHALLENGER.name();

    private final String matchId = "KR_6730690706";
    private final String content = "content";
    private final String nickname = "nickname";
    private final String password = "password";

    @Autowired
    CommentService service;

    @Autowired
    CommentRepository repository;

    @Test
    public void CommentTest() {
        //given
        CommentForm form1 = new CommentForm(nickname + "1", password, content);
        CommentForm form2 = new CommentForm(nickname + "2", password, content);
        CommentForm form3 = new CommentForm(nickname + "3", password, content);
        CommentForm form4 = new CommentForm(nickname + "4", password, content);
        CommentForm form5 = new CommentForm(nickname + "5", password, content);

        service.create(puuid, form1);
        service.create(puuid, form2);
        service.create(puuid, form3);
        service.create(puuid, form4);
        service.create(puuid, form5);

        //when

        List<CommentDto> comments = service.findByNamePaging(name, 0, 5);
        CommentDeleteForm deleteForm = new CommentDeleteForm(password);

        service.delete(comments.get(0).getCommentId(), deleteForm);

        List<CommentDto> commentsAfterDelete = service.findByNamePaging(name, 0, 5);


        //then
        Assertions.assertThat(comments.size()).isEqualTo(5);
        Assertions.assertThat(commentsAfterDelete.size()).isEqualTo(5);
    }
}
