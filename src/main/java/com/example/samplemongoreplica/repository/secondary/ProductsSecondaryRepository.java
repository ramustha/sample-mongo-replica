package com.example.samplemongoreplica.repository.secondary;

import com.example.samplemongoreplica.entity.Products;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductsSecondaryRepository extends ReactiveMongoRepository<Products, String> {
}


