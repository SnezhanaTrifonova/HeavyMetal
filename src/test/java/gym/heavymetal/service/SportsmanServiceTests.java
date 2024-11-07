package gym.heavymetal.service;

import gym.heavymetal.entity.SportsmanEntity;
import gym.heavymetal.repository.SportsmanRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SportsmanServiceTests {

    @Mock
    SportsmanRepository sportsmanRepository;

    @InjectMocks
    SportsmanService sut;

    @Captor
    ArgumentCaptor<UUID> uuidArgumentCaptor;

    @Captor
    ArgumentCaptor<SportsmanEntity> sportsmanEntityArgumentCaptor;


    @Test
    public void getAll_success() {
        var expected = List.of(new SportsmanEntity(UUID.randomUUID(), "Artem", "Trifonov", "1234"));

        when(sportsmanRepository.findAll())
                .thenReturn(expected);

        var result = sut.getAll();

        assertEquals(expected, result);

        verify(sportsmanRepository, only()).findAll();
    }

    @Test
    public void getById_success() {
        UUID id = UUID.fromString("f0e595ea-d1d3-4673-86e6-289e5e754fe1");

        var expected = new SportsmanEntity(id, "Ivan", "Smirnov", "1234");

        when(sportsmanRepository.findById(id))
                .thenReturn(Optional.of(expected));

        var result = sut.getById(id);

        assertEquals(expected, result);

        verify(sportsmanRepository, only()).findById(id);
        verify(sportsmanRepository).findById(uuidArgumentCaptor.capture());

        assertEquals(id, uuidArgumentCaptor.getValue());
    }

    @Test
    public void deleteById_success() {
        UUID id = UUID.fromString("f0e595ea-d1d3-4673-86e6-289e5e754fe1");

        UUID result = sut.deleteById(id);

        verify(sportsmanRepository, only()).deleteById(id);
        verify(sportsmanRepository).deleteById(uuidArgumentCaptor.capture());

        assertEquals(id, uuidArgumentCaptor.getValue());
        assertEquals(id, result);

        // TODO: "можно ли проверить что было например 2 спортсмена, а стал 1. , и надо ли это проверять ?"
        // TODO: "надо ли тут when ? "
    }

    @Test
    public void save_success() {
        var sportsmanEntity = new SportsmanEntity(null, "Nadya", "Tihonova", "234566");
        var savedSportsmanEntity = new SportsmanEntity(UUID.randomUUID(), "Nadya", "Tihonova", "234566");

        when(sportsmanRepository.save(sportsmanEntity)).thenReturn(savedSportsmanEntity);

        var result = sut.save(sportsmanEntity);

        verify(sportsmanRepository, only()).save(sportsmanEntity);
        verify(sportsmanRepository).save(sportsmanEntityArgumentCaptor.capture());

        assertEquals(sportsmanEntity, sportsmanEntityArgumentCaptor.getValue());
        assertEquals(result, savedSportsmanEntity);

        //TODO: так же проверить колличество, и надо ли это проверять ?
    }
}
