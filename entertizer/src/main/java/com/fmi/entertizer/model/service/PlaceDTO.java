package com.fmi.entertizer.model.service;

import com.fmi.entertizer.model.entity.enums.PlaceType;

public class PlaceDTO {
    private PlaceType placeType;

    private String description;
    private String name;

    private String coordinates;

    public PlaceDTO(PlaceType placeType, String description, String name, String coordinates) {
        this.placeType = placeType;
        this.description = description;
        this.name = name;
        this.coordinates = coordinates;
    }

    public PlaceDTO(PlaceType placeType, String description, String coordinates) {
        this.placeType = placeType;
        this.description = description;
        this.coordinates = coordinates;
    }

    public PlaceType getPlaceType() {
        return placeType;
    }

    public void setPlaceType(PlaceType placeType) {
        this.placeType = placeType;
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
