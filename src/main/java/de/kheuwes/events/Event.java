package de.kheuwes.events;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class Event {
    public Event() {
    }

    public Event(String title, LocalDateTime tsStart, LocalDateTime tsEnd) {
        this.title = title;
        this.tsStart = tsStart;
        this.tsEnd = tsEnd;
    }
    public Event(String title, String tsStart, String tsEnd) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        this.title = title;
        this.tsStart = LocalDateTime.parse(tsStart, formatter);
        this.tsEnd = (tsEnd == null ? null : LocalDateTime.parse(tsEnd, formatter));
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", tsStart=" + tsStart +
                ", tsEnd=" + tsEnd +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getTsStart() {
        return tsStart;
    }

    public void setTsStart(LocalDateTime tsStart) {
        this.tsStart = tsStart;
    }

    public LocalDateTime getTsEnd() {
        return tsEnd;
    }

    public void setTsEnd(LocalDateTime tsEnd) {
        this.tsEnd = tsEnd;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private LocalDateTime tsStart;

    @Column()
    private LocalDateTime tsEnd;
}
