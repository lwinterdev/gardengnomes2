package portfolio.gardengnomes.feed_event.dto;

import java.util.UUID;

import portfolio.gardengnomes.feed_event.FeedEventEntityType;
import portfolio.gardengnomes.feed_event.FeedEventActionType;

public class CreateFeedEventRequest {

    private UUID actorId;
    private FeedEventActionType type;
    private UUID entityId;
    private FeedEventEntityType entityType;

    public UUID getActorId() {
        return actorId;
    }

    public void setActorId(UUID actorId) {
        this.actorId = actorId;
    }

    public FeedEventActionType getType() {
        return type;
    }

    public void setType(FeedEventActionType type) {
        this.type = type;
    }

    public UUID getEntityId() {
        return entityId;
    }

    public void setEntityId(UUID entityId) {
        this.entityId = entityId;
    }

    public FeedEventEntityType getEntityType() {
        return entityType;
    }

    public void setEntityType(FeedEventEntityType entityType) {
        this.entityType = entityType;
    }
}