package portfolio.gardengnomes.gnome;

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
    public GnomeResponse create(@RequestBody CreateGnomeRequest request) {
        return service.create(request);
    }

    @GetMapping
    public List<GnomeResponse> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public GnomeResponse getById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
