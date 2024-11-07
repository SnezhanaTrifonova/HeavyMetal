package gym.heavymetal.dto;

import java.util.UUID;

public record SportsmanDto (
    UUID id,
    String name,
    String surname,
    String barcode
){}
