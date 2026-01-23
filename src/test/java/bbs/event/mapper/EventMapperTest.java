package bbs.event.mapper;

import bbs.event.dto.EventResponse;
import bbs.event.entity.Event;
import bbs.event.entity.EventType;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class EventMapperTest {
    private EventMapper eventMapper;



    @BeforeEach
    void setUp() {
        eventMapper = new EventMapper();
    }
    @Test
    public void shouldMapEntityToDto(){
        Event event = new Event("Description",20, EventType.Other,null);
        event.setId(14L);
        EventResponse eventDto = eventMapper.entityToDto(event);
        assertEquals(eventDto.description(),event.getDescription());
        assertEquals(eventDto.id(),event.getId());
        assertEquals(eventDto.type(),event.getType());
        assertEquals(eventDto.totalTickets(),event.getTotalTickets());
    }

}