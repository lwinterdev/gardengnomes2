package portfolio.gardengnomes.feed_event;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import portfolio.gardengnomes.feed_event.dto.CreateFeedEventRequest;
import portfolio.gardengnomes.feed_event.dto.FeedPageResponse;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/feed")
public class FeedEventController {

    private final FeedEventService service;

    public FeedEventController(FeedEventService service) {
        this.service = service;
    }

    @GetMapping
    public List<FeedEvent> getFeed() {
        return service.findAll();
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public FeedEvent create(@RequestBody CreateFeedEventRequest request) {

        return service.create(request);
    }

    @GetMapping
    public FeedPageResponse getFeed(

            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant before

    ) {

        return service.getFeed(before);

    }
}