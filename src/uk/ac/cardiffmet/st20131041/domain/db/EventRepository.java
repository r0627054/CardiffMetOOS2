package uk.ac.cardiffmet.st20131041.domain.db;

import java.util.ArrayList;
import uk.ac.cardiffmet.st20131041.domain.model.Event;

/**
 * The EventRepository interface is used for all repositories of events. For
 * example this can be a database, an in memory ArrayList, for testing...
 *
 * @author Dries Janse
 * @Version 1.0
 */
public interface EventRepository {

    ArrayList<Event> getEvents();

    void setEvents(ArrayList<Event> events);

    void addEvent(Event event);

    int getNumberOfEvents();

    Event getEvent(String title);

    boolean containEventWithTitle(String title);

    ArrayList<Integer> getAllDifferentYears();

    ArrayList<Event> getAllEventsOfYear(int year);

    void removeEvent(String title);
    
    void addEvents(ArrayList<Event> eventList);
}
