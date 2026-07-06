package portfolio.gardengnomes.gnome;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

import portfolio.gardengnomes.gnome.dto.CreateGnomeRequest;
import portfolio.gardengnomes.gnome.dto.GnomeResponse;

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

  // READ ALL (pagination + sorting)
    @GetMapping
    public Page<Gnome> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "createdAt") String sortBy,
            @RequestParam(defaultValue = "") String search

    ) {
        return service.findAll(page, size, sortBy ,search);
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
