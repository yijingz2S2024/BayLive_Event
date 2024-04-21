package com.example.bay.mdbspringboot.service.impl;

import com.example.bay.mdbspringboot.DAO.EventDAO;
import com.example.bay.mdbspringboot.model.*;
import com.example.bay.mdbspringboot.service.EventService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    private EventDAO eventDAO;

    @Autowired
    private Gson gson;
    @Override
    public void addEvent(Integer eventType, String event) {
        Event newEvent;
        if (eventType == Event.EVENT_TYPE.PRIVATE.getValue()) {
            newEvent = gson.fromJson(event, PrivateEvent.class);
        } else if (eventType == Event.EVENT_TYPE.VIRTUAL.getValue()) {
            newEvent = gson.fromJson(event, VirtualEvent.class);
        } else if (eventType == Event.EVENT_TYPE.COMPETITION.getValue()) {
            newEvent = gson.fromJson(event, CompetitionEvent.class);
        } else if (eventType == Event.EVENT_TYPE.PUBLIC.getValue()) {
            newEvent = gson.fromJson(event, PublicEvent.class);
        } else {
            throw new IllegalArgumentException("Unsupported event type: " + eventType);
        }
        eventDAO.save(newEvent);
    }

    @Override
    public List<Event> getEventsByPOIId(String poiId) {
        return eventDAO.findByPoiId(poiId);
    }

    @Override
    public Optional<Event> getEventById(String eventId) {
        return eventDAO.findById(eventId);
    }

    @Override
    public void deleteEventById(String eventId) {
        eventDAO.deleteById(eventId);
    }

    @Override
    public void updateEvent(Event event) {
        eventDAO.save(event);
    }


}
