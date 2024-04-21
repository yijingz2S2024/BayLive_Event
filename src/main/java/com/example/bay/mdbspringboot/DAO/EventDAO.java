package com.example.bay.mdbspringboot.DAO;

import com.example.bay.mdbspringboot.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface EventDAO extends MongoRepository<Event, String> {
    Optional<Event> findById(String id);

    List<Event> findByPoiId(String poiId);
}
