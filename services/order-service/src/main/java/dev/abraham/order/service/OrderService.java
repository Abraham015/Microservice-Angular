package dev.abraham.order.service;

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

    public Long createOrder(OrderRequest request) {
        return orderRepository.save(orderMapper.toOrder(request)).getId();
    }
}
