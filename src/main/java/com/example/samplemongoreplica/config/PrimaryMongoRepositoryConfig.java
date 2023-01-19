package com.example.samplemongoreplica.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@EnableReactiveMongoRepositories(
    basePackages = "com.example.samplemongoreplica.repository.primary",
    reactiveMongoTemplateRef = "primaryMongoTemplate")
public class PrimaryMongoRepositoryConfig {

}
