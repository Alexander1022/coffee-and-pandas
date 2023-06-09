package com.fmi.entertizer.model.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "event")
public class Event extends BaseEntity{
    @Column
    private String name;

    @Column
    private String description;
    @Column(nullable = false)
    private LocalDate date;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User creator;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "place_id", referencedColumnName = "id")
    private Place place;

    @OneToMany(
            mappedBy = "event",
            cascade = CascadeType.ALL
    )
    private List<UserEvent> eventUser = new ArrayList<>();

    public Event(String name, String description, LocalDate date, User creator, Place place, List<UserEvent> eventUser) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.creator = creator;
        this.place = place;
        this.eventUser = eventUser;
    }

    public Event(String name, String description, LocalDate date, User creator, Place place) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.creator = creator;
        this.place = place;
    }

    public Event() {
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<UserEvent> getEventUser() {
        return eventUser;
    }

    public void setEventUser(List<UserEvent> eventUser) {
        this.eventUser = eventUser;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }
}
