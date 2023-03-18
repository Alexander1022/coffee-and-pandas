package com.fmi.entertizer.web;

import com.fmi.entertizer.service.EventService;
import com.fmi.entertizer.service.impl.EventServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3001")
@RequestMapping("/events")
public class EventController {

    private ModelMapper modelMapper;
    @Autowired
    private EventServiceImpl eventService;


}
