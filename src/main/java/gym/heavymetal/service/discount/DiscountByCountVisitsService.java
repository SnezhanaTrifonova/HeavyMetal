package gym.heavymetal.service.discount;

import gym.heavymetal.entity.DiscountByCountVisitsEntity;
import gym.heavymetal.repository.DiscountByCountVisitsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DiscountByCountVisitsService {
    private final DiscountByCountVisitsRepository repository;

    public List<DiscountByCountVisitsEntity> getAll() {
        return repository.findAll();
    }

    public DiscountByCountVisitsEntity getById(UUID id) {
        return repository.findById(id).orElse(null);
    }

    public DiscountByCountVisitsEntity save(DiscountByCountVisitsEntity entity) {
        return repository.save(entity);
    }

    public DiscountByCountVisitsEntity update(DiscountByCountVisitsEntity entity) {
        return save(entity);
    }


    public UUID deleteById(UUID id) {
        repository.deleteById(id);
        return id;
    }
}
