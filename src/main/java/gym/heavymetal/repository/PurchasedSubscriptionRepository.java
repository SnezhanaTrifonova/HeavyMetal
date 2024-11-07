package gym.heavymetal.repository;

import gym.heavymetal.entity.PurchasedSubscriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PurchasedSubscriptionRepository extends JpaRepository<PurchasedSubscriptionEntity, UUID> {
    List<PurchasedSubscriptionEntity> findAllBySportsmanIdAndActive(UUID sportsmanId, Boolean active);
}
