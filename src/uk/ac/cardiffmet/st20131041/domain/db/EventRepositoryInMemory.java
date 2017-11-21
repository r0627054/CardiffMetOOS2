package uk.ac.cardiffmet.st20131041.domain.db;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import uk.ac.cardiffmet.st20131041.domain.model.Event;
import uk.ac.cardiffmet.st20131041.domain.model.Location;
import uk.ac.cardiffmet.st20131041.domain.model.Person;

/**
 * The EventRepository class keeps track of all the events in an in memory
 * ArrayList.
 *
 * @author Dries Janse
 * @version 1.0
 */
public class EventRepositoryInMemory implements EventRepository {

    /**
     * In memory ArrayList of events.
     */
    private ArrayList<Event> events;

    /**
     * The empty constructor initialises the event ArrayList. Added dummy events
     * used to be shown during the demo.
     */
    public EventRepositoryInMemory() {
        this.events = new ArrayList<Event>();

        //exampleEvent1
        Event exampleEvent1 = new Event("Cardifferent Historic Pub Tour", "This historical walking, talking and drinking tour will take you on a journey celebrating the people of Wales and their stories within the setting of it's capital city Cardiff.", new Location("United Kingdom", "CF10 1 AY", "Duke Street", "14"), new Date(117, 00, 11), new Date(117, 00, 16));
        exampleEvent1.addPerson(new Person("Thomas", "Jones", "ThomasJ", new Date(77, 9, 9)), "Organiser");
        this.addEvent(exampleEvent1);

        //exampleEvent2
        Event exampleEvent2 = new Event("Son of a Preacher Man", "Dates and information not yet released", new Location("United Kingdom", "CF24", "Queen St", "5"), new Date(120, 00, 02), new Date(120, 00, 06));
        exampleEvent2.addPerson(new Person("Henry", "Brown", "HenryB", new Date(90, 5, 5)), "Organiser");
        exampleEvent2.addPerson(new Person("Oliver", "Williams", "OliverW", new Date(60, 5, 5)), "Sales Coordinator");
        this.addEvent(exampleEvent2);

        //exampleEvent3
        Event exampleEvent3 = new Event("Our House", "Did you know? - Now you can buy Theatre Tokens at the Cardiff Tourist Information Centre, for use at the New Theatre, St David's Hall, Sherman Theatre and theatres across the UK From the writer of smash hits Calendar Girls and Kinky Boots comes the feel good, Olivier Award-winning MADNESS…", new Location("United Kingdom", "CF10 3LN", "Park Pl", "1"), new Date(120, 00, 05), new Date(120, 00, 23));
        exampleEvent3.addPerson(new Person("Oliver", "Williams", "OliverW", new Date(60, 5, 5)), "Coordinator");
        exampleEvent3.addPerson(new Person("Harry", "Smith", "HarryS", new Date(87, 10, 19)), "Event Executive");
        this.addEvent(exampleEvent3);

        //exampleEvent4
        Event exampleEvent4 = new Event("The Sound of Music", "One of the greatest musicals of all time returns to the stage in this magnificent five star production to enchant the young and the young at heart.", new Location("United Kingdom", "CF10 3LN", "Park Pl", "1"), new Date(117, 00, 02), new Date(117, 00, 12));
        exampleEvent4.addPerson(new Person("Oliver", "Williams", "OliverW", new Date(60, 5, 5)), "Coordinator");
        exampleEvent4.addPerson(new Person("Harry", "Smith", "HarryS", new Date(87, 10, 19)), "Event Staff");
        this.addEvent(exampleEvent4);

        //exampleEvent5
        Event exampleEvent5 = new Event("Sunset Boulevard", "Andrew Lloyd Webber's Tony Award®-winning (Best Musical, Best Original Score & Best Book of a Musical) masterpiece Sunset Boulevard, directed by Nikolai Foster and starring Ria Jones as Norma Desmond, is coming to the Centre. One of the all-time great musicals, Sunset Boulevard is a compelling story of romance and…", new Location("United Kingdom", "CF10 5AL", "Bute Pl", "1"), new Date(117, 00, 15), new Date(117, 00, 18));
        exampleEvent5.addPerson(new Person("Thomas", "Jones", "ThomasJ", new Date(77, 9, 9)), "Organiser");
        exampleEvent5.addPerson(new Person("Oliver", "Williams", "OliverW", new Date(60, 5, 5)), "Sales Coordinator");
        this.addEvent(exampleEvent5);

        //exampleEvent6
        Event exampleEvent6 = new Event("Nina", "A Unity Theatre and Riksteatern co-production with Young Vic Backed by a brilliant band, Olivier Award-nominated actress Josette Bushell-Mingo (Disney's The Lion King) mixes story and song as she draws together tales from the life of Nina Simone and her own extraordinary career. Touching upon the 1960's civil rights movement,…", new Location("United Kingdom", "CF10 3ER", "North Rd", "8"), new Date(117, 00, 21), new Date(117, 00, 25));
        exampleEvent6.addPerson(new Person("Thomas", "Jones", "ThomasJ", new Date(77, 9, 9)), "Staff");
        exampleEvent6.addPerson(new Person("Oliver", "Williams", "OliverW", new Date(60, 5, 5)), "Organiser");
        this.addEvent(exampleEvent6);

        //exampleEvent7
        Event exampleEvent7 = new Event("Classics for All", "Did you know? - Now you can buy Theatre Tokens at the Cardiff Tourist Information Centre, for use at St David's Hall, New Theatre, Sherman Theatre and theatres across the UK Cardiff Philharmonic Orchestra Michael Bell \" Conductor Sara Trickey - Violin Two contrasting symphonies begin and close this concert.", new Location("United Kingdom", "CF10 1AH", "The Hayes", "10"), new Date(118, 00, 05), new Date(118, 00, 23));
        exampleEvent7.addPerson(new Person("Oliver", "Williams", "OliverW", new Date(60, 5, 5)), "Coordinator");
        exampleEvent7.addPerson(new Person("Harry", "Smith", "HarryS", new Date(87, 10, 19)), "Event Staff");
        this.addEvent(exampleEvent7);

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
     * Throws DatabaseException if ArrayList with Events is null.
     *
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
     * Throws DatabaseException if the event is null.
     *
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
     * Throws DatabaseException if the title is null.
     *
     * @param title the title of the event
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
     * @param title the title of the event
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
            int year = e.getStartDate().getYear() + 1900;
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
        int correctYear = year - 1900;
        ArrayList<Event> yearEvents = new ArrayList<>();
        for (Event e : this.getEvents()) {
            if (e.getStartDate().getYear() == correctYear) {
                yearEvents.add(e);
            }
        }
        return yearEvents;
    }

    /**
     * Deletes the event with the given title out of the ArrayList.
     *
     * Throws DatabaseException if the title is null.
     *
     * @param title title of the event
     */
    @Override
    public void removeEvent(String title) {
        if (title == null) {
            throw new DatabaseException("Title cannot be null.");
        }
        for (Event e : this.getEvents()) {
            if (e.getTitle().equals(title)) {
                this.events.remove(e);
                break;
            }
        }
    }

    /**
     * Adds an ArrayList of Events.
     *
     * Throws DatabaseException if the eventList is null
     *
     * @param eventList the ArrayList of Events that has to be added
     */
    @Override
    public void addEvents(ArrayList<Event> eventList) {
        if (eventList == null) {
            throw new DatabaseException("EventList cannot be null!");
        }
        this.getEvents().addAll(eventList);
    }
}
