package gym.heavymetal.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record VisitsDto (
        UUID id,
        UUID sportsmanId,
        UUID purchasedSubscriptionId,
        LocalDateTime createdDate
){}
