package duo.gg.server.post;

import duo.gg.server.common.ResponseBody;
import duo.gg.server.post.dto.PostDto;
import duo.gg.server.post.dto.PostForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private final PostService service;

    @Transactional
    @PostMapping("/duo")
    public ResponseEntity<String> create(@Valid @RequestBody PostForm form) {
        service.save(form);
        return new ResponseEntity<>(ResponseBody.SUCCESS, HttpStatus.OK);
    }

    @GetMapping("/duo")
    public List<PostDto> findByPage(@RequestParam Integer offset, @RequestParam Integer limit) {
        return service.findByPage(offset, limit);
    }

}
