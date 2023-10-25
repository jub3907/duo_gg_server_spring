package duo.gg.server.comment.dto;

import duo.gg.server.comment.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {

    private Long commentId;
    private String nickname;
    private String content;
    private LocalDateTime createdDate;

    public CommentDto(Comment comment) {
        this.commentId = comment.getId();
        this.nickname = comment.getNickname();
        this.content = comment.getContent();
        this.createdDate = comment.getCreatedDate();
    }
}
