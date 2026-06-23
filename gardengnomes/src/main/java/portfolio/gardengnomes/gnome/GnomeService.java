package portfolio.gardengnomes.gnome;

import org.springframework.stereotype.Service;

import portfolio.gardengnomes.gnome.dto.CreateGnomeRequest;
import portfolio.gardengnomes.gnome.dto.GnomeResponse;

import java.util.List;
import java.util.UUID;

@Service
public class GnomeService {

    private final GnomeRepository repository;

    public GnomeService(GnomeRepository repository) {
        this.repository = repository;
    }

    public GnomeResponse create(CreateGnomeRequest request) {

        // DTO → Entity
        Gnome gnome = new Gnome();
        gnome.setUserName(request.getUsername());
        gnome.setDisplayName(request.getDisplayName());

        Gnome saved = repository.save(gnome);

        // Entity → DTO
        return toResponse(saved);
    }

    public List<GnomeResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public GnomeResponse findById(UUID id) {
        Gnome gnome = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gnome not found"));

        return toResponse(gnome);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

    // mapper
    private GnomeResponse toResponse(Gnome gnome) {
        GnomeResponse dto = new GnomeResponse();

        dto.setId(gnome.getId());
        dto.setUsername(gnome.getUserName());
        dto.setDisplayName(gnome.getDisplayName());
        dto.setCreatedAt(gnome.getCreatedAt());

        return dto;
    }
}
