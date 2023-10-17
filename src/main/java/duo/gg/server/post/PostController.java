package duo.gg.server.post;

import duo.gg.server.post.dto.PostDto;
import duo.gg.server.post.dto.PostForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class PostController {
    //TODO: Post - 듀오 신청 등록
    // 랭크타입, 포지션, 소환사명, 티어, 200자 이내 내용

    private final PostService service;

    //TODO: Post - 코멘트 작성
    @Transactional
    @PostMapping("/duo")
    public PostDto create(@Valid @RequestBody PostForm form) {
        return service.save(form);
    }

    //TODO: Get - 코멘트 조회, count
    //작성자이름, 작성일, 내용
    @GetMapping("/duo")
    public List<PostDto> findByPage(@RequestParam Integer offset, @RequestParam Integer limit) {
        return service.findByPage(offset, limit);
    }

}
