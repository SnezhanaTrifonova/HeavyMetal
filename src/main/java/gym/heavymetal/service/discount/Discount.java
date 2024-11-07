package gym.heavymetal.service.discount;

import gym.heavymetal.dto.DiscountType;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Component
public interface Discount {
    BigDecimal checkDiscount(UUID id, BigDecimal price);

    DiscountType getType();

}
