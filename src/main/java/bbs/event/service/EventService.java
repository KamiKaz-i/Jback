package bbs.event.service;

import bbs.event.dto.EventRequest;
import bbs.event.dto.EventResponse;
import bbs.event.entity.Event;
import bbs.event.mapper.EventMapper;
import bbs.event.repository.EventRepository;
import bbs.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    private final EventRepository eventRepository;
    private final EventMapper eventMapper;
    public EventService(EventRepository eventRepository, EventMapper eventMapper){
        this.eventRepository=eventRepository;
        this.eventMapper = eventMapper;
    }
    public EventResponse getEvent(long id){
        Optional<Event> event = eventRepository.findById(id);
        return event.map(eventMapper::entityToDto).orElseThrow(()-> new ResourceNotFoundException("event","id",id));
    }
    public List<EventResponse> getEvents(){
        List<Event> eventList = eventRepository.findAll();
        return eventList.stream().map(eventMapper::entityToDto).toList();
    }
    public EventResponse createEvent(EventRequest request){
            Event eventEntity = eventMapper.dtoToEntity(request);
            Event event = eventRepository.save(eventEntity);
            return eventMapper.entityToDto(event);
    }
}
