package duo.gg.server.account.entity;

import duo.gg.server.api.dto.account.AccountApiResult;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class) // 추가
public class Account {

    @Id
    @GeneratedValue
    @Column(name = "account_id")
    private Long id;

    @Column(nullable = false)
    private String puuid;

    @Column(nullable = true)
    private String gameName;

    @Column(nullable = true)
    private String tagLine;

    public Account(AccountApiResult apiResult) {
        this.puuid = apiResult.getPuuid();
        this.gameName = apiResult.getGameName();
        this.tagLine = apiResult.getTagLine();
    }

    public void updateByApiResult(AccountApiResult apiResult) {
        this.gameName = apiResult.getGameName();
        this.tagLine = apiResult.getTagLine();
    }
}
