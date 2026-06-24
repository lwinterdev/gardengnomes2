package portfolio.gardengnomes.feed_event;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FeedEventRepository extends JpaRepository<FeedEvent, UUID> {
}