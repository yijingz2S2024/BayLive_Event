package com.example.bay.mdbspringboot.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "event")
public class PrivateEvent extends Event{
    @Field("size")
    private Integer size;

    @Field("location")
    private String location;
}
