package dev.abraham.order.request;

import java.math.BigDecimal;

public record OrderRequest(
        Long id,
        String orderNnumber,
        String skuCode,
        BigDecimal price,
        Integer quantity
) {
}
