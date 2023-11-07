package duo.gg.server.comment.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "소환사 정보가 존재하지 않습니다.")
public class NoSummonerInfo extends RuntimeException{
    public NoSummonerInfo() {
    }

    public NoSummonerInfo(String message) {
        super(message);
    }

    public NoSummonerInfo(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSummonerInfo(Throwable cause) {
        super(cause);
    }

    public NoSummonerInfo(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
