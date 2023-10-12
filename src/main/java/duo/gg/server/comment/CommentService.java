package duo.gg.server.comment;

import duo.gg.server.comment.dto.CommentDto;
import duo.gg.server.comment.dto.CommentForm;
import duo.gg.server.comment.entity.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository repository;

    public CommentDto save(CommentForm form) {
        Comment comment = new Comment(form);
        repository.save(comment);

        return new CommentDto(comment);
    }

    public List<CommentDto> findByPage(int offset, int limit) {
        return repository.findByPage(offset, limit)
                .stream()
                .map(CommentDto::new)
                .collect(Collectors.toList());
    }
}
