package portfolio.gardengnomes.gnome;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import portfolio.gardengnomes.gnome.dto.CreateGnomeRequest;
import portfolio.gardengnomes.gnome.dto.GnomeResponse;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/gnomes")
public class GnomeController {

    private final GnomeService service;

    public GnomeController(GnomeService service) {
        this.service = service;
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public GnomeResponse create(@RequestBody CreateGnomeRequest request) {
        return service.create(request);
    }

    @GetMapping
    public Page<Gnome> findAll(int page, int size, String sortBy) {

        Pageable pageable = PageRequest.of(
                page,
                size,
                Sort.by(sortBy).descending()
        );

        return repository.findAll(pageable);
    }

    @GetMapping("/{id}")
    public GnomeResponse getById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
