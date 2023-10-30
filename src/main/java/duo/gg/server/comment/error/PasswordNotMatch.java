package duo.gg.server.comment.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "비밀번호가 일치하지 않습니다.")
public class PasswordNotMatch extends RuntimeException{

    public PasswordNotMatch() {
    }

    public PasswordNotMatch(String message) {
        super(message);
    }

    public PasswordNotMatch(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswordNotMatch(Throwable cause) {
        super(cause);
    }

    public PasswordNotMatch(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
