package portfolio.gardengnomes.gnome;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "gnome")
public class Gnome {

    @Id
    private UUID id;

    @Column(nullable = false, unique = true)
    private String userName;

    private String displayName;

    private Instant createdAt;

    public Gnome(String userName, String displayName) {
        this.userName = userName;
        this.displayName = displayName;
    }

}