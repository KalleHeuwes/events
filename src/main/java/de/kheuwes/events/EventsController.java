package de.kheuwes.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;

@RestController
@RequestMapping("/api/events")
public class EventsController {
    @Autowired
    EventsService eventsService;

    @GetMapping
    public Iterable<Event> getRoot(){
        return eventsService.getAllEvents();
    }

    @PostMapping("/test")
    @ResponseStatus(HttpStatus.CREATED)
    public Iterable<Event> createEvents() {
        System.out.println("POST createEvents ...");
        return eventsService.createTestEvents();
    }
}
