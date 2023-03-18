package com.fmi.entertizer.service.impl;

import com.fmi.entertizer.model.entity.Event;
import com.fmi.entertizer.model.entity.Place;
import com.fmi.entertizer.model.entity.User;
import com.fmi.entertizer.model.service.EventDTO;
import com.fmi.entertizer.model.service.PlaceDTO;
import com.fmi.entertizer.model.service.UserDTO;
import com.fmi.entertizer.repository.EventRepository;
import com.fmi.entertizer.repository.PlaceRepository;
import com.fmi.entertizer.repository.UserRepository;
import com.fmi.entertizer.service.EventService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final PlaceRepository placeRepository;
    private final UserRepository userRepository;


    public EventServiceImpl(EventRepository eventRepository, PlaceRepository placeRepository, UserRepository userRepository) {
        this.eventRepository = eventRepository;
        this.placeRepository = placeRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void deleteOldEvents() {
        this.eventRepository.deleteEventsByDueDateBefore(LocalDate.now());
    }

    @Override
    public EventDTO addEvent(UserDTO userDTO, EventDTO eventDTO, PlaceDTO placeDTO) {
        Place place = this.placeRepository.findFirstByCoordinates(placeDTO.getCoordinates()).orElse(null);
        if(place == null){
            place = new Place(placeDTO.getPlaceType(), placeDTO.getDescription(), placeDTO.getName(), placeDTO.getCoordinates());
            this.placeRepository.save(place);
        }
        User user = this.userRepository.findFirstById(userDTO.getId()).orElse(null);
        if(user == null) return null;
        Event event = new Event(eventDTO.getName(), eventDTO.getDescription(), eventDTO.getDate(), user, place);
        this.eventRepository.save(event); //TODO: check for uniqueness of event
        return eventDTO;
    }

    @Override
    public EventDTO updateEvent(EventDTO eventDTO) {
        Event event = this.eventRepository.findFirstById(eventDTO.getId()).orElse(null);
        if(event==null) return null;
        event.setDescription(eventDTO.getDescription());
        event.setName(eventDTO.getName());
        this.eventRepository.save(event);
        return eventDTO;
    }
}
