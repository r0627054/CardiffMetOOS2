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
    public void addEvent(Event event){
        if(event == null){
            throw new DatabaseException("Event cannot be null.");
        }
        if(this.containEventWithTitle(event.getTitle())){
            throw new DatabaseException("Event already exists with the given title, please choose another title.");
        }
        events.add(event);
    }
    
    /**
     * Gets the number of events.
     * @return total amount of events 
     */
    @Override
    public int getNumberOfEvents(){
        return this.getEvents().size();
    }

    /**
     * Gets the event with the given title or returns null is there is no event available with the given title.
     * 
     * @param title
     * @return event with given title or null of no event with the given title is found
     */
    @Override
    public Event getEvent(String title) {
        if(title == null){
            throw new DatabaseException("Title cannot be null!");
        }
        for (Event e : this.getEvents()) {
            if(e.getTitle().equals(title)){
                return e;
            }            
        }
        return null;
    }

    @Override
    public boolean containEventWithTitle(String title) {
        if(this.getEvent(title)== null){
            return false;
        }else {
            return true;
        }
    }
    
       
    

}
