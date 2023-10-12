package duo.gg.server;

import duo.gg.server.post.PostRepository;
import duo.gg.server.post.PostService;
import duo.gg.server.post.contant.PostPosition;
import duo.gg.server.post.contant.PostRankType;
import duo.gg.server.post.dto.PostDto;
import duo.gg.server.post.dto.PostForm;
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
public class PostTest {

    @Autowired
    PostService service;

    @Autowired
    PostRepository repository;

    @Test
    @Rollback(value = false)
    public void pagingTest() {
        //given
        PostForm form = new PostForm(PostRankType.SOLO, PostPosition.AD, "21세기광부", "다이아", "안녕하세요");
        PostForm form2 = new PostForm(PostRankType.SOLO, PostPosition.ALL, "21세기광부", "다이아", "안녕하세요");
        PostForm form3 = new PostForm(PostRankType.TEAM, PostPosition.MID, "21세기광부", "다이아", "안녕하세요");
        PostForm form4 = new PostForm(PostRankType.TEAM, PostPosition.TOP, "21세기광부", "다이아", "안녕하세요");
        PostForm form5 = new PostForm(PostRankType.NORMAL, PostPosition.JUNGLE, "21세기광부", "다이아", "안녕하세요");
        service.save(form);
        service.save(form2);
        service.save(form3);
        service.save(form4);
        service.save(form5);

        //when
        List<PostDto> findPosts = service.findByPage(0, 3);

        //then
        Assertions.assertThat(findPosts.size()).isEqualTo(3);

    }

}
