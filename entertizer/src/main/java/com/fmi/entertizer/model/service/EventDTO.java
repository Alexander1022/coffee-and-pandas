package com.fmi.entertizer.model.service;

import java.time.LocalDate;

public class EventDTO {
    private String name;
    private String description;

    private LocalDate dueDate;

    private int creatorId;

    private int placeId;

    public EventDTO(String name, String description, LocalDate dueDate, int creatorId, int placeId) {
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.creatorId = creatorId;
        this.placeId = placeId;
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

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }

    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }
}
