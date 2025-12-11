package com.ushan.spring_boot_redis_cache.controller;

import com.ushan.spring_boot_redis_cache.dto.ProductDTO;
import com.ushan.spring_boot_redis_cache.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v2")
@RequiredArgsConstructor
public class ProductController implements IProductController{

    private final ProductService productService;
    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        return productService.createProduct(productDTO);
    }

    @Override
    public ProductDTO getProduct(Long id) {
        return productService.getProduct(id);
    }

    @Override
    public List<ProductDTO> getAllProduct() {
        return productService.getAllProduct();
    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDTO) {
        return productService.updateProduct(productDTO);
    }

    @Override
    public void deleteProduct(Long id) {
        productService.deleteProduct(id);
    }


}
