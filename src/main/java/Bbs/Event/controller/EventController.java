package Bbs.Event.controller;

import Bbs.Event.dto.EventRequest;
import Bbs.Event.dto.EventResponse;
import Bbs.Event.entity.Event;
import Bbs.Event.service.EventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventController {
    private final EventService eventService;
    EventController(EventService eventService){
        this.eventService = eventService;
    }

    @GetMapping("events/{id}")

    public EventResponse getEvent(@PathVariable("id") Long id){
        return eventService.getEvent(id);
    }
    @GetMapping("/events")

    public List<EventResponse> getEvents(){
        return eventService.getEvents();
    }

    @PostMapping("/events")
    public EventResponse createEvent(@RequestBody EventRequest event){
        return eventService.createEvent(event);
    }
}
