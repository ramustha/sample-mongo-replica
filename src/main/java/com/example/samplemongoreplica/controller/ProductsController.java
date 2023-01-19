package com.example.samplemongoreplica.controller;

import com.example.samplemongoreplica.entity.Products;
import com.example.samplemongoreplica.repository.primary.ProductsPrimaryRepository;
import com.example.samplemongoreplica.repository.secondary.ProductsSecondaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ProductsController {

  @Autowired
  private ProductsPrimaryRepository productsPrimaryRepository;

  @Autowired
  private ProductsSecondaryRepository productsSecondaryRepository;

  @GetMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
  public Flux<Products> getProducts() {
    return productsSecondaryRepository.findAll();
  }

  @PostMapping(value = "/products", consumes = MediaType.APPLICATION_JSON_VALUE,
               produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<Products> addProduct(@RequestBody Products product) {
    return productsPrimaryRepository.save(product);
  }
}
