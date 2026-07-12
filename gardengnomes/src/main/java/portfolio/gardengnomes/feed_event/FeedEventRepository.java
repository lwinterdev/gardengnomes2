package portfolio.gardengnomes.feed_event;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public interface FeedEventRepository extends JpaRepository<FeedEvent, UUID> {

    List<FeedEvent> findTop20ByOrderByCreatedAtDesc();

    List<FeedEvent> findTop20ByCreatedAtBeforeOrderByCreatedAtDesc(Instant before);
}