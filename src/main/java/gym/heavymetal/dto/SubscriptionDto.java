package gym.heavymetal.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record SubscriptionDto (
     UUID id,
     String name,
     Integer countVisits,
     BigDecimal price,
     Integer actionTime
){}
