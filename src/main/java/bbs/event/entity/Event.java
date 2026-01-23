package bbs.event.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(nullable = false)
    @NotBlank(message="description is mandatory")

    private String description;

    @Column(nullable = false,name="total_tickets")

    private int totalTickets;

    @Column(nullable = false,name="type")
    @Enumerated(value = EnumType.STRING)

    private EventType type;

    @Column(nullable = false)

    private LocalDateTime date;

    @Column(nullable = false,name="is_finished")

    private boolean isFinished;

    public Event(){

    }
    public Event(String description, int totalTickets, EventType type, LocalDateTime Date) {
        this.description = description;
        this.totalTickets = totalTickets;
        this.type = type;
        this.date = Date;
        this.isFinished = false;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public void setId(long eventId) {
        this.id = eventId;    }
}
