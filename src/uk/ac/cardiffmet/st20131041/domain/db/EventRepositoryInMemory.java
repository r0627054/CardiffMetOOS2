package uk.ac.cardiffmet.st20131041.domain.db;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import uk.ac.cardiffmet.st20131041.domain.model.DomainException;
import uk.ac.cardiffmet.st20131041.domain.model.Event;
import uk.ac.cardiffmet.st20131041.domain.model.Location;

/**
 * The EventRepository class keeps track of all the events in an in memory
 * ArrayList.
 *
 * @author Dries Janse
 * @Version 1.0
 */
public class EventRepositoryInMemory implements EventRepository {

    private ArrayList<Event> events;

    /**
     * The empty constructor initialises the event ArrayList.
     */
    public EventRepositoryInMemory() {
        this.events = new ArrayList<Event>();
        this.addEvent(new Event("Title1", "Description", new Location("country", "postcode", "streetName", "houseNumber"), new Date(120, 00, 02), new Date(120, 00, 03)));
        this.addEvent(new Event("Title2", "Description", new Location("country", "postcode", "streetName", "houseNumber"), new Date(120, 00, 05), new Date(120, 00, 23)));
        this.addEvent(new Event("Title3", "Description qdsf qsdf qsdf qsdf qsdf qsdf qsdf qsdf qsdf  sdf", new Location("country", "postcode", "streetName", "houseNumber"), new Date(117, 00, 11), new Date(117, 00, 16)));
        this.addEvent(new Event("Title99", "Description qdsf qsdf qsdf qsdf qsdf qsdf qsdf qsdf qsdf  sdf", new Location("country", "postcode", "streetName", "houseNumber"), new Date(117, 00, 02), new Date(117, 00, 12)));
                this.addEvent(new Event("Title39", "Description qdsf qsdf qsdf qsdf qsdf qsdf qsdf qsdf qsdf  sdf", new Location("country", "postcode", "streetName", "houseNumber"), new Date(117, 00, 15), new Date(117, 00, 18)));
        this.addEvent(new Event("Title9900", "Description qdsf qsdf qsdf qsdf qsdf qsdf qsdf qsdf qsdf  sdf", new Location("country", "postcode", "streetName", "houseNumber"), new Date(117, 00, 21), new Date(117, 00, 25)));
        this.addEvent(new Event("Title4", "Description", new Location("country", "postcode", "streetName", "houseNumber"), new Date(118, 00, 05), new Date(118, 00, 23)));
    }

    /**
     * Gets the ArrayList with all the events in it.
     *
     * @return ArrayList with all the events
     */
    @Override
    public ArrayList<Event> getEvents() {
        return events;
    }

    /**
     * Sets the ArrayList with Events.
     *
     * @exception Throws DomainException if ArrayList with Events is null.
     * @param events the ArrayList with events
     */
    @Override
    public void setEvents(ArrayList<Event> events) {
        if (events == null) {
            throw new DatabaseException("Cannot set events ArrayList, if null!");
        }
        this.events = events;
    }

    /**
     * Adds an Event to the ArrayList with all the events.
     *
     * @exception Throws DomainException if the event is null.
     * @param event the Event that will be added to the ArrayList
     */
    @Override
    public void addEvent(Event event) {
        if (event == null) {
            throw new DatabaseException("Event cannot be null.");
        }
        if (this.containEventWithTitle(event.getTitle())) {
            throw new DatabaseException("Event already exists with the given title, please choose another title.");
        }
        events.add(event);
    }

    /**
     * Gets the number of events.
     *
     * @return total amount of events
     */
    @Override
    public int getNumberOfEvents() {
        return this.getEvents().size();
    }

    /**
     * Gets the event with the given title or returns null is there is no event
     * available with the given title.
     *
     * @param title
     * @return event with given title or null of no event with the given title
     * is found
     */
    @Override
    public Event getEvent(String title) {
        if (title == null) {
            throw new DatabaseException("Title cannot be null!");
        }
        for (Event e : this.getEvents()) {
            if (e.getTitle().equals(title)) {
                return e;
            }
        }
        return null;
    }

    /**
     * Checks if there is an event with the given title.
     *
     * @param title
     * @return <code>true</code> if title is found in the ArrayList,
     * <code>false</code> is no event exists with the given title.
     */
    @Override
    public boolean containEventWithTitle(String title) {
        if (this.getEvent(title) == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Get an ArrayList with all the different Years in.
     *
     * @return ArrayList with year is.
     */
    @Override
    public ArrayList<Integer> getAllDifferentYears() {
        ArrayList<Integer> allYears = new ArrayList<>();
        for (Event e : this.getEvents()) {
            int year = e.getStartDate().getYear() + 1900 ;
            if (!allYears.contains(year)) {
                allYears.add(year);
            }
        }
        Collections.sort(allYears);
        return allYears;
    }

    /**
     * Gets an ArrayList of events with all the events that start in a given
     * year.
     *
     * @return ArrayList with all events of given year
     */
    @Override
    public ArrayList<Event> getAllEventsOfYear(int year) {
        int correctYear = year -1900;
        ArrayList<Event> yearEvents = new ArrayList<>();
        for (Event e : this.getEvents()) {
            if (e.getStartDate().getYear() == correctYear) {
                yearEvents.add(e);
             }
        }
        return yearEvents;
    }
}
