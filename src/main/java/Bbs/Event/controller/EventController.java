package Bbs.Event.controller;

import Bbs.Event.dto.EventRequest;
import Bbs.Event.dto.EventResponse;
import Bbs.Event.service.EventService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventController {
    private final EventService eventService;
    public EventController(EventService eventService){
        this.eventService = eventService;
    }
    @GetMapping("events/{id}")

    public ResponseEntity<EventResponse> getEvent(@PathVariable("id") Long id){
        EventResponse event = eventService.getEvent(id);
        return new ResponseEntity<>(event, HttpStatus.OK);
    }
    @GetMapping("/events")

    public ResponseEntity<List<EventResponse>> getEvents(){
        List<EventResponse> listOfEvents = eventService.getEvents();
        return new ResponseEntity<>(listOfEvents,HttpStatus.OK);
    }

    @PostMapping("/events")
    public ResponseEntity<EventResponse> createEvent(@RequestBody @Valid EventRequest event){
        return new ResponseEntity<>(eventService.createEvent(event),HttpStatus.CREATED);
    }
}
