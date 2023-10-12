package duo.gg.server;

import duo.gg.server.comment.CommentRepository;
import duo.gg.server.comment.CommentService;
import duo.gg.server.comment.constant.CommentPosition;
import duo.gg.server.comment.constant.CommentRankType;
import duo.gg.server.comment.dto.CommentDto;
import duo.gg.server.comment.dto.CommentForm;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Slf4j
@Transactional
public class CommentTest {

    @Autowired
    CommentService service;

    @Autowired
    CommentRepository repository;

    @Test
    @Rollback(value = false)
    public void pagingTest() {
        //given
        CommentForm form = new CommentForm(CommentRankType.SOLO, CommentPosition.AD, "21세기광부", "다이아", "안녕하세요");
        CommentForm form2 = new CommentForm(CommentRankType.SOLO, CommentPosition.ALL, "21세기광부", "다이아", "안녕하세요");
        CommentForm form3 = new CommentForm(CommentRankType.TEAM, CommentPosition.MID, "21세기광부", "다이아", "안녕하세요");
        CommentForm form4 = new CommentForm(CommentRankType.TEAM, CommentPosition.TOP, "21세기광부", "다이아", "안녕하세요");
        CommentForm form5 = new CommentForm(CommentRankType.NORMAL, CommentPosition.JUNGLE, "21세기광부", "다이아", "안녕하세요");
        service.save(form);
        service.save(form2);
        service.save(form3);
        service.save(form4);
        service.save(form5);

        //when
        List<CommentDto> findComments = service.findByPage(0, 3);

        //then
        Assertions.assertThat(findComments.size()).isEqualTo(3);

    }

}
