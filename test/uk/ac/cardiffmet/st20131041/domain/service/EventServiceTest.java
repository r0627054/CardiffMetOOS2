package uk.ac.cardiffmet.st20131041.domain.service;

import java.util.ArrayList;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import uk.ac.cardiffmet.st20131041.domain.db.DatabaseException;
import uk.ac.cardiffmet.st20131041.domain.model.Event;
import uk.ac.cardiffmet.st20131041.domain.model.Location;
import uk.ac.cardiffmet.st20131041.domain.model.Person;

/**
 * A JUnit test class that tests all the methods for the EventServiceTest class.
 *
 * @author Dries Janse
 * @version 1.0
 */
public class EventServiceTest {

    /**
     * Instance of the EventService, that needs to be tested
     */
    private EventService service;

    /**
     * Constructor initialises the service object.
     */
    public EventServiceTest() {
        service = new EventService("MEMORY");
    }

    /**
     * Tests the getEvents method. It returns all the events in the repository.
     * All the dummy events checked.
     */
    @Test
    public void test_getEvents_will_give_back_all_the_events() {
        //this methods will give all the dummy events of memory repository
        this.resetEvents();

        ArrayList<Event> getEventsList = service.getEvents();
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
     * Tests the setEvents method. It (overrides) sets all the events.
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
        service.setEvents(allEvents);
        assertEquals(2, service.getEvents().size());
    }

    /**
     * Tests the addEvent method. It should add a new Event to the repository.
     */
    @Test
    public void test_addEvent_throws_database_exception_if_an_event_with_same_title_already_exists() {
        Event e = new Event();
        e.setTitle("New Title");
        service.addEvent(e);
        assertTrue(service.containEventWithTitle("New Title"));
    }

    /**
     * Tests the getNumberOfEvents method. It must give the total number of
     * events in the repository back.
     */
    @Test
    public void test_getNumberOfEvents_gives_the_number_of_events_in_the_repository_back() {
        this.resetEvents();
        assertEquals(7, service.getNumberOfEvents());
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
        Event requestedEvent = service.getEvent("Our House");
        assertEquals(exampleEvent3, requestedEvent);
    }

    /**
     * Tests the containEventWithTitle method. It returns false if there is no
     * event with the given title.
     */
    @Test
    public void test_containEventWithTitle_returns_false_if_event_with_title_not_exists() {
        this.resetEvents();
        assertFalse(service.containEventWithTitle("I don't exist!"));
    }

    /**
     * Tests the containEventWithTitle method. It returns true if there is an
     * event with the given title.
     */
    @Test
    public void test_containEventWithTitle_returns_true_if_event_exists_with_title() {
        this.resetEvents();
        assertTrue(service.containEventWithTitle("Sunset Boulevard"));
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
        assertEquals(yearList, service.getAllDifferentYears());
    }

    /**
     * Tests the removeEvent method. It removes an event with the given title.
     */
    @Test
    public void test_removeEvent_deletes_an_event_with_the_given_title() {
        this.resetEvents();
        service.removeEvent("Cardifferent Historic Pub Tour");
        assertEquals(6, service.getNumberOfEvents());
    }

    /**
     * Test the getPersons method. It has to return all the person.
     */
    @Test
    public void test_getPersons_returns_all_the_persons_in_the_list() {
        this.resetEvents();
        ArrayList<Person> allPersons = service.getPersons();
        assertTrue(allPersons.contains(new Person("Harry", "Smith", "HarryS", new Date(87, 10, 19))));
        assertTrue(allPersons.contains(new Person("Thomas", "Jones", "ThomasJ", new Date(77, 9, 9))));
        assertTrue(allPersons.contains(new Person("Oliver", "Williams", "OliverW", new Date(60, 5, 5))));
        assertTrue(allPersons.contains(new Person("Henry", "Brown", "HenryB", new Date(90, 5, 5))));
    }

    /**
     * Test the addPerson method it should add a valid person to the repository.
     */
    @Test
    public void test_addPerson_adds_a_valid_person_to_the_repository() {
        this.resetPersons();
        service.addPerson(new Person("Dries", "Janse", "DriesJ", new Date(17, 10, 19)));
        assertTrue(service.getPersons().contains(new Person("Dries", "Janse", "DriesJ", new Date(17, 10, 19))));
    }

    /**
     * Test the getPerson method it should get the person at the given index.
     */
    @Test
    public void test_getPerson_returns_the_person_on_that_index_of_the_repository() {
        this.resetPersons();
        assertEquals(new Person("Harry", "Smith", "HarryS", new Date(87, 10, 19)), service.getPerson(0));
        assertEquals(new Person("Thomas", "Jones", "ThomasJ", new Date(77, 9, 9)), service.getPerson(1));
        assertEquals(new Person("Oliver", "Williams", "OliverW", new Date(60, 5, 5)), service.getPerson(2));
        assertEquals(new Person("Henry", "Brown", "HenryB", new Date(90, 5, 5)), service.getPerson(3));
    }

    /**
     * Test the getPerson method it should get the person with the given
     * nickname.
     */
    @Test
    public void test_getPerson_returns_the_person_with_the_given_nickname() {
        this.resetPersons();
        assertEquals(new Person("Harry", "Smith", "HarryS", new Date(87, 10, 19)), service.getPerson("HarryS"));
        assertEquals(new Person("Thomas", "Jones", "ThomasJ", new Date(77, 9, 9)), service.getPerson("ThomasJ"));
        assertEquals(new Person("Oliver", "Williams", "OliverW", new Date(60, 5, 5)), service.getPerson("OliverW"));
        assertEquals(new Person("Henry", "Brown", "HenryB", new Date(90, 5, 5)), service.getPerson("HenryB"));
    }

    /**
     * Test the getAllPersonNames method. It returns all the nicknames of the
     * person objects.
     */
    @Test
    public void test_getAllPersonNames_gives_an_ArrayList_of_all_the_nicknames_back() {
        this.resetPersons();
        ArrayList<String> names = new ArrayList<>();
        names.add("HarryS");
        names.add("ThomasJ");
        names.add("OliverW");
        names.add("HenryB");
        assertEquals(names, service.getAllPersonNames());
    }

    /**
     * Sets the in memory event database to its original dummy variables
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
        service.setEvents(resetArray);
    }

    /**
     * Resets and sets the in memory repository.
     */
    private void resetPersons() {
        ArrayList<Person> allPersons = new ArrayList<Person>();
        allPersons.add(new Person("Harry", "Smith", "HarryS", new Date(87, 10, 19)));
        allPersons.add(new Person("Thomas", "Jones", "ThomasJ", new Date(77, 9, 9)));
        allPersons.add(new Person("Oliver", "Williams", "OliverW", new Date(60, 5, 5)));
        allPersons.add(new Person("Henry", "Brown", "HenryB", new Date(90, 5, 5)));
        service.setPersons(allPersons);
    }

}
