package gym.heavymetal.controller;

import gym.heavymetal.converter.DiscountByCountVisitsConverter;
import gym.heavymetal.dto.DiscountByCountVisitsDto;
import gym.heavymetal.entity.DiscountByCountVisitsEntity;
import gym.heavymetal.service.discount.DiscountByCountVisitsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/discount/by-count")
public class DiscountByCountVisitsController {
    private final DiscountByCountVisitsService service;
    private final DiscountByCountVisitsConverter converter;

    @GetMapping
    public ResponseEntity<List<DiscountByCountVisitsDto>> getAll() {
        return ResponseEntity.ok(converter.toDto(service.getAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiscountByCountVisitsDto> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(converter.toDto(service.getById(id)));
    }

    @PostMapping
    public ResponseEntity<DiscountByCountVisitsDto> create(@RequestBody DiscountByCountVisitsDto discountByCountVisitsDto) {
        DiscountByCountVisitsEntity discountByCountVisitsEntity =
                service.save(converter.toEntity(discountByCountVisitsDto));
        return ResponseEntity.ok(converter.toDto(discountByCountVisitsEntity));
    }

    @PutMapping
    public ResponseEntity<DiscountByCountVisitsDto> update(@RequestBody DiscountByCountVisitsDto discountByCountVisitsDto) {
        var discountByCountVisitsEntity = converter.toEntity(discountByCountVisitsDto);
        return ResponseEntity.ok(
                converter.toDto(service.update(discountByCountVisitsEntity))
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UUID> deleteById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.deleteById(id));
    }
}
