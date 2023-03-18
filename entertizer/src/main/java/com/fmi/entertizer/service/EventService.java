package com.fmi.entertizer.service;


import com.fmi.entertizer.model.entity.Event;
import com.fmi.entertizer.model.service.EventDTO;
import com.fmi.entertizer.model.service.PlaceDTO;
import com.fmi.entertizer.model.service.UserDTO;
import jakarta.transaction.Transactional;

public interface EventService {

    @Transactional
    public void deleteOldEvents();

    EventDTO addEvent(UserDTO userDTO, EventDTO eventDTO, PlaceDTO placeDTO);

    public EventDTO updateEvent(UserDTO userDTO, EventDTO eventDTO);






}
