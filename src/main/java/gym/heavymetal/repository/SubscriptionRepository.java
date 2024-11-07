package gym.heavymetal.repository;

import gym.heavymetal.entity.SubscriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SubscriptionRepository extends JpaRepository<SubscriptionEntity, UUID> {
}
