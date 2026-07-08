package portfolio.gardengnomes.auth;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import portfolio.gardengnomes.auth.dto.RegisterUserRequest;
import portfolio.gardengnomes.user.User;
import portfolio.gardengnomes.user.UserRepository;
import portfolio.gardengnomes.user.dto.UserResponse;

@Service
public class AuthService {

    private final UserRepository repository;
    private final PasswordEncoder encoder;


    public AuthService(
            UserRepository repository,
            PasswordEncoder encoder
    ) {
        this.repository = repository;
        this.encoder = encoder;
    }


    public UserResponse register(RegisterUserRequest request) {

        if(repository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        User user = new User(request.getUsername(), request.getEmail(), encoder.encode(request.getPassword()));

        User saved = repository.save(user);

        return new UserResponse(
                saved.getId(),
                saved.getUsername(),
                saved.getEmail()
        );
    }
}