package portfolio.gardengnomes.feed_event;

import org.springframework.stereotype.Service;
import portfolio.gardengnomes.feed_event.dto.CreateFeedEventRequest;

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
            request.getEntityType()
        );


        return repository.save(event);
    }

    public List<FeedEvent> findAll() {
        return repository.findAll();
    }

  

   


}