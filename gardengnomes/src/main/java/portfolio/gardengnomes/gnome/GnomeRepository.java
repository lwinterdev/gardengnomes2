package portfolio.gardengnomes.gnome;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface GnomeRepository extends JpaRepository<Gnome, UUID> {
}