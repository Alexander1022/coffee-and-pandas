package com.fmi.entertizer.service.impl;

import com.fmi.entertizer.model.entity.Event;
import com.fmi.entertizer.model.entity.Place;
import com.fmi.entertizer.model.entity.User;
import com.fmi.entertizer.model.entity.UserEvent;
import com.fmi.entertizer.model.entity.enums.Status;
import com.fmi.entertizer.model.service.EventDTO;
import com.fmi.entertizer.model.service.PlaceDTO;
import com.fmi.entertizer.model.service.UserDTO;
import com.fmi.entertizer.repository.EventRepository;
import com.fmi.entertizer.repository.PlaceRepository;
import com.fmi.entertizer.repository.UserEventRepository;
import com.fmi.entertizer.repository.UserRepository;
import com.fmi.entertizer.service.EventService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final PlaceRepository placeRepository;
    private final UserRepository userRepository;

    private final UserEventRepository userEventRepository;
    private final ModelMapper modelMapper;


    public EventServiceImpl(EventRepository eventRepository, PlaceRepository placeRepository, UserRepository userRepository, UserEventRepository userEventRepository, ModelMapper modelMapper) {
        this.eventRepository = eventRepository;
        this.placeRepository = placeRepository;
        this.userRepository = userRepository;
        this.userEventRepository = userEventRepository;
        this.modelMapper = modelMapper;
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
        if(this.eventRepository.findFirstById(eventDTO.getId()).isEmpty()) this.eventRepository.save(event);
        UserEvent userEvent = new UserEvent(user, event, Status.ACCEPTED);
        this.userEventRepository.save(userEvent);
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

    @Override
    public EventDTO deleteEvent(EventDTO eventDTO){
        Event event = this.eventRepository.findFirstById(eventDTO.getId()).orElse(null);
        if(event==null) return null;
        this.eventRepository.delete(event);
        this.userEventRepository.deleteAllByEventId(event.getId());
        return eventDTO;
    }

    @Override
    public List<EventDTO> searchResults(String search){
        List<Event> allEvents = this.eventRepository.findAll().stream().toList();
        List<EventDTO> searchResults = new ArrayList<>();
        allEvents.forEach(e->{
            if(e.getName().contains(search) || e.getDescription().contains(search)){
                EventDTO eventDTO = new EventDTO(e.getName(), e.getDescription(), e.getDate(), e.getCreator().getId(), e.getPlace().getId());
                searchResults.add(eventDTO);
            }
        });
        return searchResults;
    }

    @Override
    public EventDTO addFriendToEvent(UserDTO userFriendDTO, EventDTO eventDTO){
        User user = this.userRepository.findFirstById(userFriendDTO.getId()).orElse(null);
        Event event = this.eventRepository.findFirstById(eventDTO.getId()).orElse(null);
        UserEvent userEvent = new UserEvent(user, event, Status.PENDING_SENT);
        this.userEventRepository.save(userEvent);
        return eventDTO;
    }

    @Override
    public List<EventDTO> viewMyEvents(UserDTO userDTO){
        return this.userEventRepository.findAllByUserId(userDTO.getId()).stream().map(ue->{
            Event event = ue.getEvent();
            return new EventDTO(event.getName(), event.getDescription(),event.getDate() , event.getCreator().getId(), event.getPlace().getId());
        }).toList();
    }

    @Override
    public List<EventDTO> viewEventsCreatedBy(UserDTO userDTO){
        return this.eventRepository.findAll().stream().filter(e->e.getCreator().getId().equals(userDTO.getId())).map(event->{
            return new EventDTO(event.getName(), event.getDescription(),event.getDate(), event.getCreator().getId(), event.getPlace().getId());
        }).toList();

    }

    public List<EventDTO> eventsInTheNext7Days(){
         this.eventRepository.findAll().stream().filter(ev-> ChronoUnit.DAYS.between(LocalDate.now(), ev.getDate())<=7);
    }
    //TODO: recent events

}
