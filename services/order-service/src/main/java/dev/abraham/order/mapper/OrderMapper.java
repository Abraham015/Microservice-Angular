package dev.abraham.order.mapper;

import dev.abraham.order.model.Order;
import dev.abraham.order.request.OrderRequest;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderMapper {
    public Order toOrder(OrderRequest request) {
        return Order.builder()
                .orderNumber(UUID.randomUUID().toString())
                .price(request.price())
                .skuCode(request.skuCode())
                .quantity(request.quantity())
                .build();
    }
}
