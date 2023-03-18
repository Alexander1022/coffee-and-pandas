package com.fmi.entertizer.web;

import com.fmi.entertizer.model.service.UsrEventDTO;
import com.fmi.entertizer.model.service.UsrEventPlaceDTO;
import com.fmi.entertizer.model.service.EventDTO;
import com.fmi.entertizer.model.service.UserDTO;
import com.fmi.entertizer.service.impl.EventServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3001")
@RequestMapping("/events")
public class EventController {

    private ModelMapper modelMapper;
    @Autowired
    private EventServiceImpl eventService;

    @RequestMapping(value = "/myevents", method = RequestMethod.POST)
    public List<EventDTO> getMyEvents(@RequestBody UserDTO user) {
        return eventService.viewMyEvents(user);
    }

//    @RequestMapping(value = "/invitations", method = RequestMethod.POST)
//    public List<EventDTO> getIvitaions(){
//        return eventService.
//    }

    @RequestMapping(value = "/add", method=RequestMethod.POST)
    public EventDTO addEvent(@RequestBody UsrEventPlaceDTO usrEventPlaceDTO){
        return eventService.addEvent(usrEventPlaceDTO.getUserDTO(), usrEventPlaceDTO.getEventDTO(),usrEventPlaceDTO.getPlaceDTO());
    }

    @RequestMapping(value = "/update", method=RequestMethod.PUT)
    public EventDTO updateEvent(@RequestBody EventDTO eventDTO){
        return eventService.updateEvent(eventDTO);
    }

    @RequestMapping(value = "/delete", method=RequestMethod.DELETE)
    public EventDTO deleteEvent(@RequestBody EventDTO eventDTO){
        return eventService.updateEvent(eventDTO);
    }

    @RequestMapping(value = "/inviteFriends", method = RequestMethod.POST)
    public EventDTO inviteFriends(@RequestBody UsrEventDTO usrEventDTO){
        return eventService.addFriendToEvent(usrEventDTO.getUserDTO(),usrEventDTO.getEventDTO());
    }

    @RequestMapping(value = "/recent")
    public List<EventDTO> recentEvents(){
        return eventService.eventsInTheNext7Days();
    }


}
