package portfolio.gardengnomes.gnome.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateGnomeRequest {
    private String username;
    private String displayName;
}