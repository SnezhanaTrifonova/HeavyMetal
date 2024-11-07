package gym.heavymetal.service.discount;

import gym.heavymetal.dto.DiscountType;
import gym.heavymetal.repository.VisitsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DiscountByCountVisits implements Discount {
    private final VisitsRepository repository;

    @Override
    public BigDecimal checkDiscount(UUID id, BigDecimal price) {
        var percent = repository.getDiscountPercentById(id);
        return price.subtract(price.multiply(new BigDecimal(percent).divide(new BigDecimal(100))));
    }

    @Override
    public DiscountType getType() {
        return DiscountType.COUNT_VISITS;
    }
}
