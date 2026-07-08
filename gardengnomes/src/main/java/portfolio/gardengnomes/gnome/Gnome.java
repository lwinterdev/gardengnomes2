package portfolio.gardengnomes.gnome;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "gnomes")
public class Gnome {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String displayName;

    private Instant createdAt;

    protected Gnome() {}

    public Gnome(String userName, String displayName) {
        this.username = userName;
        this.displayName = displayName;
    }

}