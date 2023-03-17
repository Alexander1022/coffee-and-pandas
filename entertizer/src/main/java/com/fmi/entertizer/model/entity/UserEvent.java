package com.fmi.entertizer.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_event")
public class UserEvent extends BaseEntity{
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="event_id")
    private Event event;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
