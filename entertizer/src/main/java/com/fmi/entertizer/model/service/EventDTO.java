package com.fmi.entertizer.model.service;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fmi.entertizer.model.entity.Place;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class    EventDTO {

    private String name;
    private String description;

    private String date;

    private Long id;
    private Long creatorId;

    private PlaceDTO placeDTO;

    public EventDTO(String name, String description, String date, Long id, Long creatorId, PlaceDTO placeDTO) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.id = id;
        this.creatorId = creatorId;
        this.placeDTO = placeDTO;
    }
    @JsonCreator
    public EventDTO(@JsonProperty("name") String name,
                    @JsonProperty("description") String description,
                    @JsonProperty("date") String date,
                    @JsonProperty("creatorId") Long creatorId,
                    @JsonProperty("placeDTO") PlaceDTO placeDTO) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.creatorId = creatorId;
        this.placeDTO = placeDTO;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public PlaceDTO getPlaceDTO() {
        return placeDTO;
    }

    public void setPlaceDTO(String placeCoordinates) {
        this.placeDTO = placeDTO;
    }
}
