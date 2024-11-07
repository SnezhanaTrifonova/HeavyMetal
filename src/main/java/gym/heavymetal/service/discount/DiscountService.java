package gym.heavymetal.service.discount;

import gym.heavymetal.dto.DiscountType;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class DiscountService {
    private final Map<DiscountType, Discount> discountsByDiscountType;

    public DiscountService(List<Discount> discounts) {
        this.discountsByDiscountType =
                discounts.stream().collect(Collectors.toMap(Discount::getType, Function.identity()));
    }

    public BigDecimal checkDiscount(UUID id, BigDecimal price, DiscountType discountType) {
        Discount discount = discountsByDiscountType.get(discountType);
        return discount.checkDiscount(id, price);
    }
}
