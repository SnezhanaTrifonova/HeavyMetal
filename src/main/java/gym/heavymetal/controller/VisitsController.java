package gym.heavymetal.controller;

import gym.heavymetal.converter.VisitsConverter;
import gym.heavymetal.dto.VisitsDto;
import gym.heavymetal.entity.VisitsEntity;
import gym.heavymetal.service.VisitsService;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/visits")
public class VisitsController {
    private final VisitsService service;
    private final VisitsConverter converter;

    @GetMapping
    public ResponseEntity<List<VisitsDto>> getAll(@Nullable @RequestParam UUID sportsmanId) {
        return ResponseEntity.ok(converter.toDto(service.getAll(sportsmanId)));
    }

    @GetMapping("/count")
    public ResponseEntity<Integer> countVisitsBySportsmanId(@Nullable @RequestParam UUID sportsmanId) {
        return ResponseEntity.ok(service.countVisitsBySportsmanId(sportsmanId));
    }

    @PostMapping
    public ResponseEntity<VisitsDto> create(@RequestBody VisitsDto visitsDto) {
        VisitsEntity visitsEntity =
                service.save(converter.toEntity(visitsDto));
        return ResponseEntity.ok(converter.toDto(visitsEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UUID> deleteById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.deleteById(id));
    }
}
