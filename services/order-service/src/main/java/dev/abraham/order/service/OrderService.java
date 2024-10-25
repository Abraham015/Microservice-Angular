package dev.abraham.order.service;

import dev.abraham.order.client.InventoryClient;
import dev.abraham.order.mapper.OrderMapper;
import dev.abraham.order.model.Order;
import dev.abraham.order.repository.OrderRepository;
import dev.abraham.order.request.OrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final InventoryClient inventoryClient;

    public Long createOrder(OrderRequest request) {
        boolean stock=inventoryClient.isInStock(request.skuCode(), request.quantity());
        if(stock)
            return orderRepository.save(orderMapper.toOrder(request)).getId();
        else
            throw new RuntimeException("Stock doesn't exist");
    }
}
