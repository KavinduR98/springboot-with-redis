package com.ushan.spring_boot_redis_cache.controller;

import com.ushan.spring_boot_redis_cache.dto.ProductDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IProductController {

    @PostMapping("/create")
    @ResponseBody
    ProductDTO createProduct(@RequestBody ProductDTO productDTO) throws Exception;

    @GetMapping("/get-product/{id}")
    @ResponseBody
    ProductDTO getProduct(@PathVariable Long id) throws Exception;

    @GetMapping("/get-all")
    @ResponseBody
    List<ProductDTO> getAllProduct();

    @PutMapping("/update")
    @ResponseBody
    ProductDTO updateProduct(@RequestBody ProductDTO productDTO);

    @DeleteMapping("/delete/{id}")
    void deleteProduct(@PathVariable Long id);
}
