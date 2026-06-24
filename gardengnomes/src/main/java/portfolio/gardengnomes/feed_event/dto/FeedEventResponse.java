package portfolio.gardengnomes.feed_event.dto;

import java.time.Instant;
import java.util.UUID;

public class FeedEventResponse {

    private UUID id;
    private UUID actorId;
    private String type;
    private UUID entityId;
    private String entityType;
    private Instant createdAt;

    public FeedEventResponse() {
    }

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

    public UUID getId() {
        return id;
    }

    public UUID getActorId() {
        return actorId;
    }

    public String getType() {
        return type;
    }

    public UUID getEntityId() {
        return entityId;
    }

    public String getEntityType() {
        return entityType;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}