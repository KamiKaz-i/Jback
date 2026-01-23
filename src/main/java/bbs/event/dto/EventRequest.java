package bbs.event.dto;

import bbs.event.entity.EventType;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record EventRequest(
        @NotBlank(message="description is mandatory")

        String description,

        @JsonProperty("total_tickets")
        @Min(value = 1, message = "minimum amount of tickets is 1")
        int totalTickets,
        EventType type,
        LocalDateTime date) {

}
