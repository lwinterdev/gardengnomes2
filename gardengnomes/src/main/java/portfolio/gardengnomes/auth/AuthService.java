package portfolio.gardengnomes.auth;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import portfolio.gardengnomes.auth.dto.RegisterUserRequest;
import portfolio.gardengnomes.user.Role;
import portfolio.gardengnomes.user.User;
import portfolio.gardengnomes.user.UserRepository;
import portfolio.gardengnomes.user.dto.UserResponse;
import portfolio.gardengnomes.user.exceptions.EmailAlreadyExistsException;
import portfolio.gardengnomes.user.exceptions.UsernameAlreadyExistsException;

@Service
public class AuthService {

    private final UserRepository repository;
    private final PasswordEncoder encoder;

    public AuthService(
            UserRepository repository,
            PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    public UserResponse register(RegisterUserRequest request) {

        if (repository.existsByEmail(request.getEmail())) {
            throw new EmailAlreadyExistsException("Email already exists");
        }

        if (repository.existsByUsername(request.getUsername())) {
            throw new UsernameAlreadyExistsException("Username is already taken");
        }

        User user = new User(request.getUsername(), request.getEmail(), encoder.encode(request.getPassword()),
                Role.USER, true);

        User saved = repository.save(user);

        return new UserResponse(
                saved.getId(),
                saved.getUsername(),
                saved.getEmail(),
                saved.getCreatedAt(),
                saved.isEnabled());
    }
}