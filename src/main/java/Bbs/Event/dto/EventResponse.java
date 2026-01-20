package Bbs.Event.dto;

import Bbs.Event.entity.EventType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public record EventResponse(String description,
                            @JsonProperty("total_tickets")
                                  int totalTickets,
                            boolean isFinished,
                            long id,
                            EventType type,
                            @JsonFormat(pattern = "yyyy-MM-dd")
                                  LocalDateTime date) {
}
