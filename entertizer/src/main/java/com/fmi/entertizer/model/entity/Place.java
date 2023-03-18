package com.fmi.entertizer.model.entity;

import com.fmi.entertizer.model.entity.enums.PlaceType;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="place")
public class Place extends BaseEntity{


    @Enumerated(EnumType.STRING)
    private PlaceType type;

    @Column
    private String description;

    @Column
    private String name;

    @Column(nullable = false)
    private String coordinates;

    @OneToOne(mappedBy ="place")
    private Event event;

    @OneToMany(
            mappedBy = "place",
            cascade = CascadeType.ALL
    )
    private List<UserPlace> placeUser = new ArrayList<>();

    public Place(PlaceType type, String description, String name, String coordinates) {
        this.type = type;
        this.description = description;
        this.name = name;
        this.coordinates = coordinates;
    }

    public Place(PlaceType type, String description, String coordinates) {
        this.type = type;
        this.description = description;
        this.coordinates = coordinates;
    }

    public Place() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public List<UserPlace> getPlaceUser() {
        return placeUser;
    }

    public void setPlaceUser(List<UserPlace> placeUser) {
        this.placeUser = placeUser;
    }

    public PlaceType getType() {
        return type;
    }

    public void setType(PlaceType type) {
        this.type = type;
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
}
