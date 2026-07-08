package portfolio.gardengnomes.user;

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

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public UserResponse create(CreateUserRequest request) {
         // basic validation (business rules belong in service)

        if (request.getUsername() == null || request.getUsername().isBlank()) {
            throw new InvalidGnomeException("Username cannot be empty");
        }

        // DTO → Entity
        User user = new User(null, null, null);
        user.setUsername(request.getUsername());

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

        UserResponse dto = new UserResponse(null, null, null);

        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setCreatedAt(user.getCreatedAt());

        return dto;
    }
}
    

