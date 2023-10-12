package duo.gg.server.comment.dto;

import duo.gg.server.comment.constant.CommentPosition;
import duo.gg.server.comment.constant.CommentRankType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentForm {

    private CommentRankType rankType;

    private CommentPosition position;

    @NotBlank(message = "이름을 입력 해주세요.")
    private String name;

    @NotNull
    private String tier;

    @NotNull
    private String body;
}
