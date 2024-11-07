package gym.heavymetal.converter;

import gym.heavymetal.dto.DiscountByCountVisitsDto;
import gym.heavymetal.dto.SportsmanDto;
import gym.heavymetal.entity.DiscountByCountVisitsEntity;
import gym.heavymetal.entity.SportsmanEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DiscountByCountVisitsConverter {
    DiscountByCountVisitsEntity toEntity(DiscountByCountVisitsDto dto);

    DiscountByCountVisitsDto toDto(DiscountByCountVisitsEntity entity);

    List<DiscountByCountVisitsDto> toDto(List<DiscountByCountVisitsEntity> entities);
}
