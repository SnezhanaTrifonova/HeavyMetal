package gym.heavymetal.dto;

import java.util.UUID;

public record DiscountByCountVisitsDto (
        UUID id,
        Integer percent,
        Integer countVisits
){}
