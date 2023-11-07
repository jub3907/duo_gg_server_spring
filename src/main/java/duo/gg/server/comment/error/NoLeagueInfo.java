package duo.gg.server.comment.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "리그 정보가 존재하지 않습니다.")
public class NoLeagueInfo extends RuntimeException{
    public NoLeagueInfo() {
    }

    public NoLeagueInfo(String message) {
        super(message);
    }

    public NoLeagueInfo(String message, Throwable cause) {
        super(message, cause);
    }

    public NoLeagueInfo(Throwable cause) {
        super(cause);
    }

    public NoLeagueInfo(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
