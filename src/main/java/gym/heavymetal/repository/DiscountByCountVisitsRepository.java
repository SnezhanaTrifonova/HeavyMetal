package gym.heavymetal.repository;

import gym.heavymetal.entity.DiscountByCountVisitsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DiscountByCountVisitsRepository extends JpaRepository<DiscountByCountVisitsEntity, UUID> {
}
