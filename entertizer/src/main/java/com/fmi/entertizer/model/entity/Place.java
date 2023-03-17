package com.fmi.entertizer.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name="place")
public class Place extends BaseEntity{
    @Enumerated(EnumType.STRING)
    private PlaceType type;

    @Column
    private String description;

    @Column(nullable = false)
    private String coordinates;


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
