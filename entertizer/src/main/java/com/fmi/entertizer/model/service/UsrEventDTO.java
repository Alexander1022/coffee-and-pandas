package com.fmi.entertizer.model.service;

public class UsrEventDTO {
    private UserDTO userDTO;
    private EventDTO eventDTO;

    public UsrEventDTO(UserDTO userDTO, EventDTO eventDTO) {
        this.userDTO = userDTO;
        this.eventDTO = eventDTO;
    }
    public UsrEventDTO() {}

    public UserDTO getUserDTO() {
        return userDTO;
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

}
