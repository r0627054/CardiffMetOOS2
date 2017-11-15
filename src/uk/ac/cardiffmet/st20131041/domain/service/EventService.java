package uk.ac.cardiffmet.st20131041.domain.service;

import java.util.ArrayList;
import java.util.Collections;
import uk.ac.cardiffmet.st20131041.domain.db.EventRepository;
import uk.ac.cardiffmet.st20131041.domain.db.EventRepositoryFactory;
import uk.ac.cardiffmet.st20131041.domain.db.PersonRepository;
import uk.ac.cardiffmet.st20131041.domain.db.PersonRepositoryFactory;
import uk.ac.cardiffmet.st20131041.domain.model.Event;
import uk.ac.cardiffmet.st20131041.domain.model.EventStartDateComparator;
import uk.ac.cardiffmet.st20131041.domain.model.Person;

/**
 * The EventService class keeps track of all the events and persons.
 *
 * @author Dries Janse
 * @Version 1.0
 */
public class EventService {

    private EventRepository eventRepository;
    private PersonRepository personRepository;

    /**
     * EventRepository and personRepository will be initialised depending of the
     * repository type. The constructor uses the EventRepository and
     * PersonRepository for the object creation.
     *
     * @param repositoryType
     */
    public EventService(String repositoryType) {
        this.eventRepository = EventRepositoryFactory.getEventRepository(repositoryType);
        this.personRepository = PersonRepositoryFactory.getPersonRepository(repositoryType);
    }

    /**
     * Gets the eventRepository
     *
     * @return eventRepositroy
     */
    public EventRepository getEventRepository() {
        return eventRepository;
    }

    /**
     * Gets the personRepository
     *
     * @return personRepository
     */
    public PersonRepository getPersonRepository() {
        return personRepository;
    }

    //--------------------------------
    // METHODS OF EVENTREPOSITORY
    //--------------------------------
    /**
     * This method makes us of the method of the eventRepository
     *
     * @see EventRepository#getEvents()
     * @return ArrayList of Events
     */
    public ArrayList<Event> getEvents() {
        return this.getEventRepository().getEvents();
    }

    /**
     * This method makes us of the method of the eventRepository
     *
     * @see EventRepository#setEvents(java.util.ArrayList)
     * @param events
     */
    public void setEvents(ArrayList<Event> events) {
        this.getEventRepository().setEvents(events);
    }

    /**
     * This method makes us of the method of the eventRepository
     *
     * @see
     * EventRepository#addEvent(uk.ac.cardiffmet.st20131041.domain.model.Event)
     * @param event
     */
    public void addEvent(Event event) {
        this.getEventRepository().addEvent(event);
    }

    /**
     * This method makes us of the method of the eventRepository
     *
     * @see EventRepository#getNumberOfEvents()
     * @return number of events
     */
    public int getNumberOfEvents() {
        return this.getEventRepository().getNumberOfEvents();
    }

    /**
     * This method makes us of the method of the eventRepository
     *
     * @see EventRepository#getEvent(java.lang.String)
     * @param title
     * @return
     */
    public Event getEvent(String title) {
        return this.getEventRepository().getEvent(title);
    }

    /**
     * This method makes us of the method of the eventRepository
     *
     * @see EventRepository#containEventWithTitle(java.lang.String)
     * @param title
     * @return
     */
    public boolean containEventWithTitle(String title) {
        return this.getEventRepository().containEventWithTitle(title);
    }

    /**
     * This method makes us of the method of the eventRepository
     *
     * @see EventRepository#getAllDifferentYears()
     * @return
     */
    public ArrayList<Integer> getAllDifferentYears() {
        return this.getEventRepository().getAllDifferentYears();
    }

    /**
     * This method makes us of the method of the eventRepository
     *
     * @see EventRepository#getAllEventsOfYear(int)
     * @param year
     * @return a sorted ArrayList of all the events of the year.
     */
    public ArrayList<Event> getAllEventsOfYear(int year) {
        ArrayList<Event> eventsOfYear = this.getEventRepository().getAllEventsOfYear(year);
        Collections.sort(eventsOfYear, new EventStartDateComparator());
        return eventsOfYear;
    }

    /**
     * This method makes us of the method of the eventRepository
     *
     * @see EventRepository#removeEvent(java.lang.String)
     * @param title
     */
    public void removeEvent(String title) {
        this.getEventRepository().removeEvent(title);
    }

    //--------------------------------
    // METHODS OF PERSONREPOSITORY
    //--------------------------------
    /**
     * This method makes us of the method of the personRepository
     *
     * @see PersonRepository#getPersons()
     * @return
     */
    public ArrayList<Person> getPersons() {
        return this.getPersonRepository().getPersons();
    }

    /**
     * This method makes us of the method of the personRepository
     *
     * @see PersonRepository#setPersons(java.util.ArrayList)
     * @param persons
     */
    public void setPersons(ArrayList<Person> persons) {
        this.getPersonRepository().setPersons(persons);
    }

    /**
     * This method makes us of the method of the personRepository
     *
     * @see
     * PersonRepository#addPerson(uk.ac.cardiffmet.st20131041.domain.model.Person)
     * @param person
     */
    public void addPerson(Person person) {
        this.getPersonRepository().addPerson(person);
    }

    /**
     * This method makes us of the method of the personRepository
     *
     * @see PersonRepository#getPerson(int)
     * @param index
     * @return Person on given index
     */
    public Person getPerson(int index) {
        return this.getPersonRepository().getPerson(index);
    }

    /**
     * This method makes us of the method of the personRepository
     *
     * @param nickname
     * @return Person with the given nickname
     */
    public Person getPerson(String nickname) {
        return this.getPersonRepository().getPerson(nickname);
    }

    /**
     * This method makes us of the method of the personRepository
     *
     * @see PersonRepository#getAllNicknames()
     * @return arraylist with all the nicknames of the users
     */
    public ArrayList<String> getAllPersonNames() {
        return this.getPersonRepository().getAllNicknames();
    }
}
