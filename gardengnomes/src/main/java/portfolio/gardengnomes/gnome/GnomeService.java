package portfolio.gardengnomes.gnome;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GnomeService {

    private final GnomeRepository repository;

    public GnomeService(GnomeRepository repository) {
        this.repository = repository;
    }

    public Gnome create(Gnome gnome) {
        return repository.save(gnome);
    }

    public List<Gnome> findAll() {
        return repository.findAll();
    }

    public Gnome findById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gnome not found"));
    }

    public Gnome update(UUID id, Gnome updated) {
        Gnome existing = findById(id);

        existing.setUsername(updated.getUsername());
        existing.setDisplayName(updated.getDisplayName());

        return repository.save(existing);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}