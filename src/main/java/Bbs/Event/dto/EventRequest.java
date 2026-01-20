package Bbs.Event.dto;

import Bbs.Event.entity.EventType;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public record EventRequest(String description, @JsonProperty("total_tickets") int totalTickets, EventType type, LocalDateTime date) {

}
