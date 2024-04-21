package com.example.bay.mdbspringboot.service;

import com.example.bay.mdbspringboot.model.Event;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EventService {

    void addEvent(Integer eventType, String event);

    List<Event> getEventsByPOIId(String poiId);

    Optional<Event> getEventById(String eventId);

    void deleteEventById(String eventId);

    void updateEvent(Event event);
}
