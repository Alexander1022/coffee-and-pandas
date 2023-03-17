package com.fmi.entertizer.model.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "event")
public class Event extends BaseEntity{
    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String coordinates;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "place_id", referencedColumnName = "id")
    private Place place;

    @OneToMany(
            mappedBy = "event",
            cascade = CascadeType.ALL
    )
    private List<UserEvent> eventUser = new ArrayList<>();

    public Event(String name, String description, String coordinates, Place place) {
        this.name = name;
        this.description = description;
        this.coordinates = coordinates;
        this.place = place;
    }

    public Event() {
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

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }
}
