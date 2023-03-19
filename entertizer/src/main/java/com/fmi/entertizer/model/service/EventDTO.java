package com.fmi.entertizer.model.service;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class EventDTO {
    private String name;
    private String description;

    private LocalDate date;

    private Long id;
    private Long creatorId;

    private Long placeId;

    public EventDTO(String name, String description, LocalDate date, Long id, Long creatorId, Long placeId) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.id = id;
        this.creatorId = creatorId;
        this.placeId = placeId;
    }

    @JsonCreator
    public EventDTO(@JsonProperty("name") String name,
                    @JsonProperty("description") String description,
                    @JsonProperty("date") LocalDate date,
                    @JsonProperty("creatorId") Long creatorId,
                    @JsonProperty("placeId") Long placeId) {

        this.name = name;
        this.description = description;
        this.date = date;
        this.creatorId = creatorId;
        this.placeId = placeId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public Long getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Long placeId) {
        this.placeId = placeId;
    }
}
