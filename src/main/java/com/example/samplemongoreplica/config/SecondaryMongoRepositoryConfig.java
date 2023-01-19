package com.example.samplemongoreplica.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@EnableReactiveMongoRepositories(
    basePackages = "com.example.samplemongoreplica.repository.secondary",
    reactiveMongoTemplateRef = "secondaryMongoTemplate")
public class SecondaryMongoRepositoryConfig {

}
