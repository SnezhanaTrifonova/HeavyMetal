package gym.heavymetal.repository;

import gym.heavymetal.entity.SportsmanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SportsmanRepository extends JpaRepository<SportsmanEntity, UUID> {
}
