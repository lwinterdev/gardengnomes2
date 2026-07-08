package portfolio.gardengnomes.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String email;

    private String password;

    private Instant createdAt;


    @Enumerated(EnumType.STRING)
    private Role role;

    private boolean enabled = true;

       public User(
            String username,
            String email,
            String password
    ) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = Role.USER;
        this.createdAt = Instant.now();
        this.enabled = true;
    }


    
}