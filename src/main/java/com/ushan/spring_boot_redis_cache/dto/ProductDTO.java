package com.ushan.spring_boot_redis_cache.dto;

import com.ushan.spring_boot_redis_cache.entity.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;


import java.math.BigDecimal;

public record ProductDTO(Long id, @NotBlank String name, @Positive BigDecimal price) {
    public static ProductDTO fromEntity(Product product){
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getPrice()
        );
    }

}
