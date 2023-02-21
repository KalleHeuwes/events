package de.kheuwes.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Service
public class EventsServiceImpl implements EventsService{
    @Autowired
    private EventsRepository eventsRepository;

    @Override
    public Event createEvent(String title, LocalDateTime tsStart, LocalDateTime tsEnd) {
        Event event = new Event(title, tsStart, tsEnd);
        eventsRepository.save(event);
        return event;
    }
    @Override
    public Event createEvent(String title, String tsStart, String tsEnd) {
        Event event = new Event(title, tsStart, tsEnd);
        eventsRepository.save(event);
        return event;
    }

    @Override
    public Iterable<Event> createTestEvents() {
        createEvent("Geburt Kalle","13.05.1966 08:00", null);
        createEvent("Geburt Maria","08.02.1972 10:00", null);
        createEvent("Urlaub Irland","01.10.2016 10:00", "08.10.2016 23:00");
        return getAllEvents();
    }

    @Override
    public Iterable<Event> getAllEvents() {
        return eventsRepository.findAll();
    }
}
