package com.fmi.entertizer.service;


import com.fmi.entertizer.model.entity.Event;
import com.fmi.entertizer.model.service.EventDTO;
import com.fmi.entertizer.model.service.PlaceDTO;
import com.fmi.entertizer.model.service.UserDTO;
import jakarta.transaction.Transactional;

import java.util.List;

public interface EventService {

    @Transactional
    public void deleteOldEvents();

    EventDTO addEvent(UserDTO userDTO, EventDTO eventDTO, PlaceDTO placeDTO);

    EventDTO updateEvent(EventDTO eventDTO);

    EventDTO deleteEvent(EventDTO eventDTO);

    List<EventDTO> searchResults(String search);

    EventDTO addFriendToEvent(UserDTO userFriendDTO, EventDTO eventDTO);

    List<EventDTO> viewMyEvents(UserDTO userDTO);

    List<EventDTO> viewEventsCreatedBy(UserDTO userDTO);

    List<EventDTO> eventsImInvitedTo(UserDTO userDTO);

    List<EventDTO> eventsInTheNext7Days();
}
