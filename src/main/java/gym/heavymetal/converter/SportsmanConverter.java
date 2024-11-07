package gym.heavymetal.converter;

import gym.heavymetal.dto.SportsmanDto;
import gym.heavymetal.entity.SportsmanEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SportsmanConverter {

    SportsmanEntity toEntity(SportsmanDto dto);

    SportsmanDto toDto(SportsmanEntity entity);

    List<SportsmanDto> toDto(List<SportsmanEntity> entities);
}
