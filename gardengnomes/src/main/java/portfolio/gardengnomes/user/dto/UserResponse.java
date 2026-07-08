package portfolio.gardengnomes.user.dto;
import java.time.Instant;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {
    
    private UUID id;
    private String userName;
    private String displayName;
    private Instant createdAt;
}
