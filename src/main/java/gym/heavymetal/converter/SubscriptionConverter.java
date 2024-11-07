package gym.heavymetal.converter;

import gym.heavymetal.dto.SubscriptionDto;
import gym.heavymetal.entity.SubscriptionEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubscriptionConverter {

    SubscriptionEntity toEntity(SubscriptionDto dto);

    SubscriptionDto toDto(SubscriptionEntity entity);

    List<SubscriptionDto> toDto(List<SubscriptionEntity> entities);
}
