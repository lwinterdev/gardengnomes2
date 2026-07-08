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
    private Boolean enabled;

    private Instant createdAt;

    public UserResponse(
            UUID id,
            String username,
            String email,
            Instant createdAt,
            Boolean enabled


    ) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.createdAt = createdAt;
        this.enabled = enabled;

    }
}
