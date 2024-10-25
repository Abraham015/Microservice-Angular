package dev.abraham.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        value = "inventory",
        url = "http://localhost:8070/api/v1/inventory"
)
public interface InventoryClient {
    @GetMapping
    boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity);
}
