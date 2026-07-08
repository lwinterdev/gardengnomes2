package portfolio.gardengnomes.gnome.dto;

import java.time.Instant;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GnomeResponse {

    private UUID id;
    private String username;
    private String displayName;
    private Instant createdAt;

    public GnomeResponse(UUID id, String username, String displayName, Instant createdAt) {
        this.id = id;
        this.username = username;
        this.displayName = displayName;
        this.createdAt = createdAt;
    }

}