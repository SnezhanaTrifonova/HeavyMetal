package gym.heavymetal.controller;

import gym.heavymetal.converter.PurchasedSubscriptionConverter;
import gym.heavymetal.dto.PurchasedSubscriptionDto;
import gym.heavymetal.entity.PurchasedSubscriptionEntity;
import gym.heavymetal.service.PurchasedSubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/subscription/purchased")
public class PurchasedSubscriptionController {
    private final PurchasedSubscriptionService service;
    private final PurchasedSubscriptionConverter converter;

    @GetMapping
    public ResponseEntity<List<PurchasedSubscriptionDto>> getAll() {
        return ResponseEntity.ok(converter.toDto(service.getAll()));
    }

    @GetMapping("/bySportsman/{sportsmanId}")
    public ResponseEntity<List<PurchasedSubscriptionDto>> getAllByActive(@PathVariable UUID sportsmanId, @RequestParam Boolean active) {
        return ResponseEntity.ok(converter.toDto(service.getAllByActive(sportsmanId, active)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchasedSubscriptionDto> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(converter.toDto(service.getById(id)));
    }

    @PostMapping
    public ResponseEntity<PurchasedSubscriptionDto> create(@RequestBody PurchasedSubscriptionDto purchasedSubscriptionDto) {
        PurchasedSubscriptionEntity purchasedSubscriptionEntity =
                service.save(converter.toEntity(purchasedSubscriptionDto));
        return ResponseEntity.ok(converter.toDto(purchasedSubscriptionEntity));
    }

    @PutMapping
    public ResponseEntity<PurchasedSubscriptionDto> update(@RequestBody PurchasedSubscriptionDto purchasedSubscriptionDto) {
        var purchasedSubscriptionEntity = converter.toEntity(purchasedSubscriptionDto);
        return ResponseEntity.ok(
                converter.toDto(service.update(purchasedSubscriptionEntity))
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UUID> deleteById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.deleteById(id));
    }
}
