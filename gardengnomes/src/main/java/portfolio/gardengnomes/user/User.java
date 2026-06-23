package portfolio.gardengnomes.user;

import jakarta.persistence.*;
import java.util.UUID;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(unique = true)
    private String username;

    private String passwordHash;

    private Role role;

    private boolean enabled = true;

    // getters/setters
}