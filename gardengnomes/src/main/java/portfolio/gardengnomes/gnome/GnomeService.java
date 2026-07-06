package portfolio.gardengnomes.gnome;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.*;

import portfolio.gardengnomes.feed_event.FeedEventActionType;
import portfolio.gardengnomes.feed_event.FeedEventEntityType;
import portfolio.gardengnomes.feed_event.FeedEventService;
import portfolio.gardengnomes.feed_event.dto.CreateFeedEventRequest;
import portfolio.gardengnomes.gnome.dto.CreateGnomeRequest;
import portfolio.gardengnomes.gnome.dto.GnomeResponse;

import portfolio.gardengnomes.gnome.exceptions.GnomeNotFoundException;
import portfolio.gardengnomes.gnome.exceptions.InvalidGnomeException;

import java.util.UUID;

@Service
public class GnomeService {

    private final FeedEventService feedEventService;
    private final GnomeRepository repository;

    public GnomeService(GnomeRepository repository, FeedEventService feedEventService) {
        this.repository = repository;
        this.feedEventService = feedEventService;
    }

    // CREATE
    public GnomeResponse create(CreateGnomeRequest request) {

        // basic validation (business rules belong in service)
        if (request.getDisplayName() == null || request.getDisplayName().isBlank()) {
            throw new InvalidGnomeException("Display name cannot be empty");
        }

        if (request.getUsername() == null || request.getUsername().isBlank()) {
            throw new InvalidGnomeException("Username cannot be empty");
        }

        // DTO → Entity
        Gnome gnome = new Gnome();
        gnome.setUserName(request.getUsername());
        gnome.setDisplayName(request.getDisplayName());

        Gnome saved = repository.save(gnome);

        CreateFeedEventRequest event = new CreateFeedEventRequest();
        event.setActorId(saved.getId());
        event.setType(FeedEventActionType.GNOME_CREATED);
        event.setEntityId(saved.getId());
        event.setEntityType(FeedEventEntityType.GNOME);

        feedEventService.create(event);

        return toResponse(saved);
    }

    // READ ALL (pagination + sorting + optional search)
    public Page<Gnome> findAll(int page, int size, String sortBy, String search) {

        Pageable pageable = PageRequest.of(
                page,
                size,
                Sort.by(sortBy).descending()
        );

        if (search == null || search.isBlank()) {
            return repository.findAll(pageable);
        }

        return repository.findByNameContainingIgnoreCase(search, pageable);
    }

    // READ BY ID
    public GnomeResponse findById(UUID id) {

        Gnome gnome = repository.findById(id)
                .orElseThrow(() ->
                        new GnomeNotFoundException("Gnome with id " + id + " not found")
                );

        return toResponse(gnome);
    }

    // DELETE
    public void delete(UUID id) {

        if (!repository.existsById(id)) {
            throw new GnomeNotFoundException("Gnome with id " + id + " not found");
        }

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