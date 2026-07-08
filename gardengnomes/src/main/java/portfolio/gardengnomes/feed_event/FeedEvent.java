package portfolio.gardengnomes.feed_event;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "feed_events")
public class FeedEvent {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "actor_id")
    private UUID actorId;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private FeedEventActionType type;

    @Column(name = "entity_id")
    private UUID entityId;

    @Column(name = "entity_type")
    @Enumerated(EnumType.STRING)
    private FeedEventEntityType entityType;

    @Column(name = "created_at")
    private Instant createdAt;

    protected FeedEvent() {}

    public FeedEvent(UUID actorId,
            FeedEventActionType type,
            UUID entityId,
            FeedEventEntityType entityType) {
        this.actorId = actorId;
        this.type = type;
        this.entityId = entityId;
        this.entityType = entityType;
    }

}