package Bbs.Event.mapper;

import Bbs.Event.dto.EventRequest;
import Bbs.Event.dto.EventResponse;
import Bbs.Event.entity.Event;
import org.springframework.stereotype.Component;

@Component
public class EventMapper {
    public Event dtoToEntity(EventRequest dto){
        return new Event(
                dto.description(),
                dto.totalTickets(),
                dto.type(),
                dto.date()
        );
    }
    public EventResponse entityToDto(Event event){
        return new EventResponse(event.getDescription(),event.getTotalTickets(),event.isFinished(),event.getId(),event.getType(),event.getDate());
    }
}
