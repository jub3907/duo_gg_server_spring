package duo.gg.server.comment.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentForm {
    @NotBlank
    private String nickname;

    @NotBlank
    private String password;

    @NotBlank
    private String content;
}
