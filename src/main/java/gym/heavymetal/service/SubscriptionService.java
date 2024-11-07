package gym.heavymetal.service;

import gym.heavymetal.entity.SubscriptionEntity;
import gym.heavymetal.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;

    public List<SubscriptionEntity> getAll() {
        return subscriptionRepository.findAll();
    }

    public SubscriptionEntity getById(UUID id) {
        return subscriptionRepository.findById(id).orElse(null);
    }

    public SubscriptionEntity save(SubscriptionEntity entity) {
        return subscriptionRepository.save(entity);
    }

    public SubscriptionEntity update(SubscriptionEntity entity) {
        return save(entity);
    }

    public UUID deleteById(UUID id) {
        subscriptionRepository.deleteById(id);
        return id;
    }
}
