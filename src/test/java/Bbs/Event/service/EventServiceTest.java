package Bbs.Event.service;

import Bbs.Event.dto.EventRequest;
import Bbs.Event.dto.EventResponse;
import Bbs.Event.entity.Event;
import Bbs.Event.entity.EventType;
import Bbs.Event.mapper.EventMapper;
import Bbs.Event.repository.EventRepository;
import Bbs.exception.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.BeanRegistrarDslMarker;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class EventServiceTest {
    @InjectMocks
    private EventService eventService;
    private Event event;
    @Mock
    private EventMapper eventMapper;
    @Mock
    private EventRepository eventRepository;


    @BeforeEach
    void setUp() {
        event = new Event("test", 2, EventType.Other,
                LocalDateTime.now());
        event.setId(1L);
    }
    @Test
    void getEventShouldReturnEventResponseWhenEventExists() {
        //GIVEN
        EventResponse expectedResponse = new EventResponse(
                "test", 2, false, 1L, EventType.Other, null
        );
        when(eventRepository.findById(1L)).thenReturn(Optional.of(event));

        when(eventMapper.entityToDto(event)).thenReturn(expectedResponse);
        //WHEN
        EventResponse result = eventService.getEvent(1L);
        //THEN
        verify(eventRepository).findById(1L);
        assertNotNull(result);
        assertEquals(expectedResponse, result);
    }
    @Test
    void getEventShouldThrowResourceNotFoundErrorWhenEventDoesntExist(){
        //GIVEN
        when(eventRepository.findById(44L)).thenReturn(Optional.empty());
        //WHEN&THEN
        assertThrows(ResourceNotFoundException.class,()->{
            eventService.getEvent(44L);
        });
        verifyNoInteractions(eventMapper);

    }
    @Test
    void getEventsShouldReturnEventResponseList(){
        //Given
        EventResponse expectedResponse = new EventResponse(
                "test", 2, false, 1L, EventType.Other, null
        );
        when(eventRepository.findAll()).thenReturn(List.of(event));
        when(eventMapper.entityToDto(event)).thenReturn(expectedResponse);
        //When
        List<EventResponse> result = eventService.getEvents();
        //Then
        assertNotNull(result);
        assertEquals(List.of(expectedResponse), result);
        verify(eventRepository).findAll();
    }
    @Test
    void getEventsShouldReturnEmptyListWhenNoEventsFound(){
            //GVEN
        when(eventRepository.findAll()).thenReturn(List.of());
            //WHEN
        List<EventResponse> result = eventService.getEvents();
            //THEN
        assertNotNull(result);
        assertEquals(List.of(),result);

        verifyNoInteractions(eventMapper);
        verify(eventRepository).findAll();
    }
@Test
    void createEventShouldReturnEventResponse(){
        //GVEN
    EventResponse response = new EventResponse("dd",2,true,1,EventType.Other,null);
    EventRequest request = new EventRequest("dd",2,EventType.Other,null);

    when(eventMapper.dtoToEntity(request)).thenReturn(event);
    when(eventRepository.save(event)).thenReturn(event);
    when(eventMapper.entityToDto(event)).thenReturn(response);
        //WHEN
    EventResponse result = eventService.createEvent(request);
        //THEN
    assertNotNull(result);
    assertEquals(response, result);
    verify(eventRepository).save(event);
}
}