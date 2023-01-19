package com.example.samplemongoreplica.repository.primary;

import com.example.samplemongoreplica.entity.Products;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductsPrimaryRepository extends ReactiveMongoRepository<Products, String> {
}


