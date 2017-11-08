package uk.ac.cardiffmet.st20131041.domain.model;

import java.util.HashMap;
import java.util.List;

/**
 * The event class keeps track of an event. An Event has a title, description,
 * date, and a persons with a description
 *
 * @author Dries
 * @version 1.0
 */
public class Event {

    private String title;
    private String description;
    private Date date;
    private HashMap<Person, String> persons = new HashMap<Person, String>();
    private Location location;

    /**
     * Empty constructor used for creation of the object afterwards setters can
     * be used separately for validation.
     */
    public Event() {
    }

    /**
     * Parameterised constructor uses title, description, and date. Persons is
     * not a requirement.
     *
     * @param title title of the event
     * @param desciption description of the event
     * @param date date of the event
     */
    public Event(String title, String desciption, Date date, Location location) {
        this.setTitle(title);
        this.setDescription(description);
        this.setDate(date);
        this.setLocation(location);
    }

    /**
     * Gets the title of the event.
     *
     * @return title of the event
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the description of the event
     *
     * @return description of the event.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the date of the event.
     *
     * @return the date object of the event
     */
    public Date getDate() {
        return date;
    }
    
    /**
     * Gets the location of the event.
     * 
     * @return the location object of the event
     */    
    public Location getLocation() {
        return location;
    }

    /**
     * Sets the location of the event.
     * @exception Throws DomainException if the location of the event is null.
     * @param location 
     */
    public void setLocation(Location location) {
        if(location == null){
            throw new DomainException("The location of the event cannot be null!");
        }
        this.location = location;
    }

    /**
     * Sets the title of an event.
     *
     * @exception Throws DomainException if the title of the event is null or
     * empty
     * @param title
     */
    public void setTitle(String title) {
        if (title == null) {
            throw new DomainException("Event Title cannot be null!");
        }
        if (title.trim().isEmpty()) {
            throw new DomainException("Event must have a title!");
        }
        this.title = title;
    }

    /**
     * Sets de description of the event.
     *
     * @exception Throws DomainException if the description is null or empty.
     * @param description
     */
    public void setDescription(String description) {
        if (description == null) {
            throw new DomainException("Event description cannot be null!");
        }
        if (description.trim().isEmpty()) {

        }
        this.description = description;
    }

    /**
     * Sets the date of an event.
     *
     * @exception Throws DomainException if the date is null
     * @param date
     */
    public void setDate(Date date) {
        if (date == null) {
            throw new DomainException("Event date cannot be null!");
        }
        this.date = date;
    }

    /**
     * Adds a person with a description to an event
     *
     * @param person person affiliated to the event
     * @param description description of the affiliation
     */
    public void addPerson(Person person, String description) {
        if (person == null) {
            throw new DomainException("Cannot add person to event. Person is null!");
        }
        if (description == null) {
            throw new DomainException("Cannot add person to event. Description is null!");
        }
        persons.put(person, description);
    }

    /**
     * Adds a person to the event with an empty description.
     *
     * @see addPerson(Person, String)
     *
     * @param person person affiliated to the event
     */
    public void addPerson(Person person) {
        this.addPerson(person, "");
    }

    /**
     * returns the list of all Persons affiliated to the event.
     * 
     * @return All Persons
     */
    public List<Person> getEveryPerson() {
        return (List<Person>) this.persons.keySet();
    }
    
    /**
     * returns an hash map with all the persons and the description of the correlation.
     * 
     * @return hash map with persons an link description
     */
    public HashMap<Person, String> getEveryPersonWithLink(){
        return this.persons;
    }
    
    /**
     * If hash map persons contains the key, it will be removed.
     * Removes the link between the person and the event.
     * 
     * @param person person that will be deleted from the hash map
     */
    public void removePerson(Person person){
        if(person == null){
            throw new DomainException("Person cannot be removed because, it is null.");
        }
        this.persons.remove(person);
    }


    

}
