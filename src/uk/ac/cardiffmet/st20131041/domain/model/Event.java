package uk.ac.cardiffmet.st20131041.domain.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * The event class keeps track of an event. An Event has a title, description,
 * date, and a persons with a description
 *
 * @author Dries
 * @version 1.0
 */
public class Event {

    /**
     * Title of an Event.
     */
    private String title;

    /**
     * Description of an Event
     */
    private String description;

    /**
     * Start Date Object of an event.
     */
    private Date startDate;

    /**
     * End Date Object of an event.
     */
    private Date endDate;

    /**
     * A HashMap that stores the person and their link with the event.
     */
    private HashMap<Person, String> persons = new HashMap<Person, String>();

    /**
     * Location (object) of an event.
     */
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
     * @param title the title of the event
     * @param desciption the description of the event
     * @param location the location (object) of the event
     * @param startDate the start date (object) of the event
     * @param endDate the end date (object) of the event
     */
    public Event(String title, String desciption, Location location, Date startDate, Date endDate) {
        this.setTitle(title);
        this.setDescription(desciption);
        this.setLocation(location);
        this.setStartDate(startDate);
        this.setEndDate(endDate);
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
     * Gets the start date of the event
     *
     * @return start date of the event
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Gets the end date of the event
     *
     * @return end date of the event.
     */
    public Date getEndDate() {
        return endDate;
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
     *
     * Throws DomainException if the location of the event is null.
     *
     * @param location the location (object) of the event
     */
    public void setLocation(Location location) {
        if (location == null) {
            throw new DomainException("The location of the event cannot be null!");
        }
        this.location = location;
    }

    /**
     * Sets the title of an event.
     *
     * Throws DomainException if the title of the event is null or empty
     *
     * @param title the title of the event
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
     * Throws DomainException if the description is null or empty.
     *
     * @param description the description of the event
     */
    public void setDescription(String description) {
        if (description == null) {
            throw new DomainException("Event description cannot be null!");
        }
        if (description.trim().isEmpty()) {
            throw new DomainException("Event description cannot be empty!");
        }
        this.description = description;
    }

    /**
     * Sets the start date of the event.
     *
     * Throws DomainException if the start date is null. Throws DomainException
     * if the start date is after the end Date. Throws DomainException if start
     * and end date are not in the same year.
     *
     * @param startDate the start date of the event
     */
    public void setStartDate(Date startDate) {
        if (startDate == null) {
            throw new DomainException("Please fill in a valid start date");
        }
        if (this.getEndDate() != null && this.getEndDate().before(startDate)) {
            throw new DomainException("The end date cannot be beforer the start date!");
        }
        if (this.getEndDate() != null && this.getEndDate().getYear() != startDate.getYear()) {
            throw new DomainException("Start date and the end date must be in the same year. Please split the event.");
        }
        this.startDate = startDate;
    }

    /**
     * Sets the start date of an event.
     *
     * Throws DomainException if the endDate is null. Throws DomainException if
     * the start date is after the end Date. Throws DomainException if start and
     * end date are not in the same year.
     *
     * @param endDate the end date of the object
     */
    public void setEndDate(Date endDate) {
        if (endDate == null) {
            throw new DomainException("Please fill in a valid end date");
        }
        if (this.getStartDate() != null && this.getStartDate().after(endDate)) {
            throw new DomainException("Start date cannot be after the end date!");
        }
        if (this.getStartDate() != null && this.getStartDate().getYear() != endDate.getYear()) {
            throw new DomainException("Start date and the end date must be in the same year. Please split the event.");
        }
        this.endDate = endDate;
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
     * @see #addPerson(uk.ac.cardiffmet.st20131041.domain.model.Person,
     * java.lang.String)
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
    public Set<Person> getEveryPerson() {
        return this.persons.keySet();
    }

    /**
     * returns an hash map with all the persons and the description of the
     * correlation.
     *
     * @return hash map with persons an link description
     */
    public HashMap<Person, String> getEveryPersonWithLink() {
        return this.persons;
    }

    /**
     * If hash map persons contains the key, it will be removed. Removes the
     * link between the person and the event.
     *
     * @param person person that will be deleted from the hash map
     */
    public void removePerson(Person person) {
        if (person == null) {
            throw new DomainException("Person cannot be removed because, it is null.");
        }
        this.persons.remove(person);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.title);
        hash = 79 * hash + Objects.hashCode(this.description);
        hash = 79 * hash + Objects.hashCode(this.startDate);
        hash = 79 * hash + Objects.hashCode(this.endDate);
        hash = 79 * hash + Objects.hashCode(this.persons);
        hash = 79 * hash + Objects.hashCode(this.location);
        return hash;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Event other = (Event) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.startDate, other.startDate)) {
            return false;
        }
        if (!Objects.equals(this.endDate, other.endDate)) {
            return false;
        }
        if (!Objects.equals(this.persons, other.persons)) {
            return false;
        }
        if (!Objects.equals(this.location, other.location)) {
            return false;
        }
        return true;
    }

}
