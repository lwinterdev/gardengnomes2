package portfolio.gardengnomes.user;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import portfolio.gardengnomes.gnome.exceptions.InvalidGnomeException;
import portfolio.gardengnomes.user.dto.CreateUserRequest;
import portfolio.gardengnomes.user.dto.UserResponse;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder encoder;

    public UserService(UserRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    public UserResponse create(CreateUserRequest request) {
        // basic validation (business rules belong in service)

        if (request.getUsername() == null || request.getUsername().isBlank()) {
            throw new InvalidGnomeException("Username cannot be empty");
        }

        // DTO → Entity
        User user = new User(
                request.getUsername(),
                request.getEmail(),
                encoder.encode(request.getPassword()),
                request.getRole(),
                request.isEnabled());

        User saved = repository.save(user);

        return toResponse(saved);
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

    public Optional<User> findByUsername(String username) {
        return repository.findByUsername(username);
    }

    // mapper
    private UserResponse toResponse(User user) {

        return new UserResponse(user.getId(), user.getUsername(), user.getEmail(), user.getCreatedAt(),
                user.isEnabled());

    }
}
