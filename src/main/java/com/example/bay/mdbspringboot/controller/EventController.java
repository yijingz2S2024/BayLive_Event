package com.example.bay.mdbspringboot.controller;

import com.example.bay.mdbspringboot.model.Event;
import com.example.bay.mdbspringboot.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/events")  // Base path for POI-related operations
@CrossOrigin(origins = "http://localhost:3000")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping("/{eventType}")
    public String addEvent(@PathVariable Integer eventType, @RequestBody String event) {
        eventService.addEvent(eventType, event);
        return "Event saved successfully";
    }

    @GetMapping("/poi/{id}")
    public List<Event> getEventByPoiId(@PathVariable String id) {
        return eventService.getEventsByPOIId(id);
    }

    @GetMapping("/{id}")
    public Optional<Event> getEventById(@PathVariable String id) {
        return eventService.getEventById(id);
    }

    @PutMapping
    public String updateEvent(@RequestBody Event event) {
        eventService.updateEvent(event);
        return "Event updated successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteEvent(@PathVariable String id) {
        eventService.deleteEventById(id);
        return "Event deleted successfully";
    }
}
