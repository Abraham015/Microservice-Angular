package dev.abraham.order.controller;

import dev.abraham.order.request.OrderRequest;
import dev.abraham.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Long> createOrder(@RequestBody OrderRequest orderRequest) {
        try {
            return ResponseEntity.ok(orderService.createOrder(orderRequest));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(null);
        }
    }
}