package portfolio.gardengnomes.feed_event.dto;

import java.time.Instant;
import java.util.List;

public record FeedPageResponse(

        List<FeedEventResponse> items,
        Instant nextCursor,
        boolean hasMore

) {



        
}