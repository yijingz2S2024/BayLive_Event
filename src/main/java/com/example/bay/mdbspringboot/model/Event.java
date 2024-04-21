package com.example.bay.mdbspringboot.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.UUID;

@Data
@Document(collection = "event")
public class Event {
    @Id
    private String id = UUID.randomUUID().toString();

    @Field("name")
    private String name;

    @Field("type")
    private String type;

    @Field("date")
    private String date;

    @Field("description")
    private String description;

    @Field("poiId")
    private String poiId;

    public enum EVENT_TYPE {
        PRIVATE(1),
        VIRTUAL(2),
        COMPETITION(3),
        PUBLIC(4);

        private final int value;

        EVENT_TYPE(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}