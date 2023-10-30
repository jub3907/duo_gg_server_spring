package duo.gg.server.comment.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "댓글이 존재하지 않습니다.")
public class CommentNotExist extends RuntimeException{
    public CommentNotExist() {
    }

    public CommentNotExist(String message) {
        super(message);
    }

    public CommentNotExist(String message, Throwable cause) {
        super(message, cause);
    }

    public CommentNotExist(Throwable cause) {
        super(cause);
    }

    public CommentNotExist(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
