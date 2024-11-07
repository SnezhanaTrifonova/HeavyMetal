package gym.heavymetal.controller;

import gym.heavymetal.converter.SportsmanConverter;
import gym.heavymetal.dto.SportsmanDto;
import gym.heavymetal.entity.SportsmanEntity;
import gym.heavymetal.service.SportsmanService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sportsman")
@Slf4j
public class SportsmanController {
    private final SportsmanService service;
    private final SportsmanConverter converter;

    @GetMapping
    public List<SportsmanDto> getAll() {
        log.info("Получение всех спортсменов");
        return converter.toDto(service.getAll());
    }

    @GetMapping("/excel")
    public ResponseEntity<byte[]> getAllInExcel() {
        log.info("Получение всех спортсменов в excel");
        byte[] excelBytes = service.getAllInExcel();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("filename", "sportsmen.xlsx");

        return ResponseEntity.ok()
                .headers(headers)
                .body(excelBytes);
    }


    @GetMapping("/{id}")
    public ResponseEntity<SportsmanDto> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(converter.toDto(service.getById(id)));
    }

    @PostMapping
    public ResponseEntity<SportsmanDto> create(@RequestBody SportsmanDto sportsmanDto) {
        log.info("Добавление спортсмена. Имя: {}, Фамилия: {}, Баркод: {}",
                sportsmanDto.name(), sportsmanDto.surname(), sportsmanDto.barcode());

        SportsmanEntity sportsman = service.save(converter.toEntity(sportsmanDto));
        return ResponseEntity.ok(converter.toDto(sportsman));
    }

    @PutMapping
    public ResponseEntity<SportsmanDto> update(@RequestBody SportsmanDto sportsmanDto) {
        SportsmanEntity sportsman = service.update(converter.toEntity(sportsmanDto));
        return ResponseEntity.ok(converter.toDto(sportsman));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UUID> deleteById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.deleteById(id));
    }

}
