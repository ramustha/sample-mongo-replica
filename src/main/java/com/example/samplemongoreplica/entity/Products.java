package com.example.samplemongoreplica.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public record Products(@Id String id, String item, Double qty, String type) {
}
