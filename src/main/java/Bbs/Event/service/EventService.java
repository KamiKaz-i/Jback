package Bbs.Event.service;

import Bbs.Event.dto.EventRequest;
import Bbs.Event.dto.EventResponse;
import Bbs.Event.entity.Event;
import Bbs.Event.mapper.EventMapper;
import Bbs.Event.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    EventService(EventRepository eventRepository, EventMapper eventMapper){
        this.eventRepository=eventRepository;
        this.eventMapper = eventMapper;
    }
    public EventResponse getEvent(long id){
        Event event = eventRepository.getEventById(id);
        return eventMapper.entityToDto(event);
    }
    public List<EventResponse> getEvents(){
        List<Event> eventList = eventRepository.findAll();
        return eventList.stream().map(event -> eventMapper.entityToDto(event)).toList();
    }
    public EventResponse createEvent(EventRequest request){

        Event event = eventMapper.dtoToEntity(request);
        Event e = eventRepository.save(event);
        return eventMapper.entityToDto(e);
    }
}
