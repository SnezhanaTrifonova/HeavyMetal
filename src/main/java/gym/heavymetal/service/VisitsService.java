package gym.heavymetal.service;

import gym.heavymetal.entity.PurchasedSubscriptionEntity;
import gym.heavymetal.entity.VisitsEntity;
import gym.heavymetal.repository.PurchasedSubscriptionRepository;
import gym.heavymetal.repository.VisitsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class VisitsService {

    private final VisitsRepository visitsRepository;
    private final PurchasedSubscriptionRepository purchasedSubscriptionRepository;

    public List<VisitsEntity> getAll(UUID sportsmanId) {
        if (sportsmanId == null) {
            return visitsRepository.findAll();
        } else {
            return visitsRepository.findAllBySportsmanId(sportsmanId);
        }
    }

    @Transactional
    public VisitsEntity save(VisitsEntity entity) {
        UUID purchasedSubscriptionId = entity.getPurchasedSubscription().getId();
        PurchasedSubscriptionEntity purchasedSubscriptionEntity =
                purchasedSubscriptionRepository.getReferenceById(purchasedSubscriptionId);

        if (!entity.getSportsman().getId().equals(purchasedSubscriptionEntity.getSportsman().getId())){
            throw new RuntimeException("Ошибка. Данный спортсмен не имеет данного абонемента");
        }

        if(!purchasedSubscriptionEntity.isActive()) {
            throw new RuntimeException("Этот абонемент закончился");
        }

        entity.setCreatedDate(LocalDateTime.now());
        visitsRepository.save(entity);

        UUID sportsmanId = entity.getSportsman().getId();
        boolean checkAccessibility = visitsRepository.checkAccessibility(sportsmanId, purchasedSubscriptionId);
        if (checkAccessibility) {

            purchasedSubscriptionEntity.setActive(false);
            purchasedSubscriptionRepository.save(purchasedSubscriptionEntity);
            log.info("Закончился аббонемент спортсмена: {}", entity.getSportsman().getId());
        }

        return entity;
    }

    public UUID deleteById(UUID id) {
        visitsRepository.deleteById(id);
        return id;
    }

    public Integer countVisitsBySportsmanId(UUID sportsmanId) {
        return visitsRepository.countBySportsmanId(sportsmanId);
    }

//    public List<VisitsEntity> getAllBySportsmanId(UUID sportsmanId) {
//        return visitsRepository.findAllBySportsmanId(sportsmanId);
//    }
}
