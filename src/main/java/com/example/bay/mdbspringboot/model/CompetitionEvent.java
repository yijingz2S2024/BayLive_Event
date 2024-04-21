package com.example.bay.mdbspringboot.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "event")
public class CompetitionEvent extends Event{

    @Field("size")
    private String award;

    @Field("location")
    private String location;
}
