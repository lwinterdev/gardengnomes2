package portfolio.gardengnomes.auth;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import portfolio.gardengnomes.auth.dto.RegisterUserRequest;
import portfolio.gardengnomes.user.dto.UserResponse;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service) {
       this.service = service;    
    }

    @PostMapping("/register")
    public UserResponse register(
        @Validated @RequestBody RegisterUserRequest request
    ) {

        return service.register(request);
    }
}