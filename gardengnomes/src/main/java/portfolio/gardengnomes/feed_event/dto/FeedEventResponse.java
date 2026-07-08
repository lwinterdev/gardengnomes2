package portfolio.gardengnomes.feed_event.dto;

import java.time.Instant;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeedEventResponse {

    private UUID id;
    private UUID actorId;
    private String type;
    private UUID entityId;
    private String entityType;
    private Instant createdAt;

    public FeedEventResponse(
            UUID id,
            UUID actorId,
            String type,
            UUID entityId,
            String entityType,
            Instant createdAt) {

        this.id = id;
        this.actorId = actorId;
        this.type = type;
        this.entityId = entityId;
        this.entityType = entityType;
        this.createdAt = createdAt;
    }

}