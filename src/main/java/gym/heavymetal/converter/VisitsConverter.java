package gym.heavymetal.converter;

import gym.heavymetal.dto.PurchasedSubscriptionDto;
import gym.heavymetal.dto.VisitsDto;
import gym.heavymetal.entity.PurchasedSubscriptionEntity;
import gym.heavymetal.entity.VisitsEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VisitsConverter {

    @Mapping(source = "sportsmanId", target = "sportsman.id")
    @Mapping(source = "purchasedSubscriptionId", target = "purchasedSubscription.id")
    VisitsEntity toEntity(VisitsDto dto);

    @Mapping(source = "sportsman.id", target = "sportsmanId")
    @Mapping(source = "purchasedSubscription.id", target = "purchasedSubscriptionId")
    VisitsDto toDto(VisitsEntity entity);

    @Mapping(source = "sportsman.id", target = "sportsmanId")
    List<VisitsDto> toDto(List<VisitsEntity> entities);
}
