package portfolio.gardengnomes.gnome;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "gnome")
public class Gnome {

    @Id
    private UUID id;

    @Column(nullable = false, unique = true)
    private String username;

    private String displayName;

    private Instant createdAt;

    public Gnome() {
        this.id = UUID.randomUUID();
        this.createdAt = Instant.now();
    }

    // getters + setters
}