
package uk.ac.cardiffmet.st20131041.domain.service;
import java.util.ArrayList;
import uk.ac.cardiffmet.st20131041.domain.model.DomainException;
import uk.ac.cardiffmet.st20131041.domain.model.Event;

/**
 *The EventService class keeps track of all the events in an ArrayList.
 * 
 * @author Dries
 * @Version 1.0
 */
public class EventService {
    public ArrayList<Event> events;

    /**
     * The empty constructor initialises the event ArrayList
     */
    public EventService() {
        this.events = new ArrayList<Event>();
    }

    /**
     * Gets the ArrayList with all the events in it.
     * 
     * @return ArrayList with all the events
     */
    public ArrayList<Event> getEvents() {
        return events;
    }

    /**
     * Sets the ArrayList with Events.
     * 
     * @exception Throws DomainException if ArrayList with Events is null.
     * @param events the ArrayList with events
     */
    public void setEvents(ArrayList<Event> events) {
        if(events == null){
            throw new DomainException("Cannot set events ArrayList, if null!");
        }
        this.events = events;
    }
    
    /**
     * Adds an Event to the ArrayList with all the events.
     * 
     * @exception Throws DomainException if the event is null.
     * @param event the Event that will be added to the ArrayList
     */
    public void addEvent(Event event){
        if(event == null){
            throw new DomainException("Event cannot be null.");
        }
        events.add(event);
    }   
}
