package portfolio.gardengnomes.gnome;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GnomeRepository extends JpaRepository<Gnome, UUID> {

    Page<Gnome> findByNameContainingIgnoreCase(
            String name,
            Pageable pageable
    );

}