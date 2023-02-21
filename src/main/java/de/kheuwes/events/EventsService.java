package de.kheuwes.events;

import java.time.LocalDateTime;

public interface EventsService {
    public Event createEvent(String title, LocalDateTime tsStart, LocalDateTime tsEnd);

    public Event createEvent(String title, String tsStart, String tsEnd);

    public Iterable<Event> createTestEvents();

    public Iterable<Event> getAllEvents();
}
