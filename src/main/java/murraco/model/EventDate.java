package murraco.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class EventDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date eventDate;

    private String description;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "eventDate")
    private List<Event> events;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "eventDate")
    private List<User> eventParticipants;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<User> getEventParticipants() {
        return eventParticipants;
    }

    public void setEventParticipants(List<User> eventParticipants) {
        this.eventParticipants = eventParticipants;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }


    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
