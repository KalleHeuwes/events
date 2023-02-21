package de.kheuwes.events;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EventsRepository extends CrudRepository<Event, Long> {
    List<Event> findByTitle(String title);
    void delete(Event event);
}
