package portfolio.gardengnomes.feed_event.dto;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;
import portfolio.gardengnomes.feed_event.FeedEventEntityType;
import portfolio.gardengnomes.feed_event.FeedEventActionType;

@Getter
@Setter
public class CreateFeedEventRequest {

  private UUID actorId;
  private FeedEventActionType type;
  private UUID entityId;
  private FeedEventEntityType entityType;

  public CreateFeedEventRequest(
      UUID actorId,
      FeedEventActionType type,
      UUID entityId,
      FeedEventEntityType entityType) {
    this.actorId = actorId;
    this.type = type;
    this.entityId = entityId;
    this.entityType = entityType;
  }

}