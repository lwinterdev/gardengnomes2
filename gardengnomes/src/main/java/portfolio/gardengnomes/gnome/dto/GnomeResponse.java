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



}