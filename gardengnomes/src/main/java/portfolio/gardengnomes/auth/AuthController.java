package portfolio.gardengnomes.auth;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import portfolio.gardengnomes.user.User;
import portfolio.gardengnomes.user.UserRepository;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository repo;
    private final PasswordEncoder encoder;

    public AuthController(UserRepository repo, PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {

        user.setPassword(encoder.encode(user.getPassword()));
        user.setRole(user.getRole());

        return repo.save(user);
    }
}