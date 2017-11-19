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

    /**
     * Gets the ArrayList with all the events in it.
     *
     * @return ArrayList with all the events
     */
    ArrayList<Event> getEvents();

    /**
     * Sets the ArrayList with Events.
     *
     * @param events the ArrayList with events
     */
    void setEvents(ArrayList<Event> events);

    /**
     * Adds an Event to the ArrayList with all the events.
     *
     * @param event the Event that will be added to the ArrayList
     */
    void addEvent(Event event);

    /**
     * Gets the number of events.
     *
     * @return total amount of events
     */
    int getNumberOfEvents();

    /**
     * Gets the event with the given title or returns null is there is no event
     * available with the given title.
     *
     * @param title
     * @return event with given title or null of no event with the given title
     * is found
     */
    Event getEvent(String title);

    /**
     * Checks if there is an event with the given title.
     *
     * @param title
     * @return <code>true</code> if title is found in the ArrayList,
     * <code>false</code> is no event exists with the given title.
     */
    boolean containEventWithTitle(String title);

    /**
     * Get an ArrayList with all the different Years in.
     *
     * @return ArrayList with year is.
     */
    ArrayList<Integer> getAllDifferentYears();

    /**
     * Gets an ArrayList of events with all the events that start in a given
     * year.
     *
     * @return ArrayList with all events of given year
     */
    ArrayList<Event> getAllEventsOfYear(int year);

    /**
     * Deletes the event with the given title out of the ArrayList.
     *
     * @param title title of the event
     */
    void removeEvent(String title);

    /**
     * Adds an ArrayList of Events.
     *
     * @param eventList the ArrayList of Events that has to be added
     */
    void addEvents(ArrayList<Event> eventList);
}
