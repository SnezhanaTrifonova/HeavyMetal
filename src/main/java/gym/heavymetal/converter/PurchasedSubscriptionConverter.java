package gym.heavymetal.converter;

import gym.heavymetal.dto.PurchasedSubscriptionDto;
import gym.heavymetal.entity.PurchasedSubscriptionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PurchasedSubscriptionConverter {


    @Mapping(source = "sportsmanId", target = "sportsman.id")
    @Mapping(source = "subscriptionId", target = "subscription.id")
    @Mapping(target = "active", source = "active", defaultValue = "true")
    PurchasedSubscriptionEntity toEntity(PurchasedSubscriptionDto dto);

    @Mapping(source = "sportsman.id", target = "sportsmanId")
    @Mapping(source = "subscription.id", target = "subscriptionId")
    @Mapping(source = "subscription.name", target = "subscriptionName")
    PurchasedSubscriptionDto toDto(PurchasedSubscriptionEntity entity);

    @Mapping(source = "sportsman.id", target = "sportsmanId")
    @Mapping(source = "subscription.id", target = "subscriptionId")
    @Mapping(source = "subscription.name", target = "subscriptionName")
    List<PurchasedSubscriptionDto> toDto(List<PurchasedSubscriptionEntity> entities);
}
