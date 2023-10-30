package duo.gg.server.comment;

import duo.gg.server.comment.dto.CommentDeleteForm;
import duo.gg.server.comment.dto.CommentDto;
import duo.gg.server.comment.dto.CommentForm;
import duo.gg.server.comment.error.CommentNotExist;
import duo.gg.server.comment.error.PasswordNotMatch;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository repository;
    private final BCryptPasswordEncoder encoder;


    public void create(String puuid, CommentForm form) {
        String encryptedPassword = encoder.encode(form.getPassword());
        Comment comment = new Comment(puuid, form.getNickname(), form.getContent(), encryptedPassword);
        repository.save(comment);
    }

    public void delete(Long commentId, CommentDeleteForm form) {
        Comment comment = repository.findById(commentId);
        if (comment == null) {
            throw new CommentNotExist();
        }

        if (encoder.matches(form.getPassword(), comment.getPassword())) {
            repository.delete(comment);
        } else {
            throw new PasswordNotMatch();
        }
    }

    public List<CommentDto> findByNamePaging(String name, Integer offset, Integer limit) {
        List<Comment> comments = repository.findByNamePaging(name, offset, limit);
        return comments.stream()
                .map(CommentDto::new)
                .collect(Collectors.toList());
    }
}
