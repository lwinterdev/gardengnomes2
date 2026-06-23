package portfolio.gardengnomes.user.dto;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;
import portfolio.gardengnomes.user.Role;

@Getter
@Setter
public class CreateUserRequest {
    private UUID id;
    private String username;
    private String passwordHash;
    private Role role;
    private boolean enabled = true;
}
