package gym.heavymetal.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record PurchasedSubscriptionDto (
        UUID id,
        UUID sportsmanId,
        UUID subscriptionId,
        String subscriptionName,
        LocalDateTime startedDate,
        LocalDateTime stoppedDate,
        BigDecimal paid,
        Boolean active
){}
