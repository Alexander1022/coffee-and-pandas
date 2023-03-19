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
import jdk.swing.interop.SwingInterOpUtils;
import org.hibernate.loader.NonUniqueDiscoveredSqlAliasException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    private LocalDate convertDate(String text){
        List<Integer> nums = Arrays.stream(text.split("\\.")).map(Integer::parseInt).toList();
        return LocalDate.of(nums.get(2), nums.get(1), nums.get(0));
    }
    @Override
    public EventDTO addEvent(Long userId, EventDTO eventDTO, PlaceDTO placeDTO) {
        Place place = this.placeRepository.findFirstByCoordinates(placeDTO.getCoordinates()).orElse(null);
        if(place == null){
            place = new Place(placeDTO.getPlaceType(), placeDTO.getDescription(), placeDTO.getName(), placeDTO.getCoordinates());
            this.placeRepository.saveAndFlush(place);
        }
        User user = this.userRepository.findFirstById(userId).orElse(null);
        if(user == null) return null;

        Event event = new Event(eventDTO.getName(), eventDTO.getDescription(), convertDate(eventDTO.getDate()), user, place);
        if(this.eventRepository.findFirstById(eventDTO.getId()).isEmpty()) {
            this.eventRepository.saveAndFlush(event);
        }
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
                EventDTO eventDTO = new EventDTO(e.getName(), e.getDescription(), e.getDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")), e.getCreator().getId(), modelMapper.map(e.getPlace(), PlaceDTO.class));
                searchResults.add(eventDTO);
            }
        });
        return searchResults;
    }

    @Override
    public EventDTO addFriendToEvent(Long userFriendId, Long eventDTOId){
        User user = this.userRepository.findFirstById(userFriendId).orElse(null);
        Event event = this.eventRepository.findFirstById(eventDTOId).orElse(null);
        UserEvent userEvent = new UserEvent(user, event, Status.PENDING_SENT);
        this.userEventRepository.save(userEvent);
        return new EventDTO(event.getName(),
                event.getDescription(),
                event.getDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                event.getCreator().getId(),
                new PlaceDTO(event.getPlace().getType(), event.getPlace().getDescription(), event.getPlace().getName(), event.getPlace().getCoordinates()));
    }

    @Override
    public List<EventDTO> viewMyEvents(UserDTO userDTO){
        return this.userEventRepository.findAllByUserId(userDTO.getId()).stream().map(ue->{
            Event event = ue.getEvent();
            return new EventDTO(event.getName(), event.getDescription(),event.getDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")), event.getCreator().getId(), modelMapper.map(event.getPlace(), PlaceDTO.class));
        }).toList();
    }

    @Override
    public List<EventDTO> viewEventsCreatedBy(UserDTO userDTO){
        return this.eventRepository.findAll().stream().filter(e->e.getCreator().getId().equals(userDTO.getId())).map(event->{
            return new EventDTO(event.getName(), event.getDescription(),event.getDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")), event.getCreator().getId(), modelMapper.map(event.getPlace(), PlaceDTO.class));
        }).toList();

    }

    @Override
    public List<EventDTO> eventsImInvitedTo(UserDTO userDTO){
        List<Event> events = this.userEventRepository.findAllByUserId(userDTO.getId()).stream().map(UserEvent::getEvent).collect(Collectors.toList());
        List<EventDTO> eventDTOS = new ArrayList<>();

        events.forEach(e->eventDTOS.add(modelMapper.map(e, EventDTO.class)));
        return eventDTOS;
    }
    @Override
    public List<EventDTO> eventsInTheNext7Days(){
        List<EventDTO> events = new ArrayList<>();
        this.eventRepository.findAll().stream()
                .filter(ev-> ChronoUnit.DAYS.between(LocalDate.now(), ev.getDate())<=7)
                .forEach(ev->events.add(modelMapper.map(ev, EventDTO.class)));
        return events;
    }

}
