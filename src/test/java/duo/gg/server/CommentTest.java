package duo.gg.server;

import duo.gg.server.comment.CommentRepository;
import duo.gg.server.comment.CommentService;
import duo.gg.server.comment.dto.CommentDeleteForm;
import duo.gg.server.comment.dto.CommentDto;
import duo.gg.server.comment.dto.CommentForm;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static duo.gg.server.TestConstant.*;

@Slf4j
@Transactional
@SpringBootTest
public class CommentTest {

    @Autowired
    CommentService service;

    @Autowired
    CommentRepository repository;

//    @Test
//    public void CommentTest() {
//        //given
//        CommentForm form1 = new CommentForm(nickname + "1", password, content);
//        CommentForm form2 = new CommentForm(nickname + "2", password, content);
//        CommentForm form3 = new CommentForm(nickname + "3", password, content);
//        CommentForm form4 = new CommentForm(nickname + "4", password, content);
//        CommentForm form5 = new CommentForm(nickname + "5", password, content);
//
//        service.create(puuid, form1);
//        service.create(puuid, form2);
//        service.create(puuid, form3);
//        service.create(puuid, form4);
//        service.create(puuid, form5);
//
//        //when
//
//        List<CommentDto> comments = service.findByPuuidPaging(name, 0, 5);
//        CommentDeleteForm deleteForm = new CommentDeleteForm(password);
//
//        service.delete(comments.get(0).getCommentId(), deleteForm);
//
//        List<CommentDto> commentsAfterDelete = service.findByPuuidPaging(name, 0, 5);
//
//
//        //then
//        Assertions.assertThat(comments.size()).isEqualTo(5);
//        Assertions.assertThat(commentsAfterDelete.size()).isEqualTo(5);
//    }
}
