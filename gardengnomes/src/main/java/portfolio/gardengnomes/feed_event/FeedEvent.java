package portfolio.gardengnomes.feed_event;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "feed_event")
public class FeedEvent {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "actor_id")
    private UUID actorId;

    @Column(nullable = false)
    private FeedEventActionType type;

    @Column(name = "entity_id")
    private UUID entityId;

    @Column(name = "entity_type")
    private FeedEventEntityType entityType;

    @Column(name = "created_at")
    private Instant createdAt;

    public FeedEvent() {
        this.createdAt = Instant.now();
    }

    public UUID getId() {
        return id;
    }

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

    public Instant getCreatedAt() {
        return createdAt;
    }
}