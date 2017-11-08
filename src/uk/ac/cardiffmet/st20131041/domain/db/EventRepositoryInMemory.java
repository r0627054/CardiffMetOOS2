package uk.ac.cardiffmet.st20131041.domain.db;

import java.util.ArrayList;
import uk.ac.cardiffmet.st20131041.domain.model.DomainException;
import uk.ac.cardiffmet.st20131041.domain.model.Event;

/**
 * The EventRepository class keeps track of all the events in an in memory ArrayList.
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
    @Override
    public void addEvent(Event event){
        if(event == null){
            throw new DomainException("Event cannot be null.");
        }
        events.add(event);
    }
    
    /**
     * Gets the number of events.
     * @return total amount of events 
     */
    @Override
    public int getNumberOfEvents(){
        return this.events.size();
    }

}
