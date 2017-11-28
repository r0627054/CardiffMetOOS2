package uk.ac.cardiffmet.st20131041.domain.db;

import java.util.ArrayList;
import java.util.Date;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Rule;
import uk.ac.cardiffmet.st20131041.domain.model.Event;
import uk.ac.cardiffmet.st20131041.domain.model.Location;
import uk.ac.cardiffmet.st20131041.domain.model.Person;

/**
 * A JUnit test class that tests all the methods for the EventRepositoryInMemory
 * class.
 *
 * @author Dries Janse
 * @version 1.0
 */
public class EventRepositoryInMemoryTest {

    /**
     * Used for checking if the exception is thrown.
     */
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    /**
     * an object that can be tested
     */
    private EventRepository repo = EventRepositoryInMemory.getInstance();

    /**
     * Tests the getEvent method. If the title parameter is null, then a
     * database exception is thrown.
     */
    @Test
    public void test_getEvent_throws_DatabaseException_if_title_is_null() {
        thrown.expect(DatabaseException.class);
        thrown.expectMessage("Title cannot be null!");
        repo.getEvent(null);
    }

    /**
     * Tests the getEvent method. If the title is not found in the repository
     * then a null is returned.
     */
    @Test
    public void test_getEvent_returns_null_if_the_event_is_not_find() {
        assertNull(repo.getEvent("Fake event"));
    }

    /**
     * Tests the getEvent method. It returns the Event object corresponding with
     * event title.
     */
    @Test
    public void test_getEvent_returns_the_event_object_if_that_corresponds_with_the_title() {
        this.resetEvents();
        Event exampleEvent3 = new Event("Our House", "Did you know? - Now you can buy Theatre Tokens at the Cardiff Tourist Information Centre, for use at the New Theatre, St David's Hall, Sherman Theatre and theatres across the UK From the writer of smash hits Calendar Girls and Kinky Boots comes the feel good, Olivier Award-winning MADNESS…", new Location("United Kingdom", "CF10 3LN", "Park Pl", "1"), new Date(120, 00, 05), new Date(120, 00, 23));
        exampleEvent3.addPerson(new Person("Oliver", "Williams", "OliverW", new Date(60, 5, 5)), "Coordinator");
        exampleEvent3.addPerson(new Person("Harry", "Smith", "HarryS", new Date(87, 10, 19)), "Event Executive");
        Event requestedEvent = repo.getEvent("Our House");
        assertEquals(exampleEvent3, requestedEvent);
    }

    /**
     * Tests the getEvents method. It returns all the events in the repository.
     * All the dummy events checked.
     */
    @Test
    public void test_getEvents_will_give_back_all_the_events() {
        //this methods will give all the dummy events of memory repository
        this.resetEvents();

        ArrayList<Event> getEventsList = repo.getEvents();
        //exampleEvent1
        Event exampleEvent1 = new Event("Cardifferent Historic Pub Tour", "This historical walking, talking and drinking tour will take you on a journey celebrating the people of Wales and their stories within the setting of it's capital city Cardiff.", new Location("United Kingdom", "CF10 1 AY", "Duke Street", "14"), new Date(117, 00, 11), new Date(117, 00, 16));
        exampleEvent1.addPerson(new Person("Thomas", "Jones", "ThomasJ", new Date(77, 9, 9)), "Organiser");
        assertTrue(getEventsList.contains(exampleEvent1));

        //exampleEvent2
        Event exampleEvent2 = new Event("Son of a Preacher Man", "Dates and information not yet released", new Location("United Kingdom", "CF24", "Queen St", "5"), new Date(120, 00, 02), new Date(120, 00, 06));
        exampleEvent2.addPerson(new Person("Henry", "Brown", "HenryB", new Date(90, 5, 5)), "Organiser");
        exampleEvent2.addPerson(new Person("Oliver", "Williams", "OliverW", new Date(60, 5, 5)), "Sales Coordinator");
        assertTrue(getEventsList.contains(exampleEvent2));

        //exampleEvent3
        Event exampleEvent3 = new Event("Our House", "Did you know? - Now you can buy Theatre Tokens at the Cardiff Tourist Information Centre, for use at the New Theatre, St David's Hall, Sherman Theatre and theatres across the UK From the writer of smash hits Calendar Girls and Kinky Boots comes the feel good, Olivier Award-winning MADNESS…", new Location("United Kingdom", "CF10 3LN", "Park Pl", "1"), new Date(120, 00, 05), new Date(120, 00, 23));
        exampleEvent3.addPerson(new Person("Oliver", "Williams", "OliverW", new Date(60, 5, 5)), "Coordinator");
        exampleEvent3.addPerson(new Person("Harry", "Smith", "HarryS", new Date(87, 10, 19)), "Event Executive");
        assertTrue(getEventsList.contains(exampleEvent3));

        //exampleEvent4
        Event exampleEvent4 = new Event("The Sound of Music", "One of the greatest musicals of all time returns to the stage in this magnificent five star production to enchant the young and the young at heart.", new Location("United Kingdom", "CF10 3LN", "Park Pl", "1"), new Date(117, 00, 02), new Date(117, 00, 12));
        exampleEvent4.addPerson(new Person("Oliver", "Williams", "OliverW", new Date(60, 5, 5)), "Coordinator");
        exampleEvent4.addPerson(new Person("Harry", "Smith", "HarryS", new Date(87, 10, 19)), "Event Staff");
        assertTrue(getEventsList.contains(exampleEvent4));

        //exampleEvent5
        Event exampleEvent5 = new Event("Sunset Boulevard", "Andrew Lloyd Webber's Tony Award®-winning (Best Musical, Best Original Score & Best Book of a Musical) masterpiece Sunset Boulevard, directed by Nikolai Foster and starring Ria Jones as Norma Desmond, is coming to the Centre. One of the all-time great musicals, Sunset Boulevard is a compelling story of romance and…", new Location("United Kingdom", "CF10 5AL", "Bute Pl", "1"), new Date(117, 00, 15), new Date(117, 00, 18));
        exampleEvent5.addPerson(new Person("Thomas", "Jones", "ThomasJ", new Date(77, 9, 9)), "Organiser");
        exampleEvent5.addPerson(new Person("Oliver", "Williams", "OliverW", new Date(60, 5, 5)), "Sales Coordinator");
        assertTrue(getEventsList.contains(exampleEvent5));

        //exampleEvent6
        Event exampleEvent6 = new Event("Nina", "A Unity Theatre and Riksteatern co-production with Young Vic Backed by a brilliant band, Olivier Award-nominated actress Josette Bushell-Mingo (Disney's The Lion King) mixes story and song as she draws together tales from the life of Nina Simone and her own extraordinary career. Touching upon the 1960's civil rights movement,…", new Location("United Kingdom", "CF10 3ER", "North Rd", "8"), new Date(117, 00, 21), new Date(117, 00, 25));
        exampleEvent6.addPerson(new Person("Thomas", "Jones", "ThomasJ", new Date(77, 9, 9)), "Staff");
        exampleEvent6.addPerson(new Person("Oliver", "Williams", "OliverW", new Date(60, 5, 5)), "Organiser");
        assertTrue(getEventsList.contains(exampleEvent6));

        //exampleEvent7
        Event exampleEvent7 = new Event("Classics for All", "Did you know? - Now you can buy Theatre Tokens at the Cardiff Tourist Information Centre, for use at St David's Hall, New Theatre, Sherman Theatre and theatres across the UK Cardiff Philharmonic Orchestra Michael Bell \" Conductor Sara Trickey - Violin Two contrasting symphonies begin and close this concert.", new Location("United Kingdom", "CF10 1AH", "The Hayes", "10"), new Date(118, 00, 05), new Date(118, 00, 23));
        exampleEvent7.addPerson(new Person("Oliver", "Williams", "OliverW", new Date(60, 5, 5)), "Coordinator");
        exampleEvent7.addPerson(new Person("Harry", "Smith", "HarryS", new Date(87, 10, 19)), "Event Staff");
        assertTrue(getEventsList.contains(exampleEvent7));
    }

    /**
     * Tests the setEvents method. It (overrides) sets all the events in the
     * repository.
     */
    @Test
    public void test_setEvents_sets_the_arraylist_of_events() {
        ArrayList<Event> allEvents = new ArrayList<>();
        //exampleEvent6
        Event exampleEvent1 = new Event("Nina", "A Unity Theatre and Riksteatern co-production with Young Vic Backed by a brilliant band, Olivier Award-nominated actress Josette Bushell-Mingo (Disney's The Lion King) mixes story and song as she draws together tales from the life of Nina Simone and her own extraordinary career. Touching upon the 1960's civil rights movement,…", new Location("United Kingdom", "CF10 3ER", "North Rd", "8"), new Date(117, 00, 21), new Date(117, 00, 25));
        exampleEvent1.addPerson(new Person("Oliver", "Williams", "OliverW", new Date(60, 5, 5)), "Coordinator");
        exampleEvent1.addPerson(new Person("Harry", "Smith", "HarryS", new Date(87, 10, 19)), "Event Staff");
        //exampleEvent7
        Event exampleEvent2 = new Event("Classics for All", "Did you know? - Now you can buy Theatre Tokens at the Cardiff Tourist Information Centre, for use at St David's Hall, New Theatre, Sherman Theatre and theatres across the UK Cardiff Philharmonic Orchestra Michael Bell \" Conductor Sara Trickey - Violin Two contrasting symphonies begin and close this concert.", new Location("United Kingdom", "CF10 1AH", "The Hayes", "10"), new Date(118, 00, 05), new Date(118, 00, 23));
        exampleEvent2.addPerson(new Person("Thomas", "Jones", "ThomasJ", new Date(77, 9, 9)), "Staff");
        exampleEvent2.addPerson(new Person("Oliver", "Williams", "OliverW", new Date(60, 5, 5)), "Organiser");
        allEvents.add(exampleEvent1);
        allEvents.add(exampleEvent2);
        repo.setEvents(allEvents);
        assertEquals(2, repo.getEvents().size());
    }

    /**
     * Tests the setEvents method. It throws a database exception if the
     * parameter is null.
     */
    @Test
    public void test_setEvents_throws_database_exception_if_parameter_is_null() {
        thrown.expect(DatabaseException.class);
        thrown.expectMessage("Cannot set events ArrayList, if null!");
        repo.setEvents(null);
    }

    /**
     * Tests the addEvent method. It throws a database exception if the
     * parameter is null.
     */
    @Test
    public void test_addEvent_throws_database_exception_if_parameter_is_null() {
        thrown.expect(DatabaseException.class);
        thrown.expectMessage("Event cannot be null.");
        repo.addEvent(null);
    }

    /**
     * Tests the addEvent method. It throws a database exception if the
     * parameter is empty.
     */
    @Test
    public void test_addEvent_throws_database_exception_if_an_event_with_same_title_already_exists() {
        this.resetEvents();
        thrown.expect(DatabaseException.class);
        thrown.expectMessage("Event already exists with the given title, please choose another title.");
        Event e = new Event();
        e.setTitle("Cardifferent Historic Pub Tour");
        repo.addEvent(e);
    }

    /**
     * Tests the getNumberOfEvents method. It must give the total number of
     * events in the repository back.
     */
    @Test
    public void test_getNumberOfEvents_gives_the_correct_size_of_the_arraylist_back() {
        this.resetEvents();
        assertEquals(7, repo.getNumberOfEvents());
    }

    /**
     * Tests the getNumberOfEvents method. It must give the total number of
     * events in the repository back.
     */
    @Test
    public void test_getNumberOfEvents_gives_the_correct_size_of_the_arraylist_back_if_ArrayList_empty_is() {
        repo.setEvents(new ArrayList<>());
        assertEquals(0, repo.getNumberOfEvents());
    }

    /**
     * Tests the addEvent method. It adds an event if a correct parameter is
     * given.
     */
    @Test
    public void test_addEvent_adds_a_event_if_it_is_a_fully_correct_event() {
        repo.setEvents(new ArrayList<>());
        Event exampleEvent5 = new Event("Sunset Boulevard", "Andrew Lloyd Webber's Tony Award®-winning (Best Musical, Best Original Score & Best Book of a Musical) masterpiece Sunset Boulevard, directed by Nikolai Foster and starring Ria Jones as Norma Desmond, is coming to the Centre. One of the all-time great musicals, Sunset Boulevard is a compelling story of romance and…", new Location("United Kingdom", "CF10 5AL", "Bute Pl", "1"), new Date(117, 00, 15), new Date(117, 00, 18));
        exampleEvent5.addPerson(new Person("Thomas", "Jones", "ThomasJ", new Date(77, 9, 9)), "Organiser");
        exampleEvent5.addPerson(new Person("Oliver", "Williams", "OliverW", new Date(60, 5, 5)), "Sales Coordinator");
        repo.addEvent(exampleEvent5);
        assertTrue(repo.getEvents().contains(exampleEvent5));
    }

    /**
     * Tests the containEventWithTitle method. It returns false if there is no
     * event with the given title.
     */
    @Test
    public void test_containEventWithTitle_returns_false_if_event_with_title_not_exists() {
        this.resetEvents();
        assertFalse(repo.containEventWithTitle("I don't exist!"));
    }

    /**
     * Tests the containEventWithTitle method. It returns true if there is an
     * event with the given title.
     */
    @Test
    public void test_containEventWithTitle_returns_true_if_event_exists_with_title() {
        this.resetEvents();
        assertTrue(repo.containEventWithTitle("Sunset Boulevard"));
    }

    /**
     * Tests the containEventWithTitle method. It returns true if there is an
     * event with the given title.
     */
    @Test
    public void test_containEventWithTitle_throws_database_exception_if_title_is_null() {
        thrown.expect(DatabaseException.class);
        thrown.expectMessage("Title cannot be null!");
        repo.containEventWithTitle(null);
    }

    /**
     * Tests the getAllDifferentYears method. It returns a sorted list of the
     * events in the repository.
     */
    @Test
    public void test_getAllDifferentYears_returns_an_ArrayList_of_all_the_years() {
        this.resetEvents();
        ArrayList<Integer> yearList = new ArrayList<>();
        yearList.add(2017);
        yearList.add(2018);
        yearList.add(2020);
        assertEquals(yearList, repo.getAllDifferentYears());
    }

    /**
     * Tests the getAllEventsOfYear method. It returns all the events of a given
     * year.
     */
    @Test
    public void test_getAllEventsOfYear_returns_all_events_of_a_given_year() {
        this.resetEvents();
        ArrayList<Event> allEventsOfyear = repo.getAllEventsOfYear(2017);
        assertTrue(repo.containEventWithTitle("Cardifferent Historic Pub Tour"));
        assertTrue(repo.containEventWithTitle("The Sound of Music"));
        assertTrue(repo.containEventWithTitle("Sunset Boulevard"));
        assertTrue(repo.containEventWithTitle("Nina"));
    }

    /**
     * Tests the removeEvent method. It throws a database exception if the
     * parameter is null.
     */
    @Test
    public void test_removeEvent_throws_database_exception_if_parameter_is_null() {
        thrown.expect(DatabaseException.class);
        thrown.expectMessage("Title cannot be null.");
        repo.removeEvent(null);
    }

    /**
     * Tests the removeEvent method. It removes an event with the given title.
     */
    @Test
    public void test_removeEvent_deletes_an_event_with_the_given_title() {
        this.resetEvents();
        repo.removeEvent("Cardifferent Historic Pub Tour");
        assertEquals(6, repo.getNumberOfEvents());
    }

    /**
     * Tests the addEvent method. It throws a database exception if the
     * parameter is null.
     */
    @Test
    public void test_addEvents_throws_Database_exception_if_the_parameter_is_null() {
        thrown.expect(DatabaseException.class);
        thrown.expectMessage("EventList cannot be null!");
        repo.addEvents(null);
    }

    /**
     * Tests the addEvent method. It adds an ArrayList of events to the
     * repository.
     */
    @Test
    public void test_addEvents_sets_a_given_arraylist_of_events() {
        this.resetEvents();
        ArrayList<Event> eventList = new ArrayList<>();
        //exampleEvent4
        Event exampleEvent1 = new Event("New Event 1", "One of the greatest musicals of all time returns to the stage in this magnificent five star production to enchant the young and the young at heart.", new Location("United Kingdom", "CF10 3LN", "Park Pl", "1"), new Date(117, 00, 02), new Date(117, 00, 12));
        exampleEvent1.addPerson(new Person("Oliver", "Williams", "OliverW", new Date(60, 5, 5)), "Coordinator");
        exampleEvent1.addPerson(new Person("Harry", "Smith", "HarryS", new Date(87, 10, 19)), "Event Staff");
        eventList.add(exampleEvent1);

        //exampleEvent5
        Event exampleEvent2 = new Event("New Event 2", "Andrew Lloyd Webber's Tony Award®-winning (Best Musical, Best Original Score & Best Book of a Musical) masterpiece Sunset Boulevard, directed by Nikolai Foster and starring Ria Jones as Norma Desmond, is coming to the Centre. One of the all-time great musicals, Sunset Boulevard is a compelling story of romance and…", new Location("United Kingdom", "CF10 5AL", "Bute Pl", "1"), new Date(117, 00, 15), new Date(117, 00, 18));
        exampleEvent2.addPerson(new Person("Thomas", "Jones", "ThomasJ", new Date(77, 9, 9)), "Organiser");
        exampleEvent2.addPerson(new Person("Oliver", "Williams", "OliverW", new Date(60, 5, 5)), "Sales Coordinator");
        eventList.add(exampleEvent2);

        repo.addEvents(eventList);
        assertEquals(9, repo.getNumberOfEvents());
        assertTrue(repo.getEvents().contains(exampleEvent1));
        assertTrue(repo.getEvents().contains(exampleEvent2));
    }

    /**
     * Sets the in memory database to its original dummy variables
     */
    private void resetEvents() {
        ArrayList<Event> resetArray = new ArrayList<>();
        //exampleEvent1
        Event exampleEvent1 = new Event("Cardifferent Historic Pub Tour", "This historical walking, talking and drinking tour will take you on a journey celebrating the people of Wales and their stories within the setting of it's capital city Cardiff.", new Location("United Kingdom", "CF10 1 AY", "Duke Street", "14"), new Date(117, 00, 11), new Date(117, 00, 16));
        exampleEvent1.addPerson(new Person("Thomas", "Jones", "ThomasJ", new Date(77, 9, 9)), "Organiser");
        resetArray.add(exampleEvent1);

        //exampleEvent2
        Event exampleEvent2 = new Event("Son of a Preacher Man", "Dates and information not yet released", new Location("United Kingdom", "CF24", "Queen St", "5"), new Date(120, 00, 02), new Date(120, 00, 06));
        exampleEvent2.addPerson(new Person("Henry", "Brown", "HenryB", new Date(90, 5, 5)), "Organiser");
        exampleEvent2.addPerson(new Person("Oliver", "Williams", "OliverW", new Date(60, 5, 5)), "Sales Coordinator");
        resetArray.add(exampleEvent2);

        //exampleEvent3
        Event exampleEvent3 = new Event("Our House", "Did you know? - Now you can buy Theatre Tokens at the Cardiff Tourist Information Centre, for use at the New Theatre, St David's Hall, Sherman Theatre and theatres across the UK From the writer of smash hits Calendar Girls and Kinky Boots comes the feel good, Olivier Award-winning MADNESS…", new Location("United Kingdom", "CF10 3LN", "Park Pl", "1"), new Date(120, 00, 05), new Date(120, 00, 23));
        exampleEvent3.addPerson(new Person("Oliver", "Williams", "OliverW", new Date(60, 5, 5)), "Coordinator");
        exampleEvent3.addPerson(new Person("Harry", "Smith", "HarryS", new Date(87, 10, 19)), "Event Executive");
        resetArray.add(exampleEvent3);

        //exampleEvent4
        Event exampleEvent4 = new Event("The Sound of Music", "One of the greatest musicals of all time returns to the stage in this magnificent five star production to enchant the young and the young at heart.", new Location("United Kingdom", "CF10 3LN", "Park Pl", "1"), new Date(117, 00, 02), new Date(117, 00, 12));
        exampleEvent4.addPerson(new Person("Oliver", "Williams", "OliverW", new Date(60, 5, 5)), "Coordinator");
        exampleEvent4.addPerson(new Person("Harry", "Smith", "HarryS", new Date(87, 10, 19)), "Event Staff");
        resetArray.add(exampleEvent4);

        //exampleEvent5
        Event exampleEvent5 = new Event("Sunset Boulevard", "Andrew Lloyd Webber's Tony Award®-winning (Best Musical, Best Original Score & Best Book of a Musical) masterpiece Sunset Boulevard, directed by Nikolai Foster and starring Ria Jones as Norma Desmond, is coming to the Centre. One of the all-time great musicals, Sunset Boulevard is a compelling story of romance and…", new Location("United Kingdom", "CF10 5AL", "Bute Pl", "1"), new Date(117, 00, 15), new Date(117, 00, 18));
        exampleEvent5.addPerson(new Person("Thomas", "Jones", "ThomasJ", new Date(77, 9, 9)), "Organiser");
        exampleEvent5.addPerson(new Person("Oliver", "Williams", "OliverW", new Date(60, 5, 5)), "Sales Coordinator");
        resetArray.add(exampleEvent5);

        //exampleEvent6
        Event exampleEvent6 = new Event("Nina", "A Unity Theatre and Riksteatern co-production with Young Vic Backed by a brilliant band, Olivier Award-nominated actress Josette Bushell-Mingo (Disney's The Lion King) mixes story and song as she draws together tales from the life of Nina Simone and her own extraordinary career. Touching upon the 1960's civil rights movement,…", new Location("United Kingdom", "CF10 3ER", "North Rd", "8"), new Date(117, 00, 21), new Date(117, 00, 25));
        exampleEvent6.addPerson(new Person("Thomas", "Jones", "ThomasJ", new Date(77, 9, 9)), "Staff");
        exampleEvent6.addPerson(new Person("Oliver", "Williams", "OliverW", new Date(60, 5, 5)), "Organiser");
        resetArray.add(exampleEvent6);

        //exampleEvent7
        Event exampleEvent7 = new Event("Classics for All", "Did you know? - Now you can buy Theatre Tokens at the Cardiff Tourist Information Centre, for use at St David's Hall, New Theatre, Sherman Theatre and theatres across the UK Cardiff Philharmonic Orchestra Michael Bell \" Conductor Sara Trickey - Violin Two contrasting symphonies begin and close this concert.", new Location("United Kingdom", "CF10 1AH", "The Hayes", "10"), new Date(118, 00, 05), new Date(118, 00, 23));
        exampleEvent7.addPerson(new Person("Oliver", "Williams", "OliverW", new Date(60, 5, 5)), "Coordinator");
        exampleEvent7.addPerson(new Person("Harry", "Smith", "HarryS", new Date(87, 10, 19)), "Event Staff");
        resetArray.add(exampleEvent7);
        this.repo.setEvents(resetArray);
    }

}
