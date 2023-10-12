package duo.gg.server.comment.dto;

import duo.gg.server.comment.entity.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@ToString
public class CommentDto {

    private String rankType;
    private String position;
    private String name;
    private String tier;
    private String body;
    private LocalDateTime createdDate;

    public CommentDto(Comment entity) {
        this.rankType = entity.getRankType().getRankType();
        this.position = entity.getPosition().getPosition();

        this.name = entity.getName();
        this.tier = entity.getTier();
        this.body = entity.getBody();

        this.createdDate = entity.getCreatedDate();
    }
}
