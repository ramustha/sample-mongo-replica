package com.example.samplemongoreplica.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ReadPreference;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.ReactiveMongoDatabaseFactory;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.convert.MongoConverter;

@Configuration
@EnableConfigurationProperties(MongoProperties.class)
class MongoConfig {

  @Bean
  @Primary
  public MongoClientSettings mongoClientSettings(MongoProperties mongoProperties) {
    return MongoClientSettings.builder()
        .applicationName("sample-mongo-replica")
        .applyConnectionString(new ConnectionString(mongoProperties.getUri()))
        .build();
  }

  @Bean
  public MongoClient mongoClient(MongoClientSettings mongoClientSettings) {
    return MongoClients.create(mongoClientSettings);
  }

  @Primary
  @Bean(name = "primaryMongoTemplate")
  public ReactiveMongoTemplate primaryMongoTemplate(
      ReactiveMongoDatabaseFactory mongoDatabaseFactory,
      MongoConverter mongoConverter) {
    return new ReactiveMongoTemplate(mongoDatabaseFactory, mongoConverter);
  }

  @Bean(name = "secondaryMongoTemplate")
  public ReactiveMongoTemplate secondaryMongoTemplate(
      ReactiveMongoDatabaseFactory mongoDatabaseFactory,
      MongoConverter mongoConverter) {
    ReactiveMongoTemplate mongoTemplate = primaryMongoTemplate(mongoDatabaseFactory, mongoConverter);
    mongoTemplate.setReadPreference(ReadPreference.secondaryPreferred());
    return mongoTemplate;
  }
}
