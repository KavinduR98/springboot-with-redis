package com.ushan.spring_boot_redis_cache.service;

import com.ushan.spring_boot_redis_cache.dto.ProductDTO;
import com.ushan.spring_boot_redis_cache.entity.Product;
import com.ushan.spring_boot_redis_cache.exception.ProductNotFoundException;
import com.ushan.spring_boot_redis_cache.exception.ResourceNotFoundException;
import com.ushan.spring_boot_redis_cache.repo.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductDTO createProduct(ProductDTO productDTO) {
        if (productDTO == null){
            throw new ResourceNotFoundException("Product details are empty");
        }

        Product newProduct = new Product();

        newProduct.setName(productDTO.name());
        newProduct.setPrice(productDTO.price());

        Product savedProduct = productRepository.save(newProduct);
        return new ProductDTO(savedProduct.getId(), savedProduct.getName(), savedProduct.getPrice());
    }

    public List<ProductDTO> getAllProduct(){
        List<Product> allProducts = productRepository.findAll();
        return allProducts.stream()
                .map(ProductDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public ProductDTO getProduct(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid product Id : " + id);
        }
        Product existProduct = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));

        return ProductDTO.fromEntity(existProduct);
    }

    public ProductDTO updateProduct(ProductDTO productDTO) {
        if (productDTO == null){
            throw new ResourceNotFoundException("Product details are empty");
        }

        Long productId = productDTO.id();
        Product existProduct = productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException(productId));

        existProduct.setName(productDTO.name());
        existProduct.setPrice(productDTO.price());

        Product updatedProduct = productRepository.save(existProduct);
        return ProductDTO.fromEntity(updatedProduct);
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }
}
