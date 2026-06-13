package portfolio.gardengnomes.gnome;

import org.springframework.web.bind.annotation.*;

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
    public Gnome create(@RequestBody Gnome gnome) {
        return service.create(gnome);
    }

    @GetMapping
    public List<Gnome> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Gnome getById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public Gnome update(@PathVariable UUID id, @RequestBody Gnome gnome) {
        return service.update(id, gnome);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}