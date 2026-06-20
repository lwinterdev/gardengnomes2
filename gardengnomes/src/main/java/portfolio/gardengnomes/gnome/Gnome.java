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

    public String getDisplayName() {
        return displayName;
    }

    public String setDisplayName(String newDisplayName) {
        displayName = newDisplayName;
        return displayName;
    }

    public String getUserName(){
        return username;
    }

    public String setUserName(String newUserName){
        username = newUserName;
        return newUserName;
    }
}