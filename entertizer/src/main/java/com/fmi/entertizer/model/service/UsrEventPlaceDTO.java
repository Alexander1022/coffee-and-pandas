package com.fmi.entertizer.model.service;

import com.fmi.entertizer.model.service.EventDTO;
import com.fmi.entertizer.model.service.PlaceDTO;
import com.fmi.entertizer.model.service.UserDTO;

public class UsrEventPlaceDTO {
    private UserDTO userDTO;
    private EventDTO eventDTO;
    private PlaceDTO placeDTO;

    public UsrEventPlaceDTO(){}

    public UserDTO getUserDTO() {
        return userDTO;
    }


    public UsrEventPlaceDTO(UserDTO userDTO, EventDTO eventDTO, PlaceDTO placeDTO) {
        this.userDTO = userDTO;
        this.eventDTO = eventDTO;
        this.placeDTO = placeDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public EventDTO getEventDTO() {
        return eventDTO;
    }

    public void setEventDTO(EventDTO eventDTO) {
        this.eventDTO = eventDTO;
    }

    public PlaceDTO getPlaceDTO() {
        return placeDTO;
    }

    public void setPlaceDTO(PlaceDTO placeDTO) {
        this.placeDTO = placeDTO;
    }



}
