package portfolio.gardengnomes.auth.dto;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;
import portfolio.gardengnomes.user.Role;

@Getter
@Setter
public class RegisterUserRequest {
    private UUID id;
    private String username;
    private String email;
    private String password;
    private Role role;
    private boolean enabled = true;
}
