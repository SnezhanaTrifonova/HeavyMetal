package gym.heavymetal.service;

import gym.heavymetal.entity.PurchasedSubscriptionEntity;
import gym.heavymetal.repository.PurchasedSubscriptionRepository;
import gym.heavymetal.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PurchasedSubscriptionService {

    private final PurchasedSubscriptionRepository purchasedSubscriptionRepository;
    private final SubscriptionRepository subscriptionRepository;

    public List<PurchasedSubscriptionEntity> getAll() {
        return purchasedSubscriptionRepository.findAll();
    }

    public List<PurchasedSubscriptionEntity> getAllByActive(UUID sportsmanId, Boolean active) {
        return purchasedSubscriptionRepository.findAllBySportsmanIdAndActive(sportsmanId, active);
    }

    public PurchasedSubscriptionEntity getById(UUID id) {
        return purchasedSubscriptionRepository.findById(id).orElse(null);
    }

    public PurchasedSubscriptionEntity save(PurchasedSubscriptionEntity entity) {
        var subscription = subscriptionRepository.findById(entity.getSubscription().getId());
        if (subscription.isEmpty()) {
            throw new RuntimeException("Не найдена подписка");
        }

        var now = LocalDateTime.now();
        entity.setStartedDate(now);
        var actionTime = subscription.get().getActionTime();
        if (actionTime != null) {
            entity.setStoppedDate(now.plusMonths(actionTime));
        }

        return purchasedSubscriptionRepository.save(entity);
    }


    public PurchasedSubscriptionEntity update(PurchasedSubscriptionEntity entity) {
        return save(entity);
    }

    public UUID deleteById(UUID id) {
        purchasedSubscriptionRepository.deleteById(id);
        return id;
    }
}
