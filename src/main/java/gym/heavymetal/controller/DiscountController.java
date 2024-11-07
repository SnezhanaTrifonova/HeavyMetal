package gym.heavymetal.controller;

import gym.heavymetal.dto.DiscountType;
import gym.heavymetal.service.discount.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/discount")
public class DiscountController {
    private final DiscountService service;

    @GetMapping
    public ResponseEntity<BigDecimal> checkDiscount(
            @RequestParam UUID sportsmanId,
            @RequestParam BigDecimal price,
            @RequestParam DiscountType discountType) {
        return ResponseEntity.ok(service.checkDiscount(sportsmanId, price, discountType));
    }
}
