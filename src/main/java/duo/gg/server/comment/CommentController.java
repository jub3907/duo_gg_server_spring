package duo.gg.server.comment;

import duo.gg.server.comment.dto.CommentDeleteForm;
import duo.gg.server.comment.dto.CommentDto;
import duo.gg.server.comment.dto.CommentForm;
import duo.gg.server.common.ResponseBody;
import duo.gg.server.summoner.SummonerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;
    private final SummonerService summonerService;

    @Transactional
    @PostMapping("/comment/{name}")
    public ResponseEntity<String> createComment(@PathVariable String name,
                              @Valid @RequestBody CommentForm form) {
        String puuid = summonerService.getPuuidByName(name);

        commentService.create(puuid, form);
        return new ResponseEntity<>(ResponseBody.SUCCESS, HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/comment/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable Long commentId,
                              @Valid @RequestBody CommentDeleteForm form) {
        commentService.delete(commentId, form);
        return new ResponseEntity<>(ResponseBody.SUCCESS, HttpStatus.OK);

    }

    @GetMapping("/comment/{name}")
    public List<CommentDto> getComments(@PathVariable String name,
                                        @RequestParam Integer offset,
                                        @RequestParam Integer limit) {
        return commentService.findByNamePaging(name, offset, limit);
    }

}
