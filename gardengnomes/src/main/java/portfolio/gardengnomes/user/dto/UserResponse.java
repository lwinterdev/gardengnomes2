package portfolio.gardengnomes.user.dto;
import java.time.Instant;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {
    
    private UUID id;
    private String username;
    private String email;
    private String displayName;

    private Instant createdAt;

    public UserResponse(
            UUID id,
            String username,
            String email
    ) {
        this.id = id;
        this.username = username;
        this.email = email;
    }
}
