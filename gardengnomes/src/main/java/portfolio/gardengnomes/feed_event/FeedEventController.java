package portfolio.gardengnomes.feed_event;

import org.springframework.web.bind.annotation.*;
import portfolio.gardengnomes.feed_event.dto.CreateFeedEventRequest;

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
    public FeedEvent create(
            @RequestBody CreateFeedEventRequest request) {

        return service.create(request);
    }
}