package portfolio.gardengnomes.feed_event;

import org.springframework.stereotype.Service;
import portfolio.gardengnomes.feed_event.dto.CreateFeedEventRequest;
import portfolio.gardengnomes.feed_event.dto.FeedEventResponse;
import portfolio.gardengnomes.feed_event.dto.FeedPageResponse;

import java.time.Instant;
import java.util.List;

@Service
public class FeedEventService {

    private final FeedEventRepository repository;

    public FeedEventService(FeedEventRepository repository) {
        this.repository = repository;
    }

    public FeedEvent create(CreateFeedEventRequest request) {

        FeedEvent event = new FeedEvent(
                request.getActorId(),
                request.getType(),
                request.getEntityId(),
                request.getEntityType());

        return repository.save(event);
    }

    public List<FeedEvent> findAll() {
        return repository.findAll();
    }

    public FeedPageResponse getFeed(Instant before) {

        List<FeedEvent> events;

        if (before == null) {
            events = repository.findTop20ByOrderByCreatedAtDesc();
        } else {
            events = repository.findTop20ByCreatedAtBeforeOrderByCreatedAtDesc(before);
        }

        List<FeedEventResponse> dto = events.stream()
                .map(FeedEventResponse::from)
                .toList();

        Instant nextCursor = null;

        if (!events.isEmpty()) {
            nextCursor = events.get(events.size() - 1).getCreatedAt();
        }

        boolean hasMore = events.size() == 20;

        return new FeedPageResponse(
                dto,
                nextCursor,
                hasMore);
    }

}