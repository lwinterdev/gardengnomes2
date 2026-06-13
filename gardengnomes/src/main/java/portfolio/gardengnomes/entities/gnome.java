package portfolio.gardengnomes.entities;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "gnome")
public class gnome {

    @Id
    private UUID id;

    @Column(nullable = false, unique = true)
    private String username;

    private String displayName;

    private Instant createdAt;

    public gnome() {
        this.id = UUID.randomUUID();
        this.createdAt = Instant.now();
    }

    // getters & setters
}