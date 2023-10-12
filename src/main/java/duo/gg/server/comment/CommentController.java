package duo.gg.server.comment;

import duo.gg.server.comment.dto.CommentDto;
import duo.gg.server.comment.dto.CommentForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService service;

    //TODO: Post - 코멘트 작성
    @Transactional
    @PostMapping("/duo")
    public CommentDto create(@Valid @RequestBody CommentForm form) {
        return service.save(form);
    }

    //TODO: Get - 코멘트 조회, count
    //작성자이름, 작성일, 내용
    @GetMapping("/duo")
    public List<CommentDto> findByPage(@RequestParam int offset, @RequestParam int limit) {
        return service.findByPage(offset, limit);
    }
}
