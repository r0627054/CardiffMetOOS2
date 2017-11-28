package uk.ac.cardiffmet.st20131041.domain.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import uk.ac.cardiffmet.st20131041.domain.db.EventRepository;
import uk.ac.cardiffmet.st20131041.domain.db.EventRepositoryFactory;
import uk.ac.cardiffmet.st20131041.domain.db.PersonRepository;
import uk.ac.cardiffmet.st20131041.domain.db.PersonRepositoryFactory;
import uk.ac.cardiffmet.st20131041.domain.model.Event;
import uk.ac.cardiffmet.st20131041.domain.model.EventFileReader;
import uk.ac.cardiffmet.st20131041.domain.model.EventFileReaderJSON;
import uk.ac.cardiffmet.st20131041.domain.model.EventFileWriter;
import uk.ac.cardiffmet.st20131041.domain.model.EventFileWriterJSON;
import uk.ac.cardiffmet.st20131041.domain.model.EventStartDateComparator;
import uk.ac.cardiffmet.st20131041.domain.model.Person;

/**
 * The EventService class keeps track of all the events and persons.
 *
 * @author Dries Janse
 * @version 1.0
 */
public class EventService {

    /**
     * The repository, where all the events are stored
     */
    private EventRepository eventRepository;

    /**
     * The repository, where all the persons are stored
     */
    private PersonRepository personRepository;

    /**
     * The File reader that will read all the events of file in a format
     */
    private EventFileReader eventFileReader;

    /**
     * The writer that can make a string in a given format of the events
     */
    private EventFileWriter eventFileWriter;

    /**
     * EventRepository and personRepository will be initialised depending of the
     * repository type. The constructor uses the EventRepository and
     * PersonRepository for the object creation. It also creates an
     * eventFileReader and eventFileWriter.
     *
     * @param repositoryType the repository type (string)
     */
    public EventService(String repositoryType) {
        this.eventRepository = EventRepositoryFactory.getEventRepository(repositoryType);
        this.personRepository = PersonRepositoryFactory.getPersonRepository(repositoryType);
        this.eventFileReader = new EventFileReaderJSON();
        this.eventFileWriter = new EventFileWriterJSON();
    }

    /**
     * Gets the eventRepository
     *
     * @return eventRepositroy
     */
    private EventRepository getEventRepository() {
        return eventRepository;
    }

    /**
     * Gets the personRepository
     *
     * @return personRepository
     */
    private PersonRepository getPersonRepository() {
        return personRepository;
    }

    //--------------------------------
    // METHODS OF EVENTREPOSITORY
    //--------------------------------
    /**
     * This method makes use of the method of the eventRepository
     *
     * @see EventRepository#getEvents()
     * @return ArrayList of Events
     */
    public ArrayList<Event> getEvents() {
        return this.getEventRepository().getEvents();
    }

    /**
     * This method makes use of the method of the eventRepository
     *
     * @see EventRepository#setEvents(java.util.ArrayList)
     * @param events the complete list of all the events.
     */
    public void setEvents(ArrayList<Event> events) {
        this.getEventRepository().setEvents(events);
    }

    /**
     * This method makes use of the method of the eventRepository
     *
     * @see
     * EventRepository#addEvent(uk.ac.cardiffmet.st20131041.domain.model.Event)
     * @param event the event that needs to be added.
     */
    public void addEvent(Event event) {
        this.getEventRepository().addEvent(event);
    }

    /**
     * This method makes use of the method of the eventRepository
     *
     * @see EventRepository#getNumberOfEvents()
     * @return number of events
     */
    public int getNumberOfEvents() {
        return this.getEventRepository().getNumberOfEvents();
    }

    /**
     * This method makes use of the method of the eventRepository
     *
     * @see EventRepository#getEvent(java.lang.String)
     * @param title the title of the event that needs to be found.
     * @return the event with the given title.
     */
    public Event getEvent(String title) {
        return this.getEventRepository().getEvent(title);
    }

    /**
     * This method makes use of the method of the eventRepository
     *
     * @see EventRepository#containEventWithTitle(java.lang.String)
     * @param title the title of an event.
     * @return if an event with the given title exists
     */
    public boolean containEventWithTitle(String title) {
        return this.getEventRepository().containEventWithTitle(title);
    }

    /**
     * This method makes use of the method of the eventRepository
     *
     * @see EventRepository#getAllDifferentYears()
     * @return an ArrayList that contains all the different years
     */
    public ArrayList<Integer> getAllDifferentYears() {
        return this.getEventRepository().getAllDifferentYears();
    }

    /**
     * This method makes use of the method of the eventRepository
     *
     * @see EventRepository#getAllEventsOfYear(int)
     * @param year the year for which we need all the events
     * @return a sorted ArrayList of all the events of the year.
     */
    public ArrayList<Event> getAllEventsOfYear(int year) {
        ArrayList<Event> eventsOfYear = this.getEventRepository().getAllEventsOfYear(year);
        Collections.sort(eventsOfYear, new EventStartDateComparator());
        return eventsOfYear;
    }

    /**
     * This method makes use of the method of the eventRepository
     *
     * @see EventRepository#removeEvent(java.lang.String)
     * @param title the title of the event that needs to be removed.
     */
    public void removeEvent(String title) {
        this.getEventRepository().removeEvent(title);
    }

    /**
     * Will add all the given events to the program. This method makes use of
     * the method of the eventRepository
     *
     * @see EventRepository#addEvents(java.util.ArrayList)
     * @param eventList list of events to add.
     */
    private void addAllEvents(ArrayList<Event> eventList) {
        this.getEventRepository().addEvents(eventList);
    }

    //--------------------------------
    // METHODS OF PERSONREPOSITORY
    //--------------------------------
    /**
     * This method makes use of the method of the personRepository
     *
     * @see PersonRepository#getPersons()
     * @return an ArrayList of all the persons
     */
    public ArrayList<Person> getPersons() {
        return this.getPersonRepository().getPersons();
    }

    /**
     * This method makes use of the method of the personRepository
     *
     * @see PersonRepository#setPersons(java.util.ArrayList)
     * @param persons an ArrayList of all the persons that need to be set.
     */
    public void setPersons(ArrayList<Person> persons) {
        this.getPersonRepository().setPersons(persons);
    }

    /**
     * This method makes use of the method of the personRepository
     *
     * @see
     * PersonRepository#addPerson(uk.ac.cardiffmet.st20131041.domain.model.Person)
     * @param person the person object that need to be added
     */
    public void addPerson(Person person) {
        this.getPersonRepository().addPerson(person);
    }

    /**
     * This method makes use of the method of the personRepository
     *
     * @see PersonRepository#getPerson(int)
     * @param index the index on which the person is stored
     * @return Person on given index
     */
    public Person getPerson(int index) {
        return this.getPersonRepository().getPerson(index);
    }

    /**
     * This method makes use of the method of the personRepository
     *
     * @param nickname the nickname of the person
     * @return Person with the given nickname
     */
    public Person getPerson(String nickname) {
        return this.getPersonRepository().getPerson(nickname);
    }

    /**
     * This method makes use of the method of the personRepository
     *
     * @see PersonRepository#getAllNicknames()
     * @return arraylist with all the nicknames of the users
     */
    public ArrayList<String> getAllPersonNames() {
        return this.getPersonRepository().getAllNicknames();
    }

    /**
     * Checks if the personRepository contains a person with the given nickname.
     *
     * @param nickname the nickname of a person
     * @return <code>true</code> if it contains a person with the given
     * nickname, else otherwise.
     */
    public boolean containsPerson(String nickname) {
        return getAllPersonNames().contains(nickname);
    }

    //--------------------------------
    // METHODS OF FILE READER/WRITER
    //--------------------------------
    /**
     * Gets the EventFileReader
     *
     * @return the EventFileReader
     */
    private EventFileReader getEventFileReader() {
        return eventFileReader;
    }

    /**
     * Gets the EventFileWriter
     *
     * @return the EventFileWriter
     */
    private EventFileWriter getEventFileWriter() {
        return eventFileWriter;
    }

    /**
     * Returns all the Events that can be subtracted from the file. This method
     * makes use of the method of the EventFileReader
     *
     * @see EventFileReader#getAllEventsOfFile(java.io.File)
     * @param file the file which contains events
     * @return an ArrayList of Events that can be subtracted from the file.
     */
    public ArrayList<Event> getAllEventsOfFile(File file) {
        return this.getEventFileReader().getAllEventsOfFile(file);
    }

    /**
     * Saves all the that can be subtracted from the file.
     *
     * @param file that contains events
     */
    public void saveAllEventsOfFile(File file) {
        ArrayList<Event> allImportEvents = this.getAllEventsOfFile(file);
        for (Event e : allImportEvents) {
            for (Person p : e.getEveryPerson()) {
                if (!this.containsPerson(p.getNickname())) {
                    this.addPerson(p);
                }
            }
            if (!containEventWithTitle(e.getTitle())) {
                this.addEvent(e);
            }
        }
    }

    /**
     * Gets a (JSON) String of events of all the given events.
     *
     * This method makes use of the method of the EventFileWriter
     *
     * @see EventFileWriter#writeEvents(java.util.ArrayList)
     * @param allEvents list of events which need to be transfered to a (JSON)
     * String.
     * @return String of Events
     */
    private String writeEvents(ArrayList<Event> allEvents) {
        return this.getEventFileWriter().writeEvents(allEvents);
    }

    /**
     * Gets a (JSON) String of events of all the events the running application
     * uses.
     *
     * This method makes use of the method of the EventFileWriter.
     *
     * @see EventFileWriter#writeEvents(java.util.ArrayList)
     * @return String of all the events
     */
    public String writeAllEvents() {
        return this.getEventFileWriter().writeEvents(this.getEvents());
    }

}
