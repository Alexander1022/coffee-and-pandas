package com.fmi.entertizer.scheduled;

import com.fmi.entertizer.service.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//@Component
//@EnableScheduling
//public class ScheduledOldEventDeletion {
//    private final EventService eventService;
//    private final static Logger LOGGER= LoggerFactory.getLogger(ScheduledOldEventDeletion.class);
//
//    public ScheduledOldEventDeletion(EventService eventService) {
//        this.eventService = eventService;
//    }
//
//    //@Scheduled(cron = "0 0 1 * * *")
//    public void deleteOldEvents(){
//        LOGGER.info("Deleting old events");
//        this.eventService.deleteOldEvents();
//    }
//}
