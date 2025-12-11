package com.ushan.spring_boot_redis_cache.exception;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(Long id){
        super("Product not found with id: " + id);
    }

}
