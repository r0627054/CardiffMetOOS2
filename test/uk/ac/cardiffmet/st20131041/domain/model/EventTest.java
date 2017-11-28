package uk.ac.cardiffmet.st20131041.domain.model;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 * A JUnit test class that tests all the methods for the Event class.
 *
 * @author Dries Janse
 * @version 1.0
 */
public class EventTest {

    private Location location;
    private Event emptyEvent;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    /**
     * The constructor, creates an location object that is commonly used.
     */
    public EventTest() {
        location = new Location("Belgium", "3130", "Staeystraat", "88");
        emptyEvent = new Event();
    }
    
    private Location getLocation() {
        return location;
    }

    /**
     * Test the constructor with all the instance variables. All the variables
     * needs to be set.
     */
    @Test
    public void test_constructor_with_all_instance_variables_sets_all_the_variables() {

        Event event = new Event("testTitle", "description", this.getLocation(), new Date(170, 5, 1), new Date(170, 6, 1));
        assertEquals("testTitle", event.getTitle());
        assertEquals("description", event.getDescription());

        //test location data
        assertEquals("Belgium", event.getLocation().getCountry());
        assertEquals("3130", event.getLocation().getPostcode());
        assertEquals("Staeystraat", event.getLocation().getStreetName());
        assertEquals("88", event.getLocation().getHouseNumber());

        assertEquals(new Date(170, 5, 1), event.getStartDate());
        assertEquals(new Date(170, 6, 1), event.getEndDate());
    }

    /**
     * Tests if an empty constructor, creates an empty object with null values.
     */
    @Test
    public void test_empty_constructor_creates_event_object_with_null_values() {
        assertEquals(null, emptyEvent.getTitle());
        assertEquals(null, emptyEvent.getDescription());

        //test location data
        assertEquals(null, emptyEvent.getLocation());

        assertEquals(null, emptyEvent.getStartDate());
        assertEquals(null, emptyEvent.getEndDate());
    }

    /**
     * tests if the location of an event is not null. If it is null, then a
     * domainException should be thrown
     */
    @Test
    public void test_setLocation_throws_DomainException_if_location_is_null() {
        thrown.expect(DomainException.class);
        thrown.expectMessage("The location of the event cannot be null!");
        emptyEvent.setLocation(null);
    }

    /**
     * Tests if the setter for the location works. The location should be set to
     * the event.
     */
    @Test
    public void test_setLocation_sets_the_correct_location_to_the_event() {
        emptyEvent.setLocation(this.getLocation());
        assertEquals("Belgium", emptyEvent.getLocation().getCountry());
        assertEquals("3130", emptyEvent.getLocation().getPostcode());
        assertEquals("Staeystraat", emptyEvent.getLocation().getStreetName());
        assertEquals("88", emptyEvent.getLocation().getHouseNumber());
    }

    /**
     * Tests if the setter for the title works. It should throw a
     * domainException if the title is set to null
     */
    @Test
    public void test_setTitle_throws_DomainException_if_the_title_is_null() {
        thrown.expect(DomainException.class);
        thrown.expectMessage("Event Title cannot be null!");
        emptyEvent.setTitle(null);
    }

    /**
     * Tests if the setter for the title works. It should throw a
     * domainException if the title is empty
     */
    @Test
    public void test_setTitle_throws_DomainException_if_the_title_is_empty() {
        thrown.expect(DomainException.class);
        thrown.expectMessage("Event must have a title!");
        emptyEvent.setTitle("");
    }

    /**
     * Tests if the setter for the title works. It should set a correct title of
     * the event.
     */
    @Test
    public void test_setTitle_will_set_the_title_if_a_correct_string_is_entered() {
        emptyEvent.setTitle("Movie night Belgium");
        assertEquals("Movie night Belgium", emptyEvent.getTitle());
    }

    /**
     * Tests if the setter for the description works. It should throw a
     * domainException if the description is set to null.
     */
    @Test
    public void test_setDescription_throws_DomainException_if_the_description_is_null() {
        thrown.expect(DomainException.class);
        thrown.expectMessage("Event description cannot be null!");
        emptyEvent.setDescription(null);
    }

    /**
     * Tests if the setter for the description works. It should throw a
     * domainException if the description is empty
     */
    @Test
    public void test_setDescription_throws_DomainException_if_the_description_is_empty() {
        thrown.expect(DomainException.class);
        thrown.expectMessage("Event description cannot be empty!");
        emptyEvent.setDescription("");
    }

    /**
     * Tests if the setter for the description works. It should set a correct
     * description of the event.
     */
    @Test
    public void test_setDescription_will_set_the_description_if_a_correct_string_is_entered() {
        emptyEvent.setDescription("A fun night out with friends.");
        assertEquals("A fun night out with friends.", emptyEvent.getDescription());
    }

    /**
     * Tests if the setter for the startDate works. It should throw a
     * domainException if the startDate is null.
     */
    @Test
    public void test_setStartDate_throws_domainException_if_startDate_is_null() {
        thrown.expect(DomainException.class);
        thrown.expectMessage("Please fill in a valid start date");
        emptyEvent.setStartDate(null);
    }

    /**
     * Tests if the setter for the startDate works. It should throw a
     * domainException if the startDate is after the endDate.
     */
    @Test
    public void test_setStartDate_throws_domainException_if_startDate_is_after_endDate() {
        thrown.expect(DomainException.class);
        thrown.expectMessage("The end date cannot be beforer the start date!");
        emptyEvent.setEndDate(new Date(107, 2, 2));
        emptyEvent.setStartDate(new Date(107, 4, 2));
    }

    /**
     * Tests if the setter for the startDate works. It should throw a
     * domainException if the startDate is in another year then the endDate.
     */
    @Test
    public void test_setStartDate_throws_domainException_if_startDate_is_in_other_year_then_endDate() {
        thrown.expect(DomainException.class);
        thrown.expectMessage("Start date and the end date must be in the same year. Please split the event.");
        emptyEvent.setEndDate(new Date(107, 2, 2));
        emptyEvent.setStartDate(new Date(106, 4, 2));
    }

    /**
     * Tests if the setter for the startDate works. It should set a valid
     * startDate.
     *
     */
    @Test
    public void test_setStartDate_sets_a_valid_startDate() {
        emptyEvent.setEndDate(new Date(106, 2, 2));
        emptyEvent.setStartDate(new Date(106, 1, 2));
        assertEquals(new Date(106, 1, 2), emptyEvent.getStartDate());
    }

    /**
     * Tests if the setter for the endDate works. It should throw a
     * domainException if the endDate is null.
     */
    @Test
    public void test_setEndDate_throws_domainException_if_endDate_is_null() {
        thrown.expect(DomainException.class);
        thrown.expectMessage("Please fill in a valid end date");
        emptyEvent.setEndDate(null);
    }

    /**
     * Tests if the setter for the endDate works. It should throw a
     * domainException if the startDate is after the endDate.
     */
    @Test
    public void test_setEndDate_throws_domainException_if_startDate_is_after_endDate() {
        thrown.expect(DomainException.class);
        thrown.expectMessage("Start date cannot be after the end date!");
        Event e = new Event();
        e.setStartDate(new Date(107, 4, 2));
        e.setEndDate(new Date(107, 2, 2));
    }

    /**
     * Tests if the setter for the endDate works. It should throw a
     * domainException if the startDate is in another year then the endDate.
     */
    @Test
    public void test_setEndDate_throws_domainException_if_endDate_is_in_other_year_then_startDate() {
        thrown.expect(DomainException.class);
        thrown.expectMessage("Start date and the end date must be in the same year. Please split the event.");
        Event e = new Event();
        e.setStartDate(new Date(106, 4, 2));
        e.setEndDate(new Date(107, 2, 2));
    }

    /**
     * Tests if the setter for the endDate works. It should set a valid endDate.
     *
     */
    @Test
    public void test_setEndDate_sets_a_valid_endDate() {
        Event e = new Event();
        e.setEndDate(new Date(107, 2, 2));
        assertEquals(new Date(107, 2, 2), e.getEndDate());
    }

    /**
     * Tests if the addPerson method works. It should throw a DomainException if
     * the person is null.
     */
    @Test
    public void test_addPerson_with_description_throws_domain_exception_if_person_is_null() {
        thrown.expect(DomainException.class);
        thrown.expectMessage("Cannot add person to event. Person is null!");
        emptyEvent.addPerson(null, "some description");
    }

    /**
     * Tests if the addPerson method works. It should throw a DomainException if
     * the description is null.
     */
    @Test
    public void test_addPerson_with_description_throws_domain_exception_if_description_is_null() {
        thrown.expect(DomainException.class);
        thrown.expectMessage("Cannot add person to event. Description is null!");
        emptyEvent.addPerson(new Person(), null);
    }

    /**
     * Tests if the addPerson method works. It should add the event and the
     * description if correct values are entered.
     */
    @Test
    public void test_addPerson_with_description_is_added_if_correct_values_are_entered() {
        Person dries = new Person("Dries", "Janse", "DriesJ", new Date(47, 5, 5));
        emptyEvent.addPerson(dries, "organiser");
        assertTrue(emptyEvent.getEveryPersonWithLink().containsKey(dries));
        assertEquals("organiser", emptyEvent.getEveryPersonWithLink().get(dries));
    }

    /**
     * Tests if the addPerson method works. It should throw a DomainException if
     * the person is null.
     */
    @Test
    public void test_addPerson_without_description_throws_domain_exception_if_person_is_null() {
        thrown.expect(DomainException.class);
        thrown.expectMessage("Cannot add person to event. Person is null!");
        emptyEvent.addPerson(null);
    }

    /**
     * Tests if addPerson method works. It should add the event with an empty
     * description if correct person is entered.
     */
    @Test
    public void test_addPerson_without_description_is_added_if_correct_person_is_add() {
        Person thomas = new Person("Thomas", "Janse", "ThomasJ", new Date(47, 5, 5));
        emptyEvent.addPerson(thomas);
        assertTrue(emptyEvent.getEveryPersonWithLink().containsKey(thomas));
        assertEquals("", emptyEvent.getEveryPersonWithLink().get(thomas));
    }

    /**
     * Tests if the getEveryPerson gives all the person objects back that the
     * event contains.
     */
    @Test
    public void test_getEveryPerson_gets_all_the_person_objects_of_an_event() {
        Person thomas = new Person("Thomas", "Janse", "ThomasJ", new Date(47, 5, 5));
        Person dries = new Person("dries", "Janse", "DriesJ", new Date(67, 3, 1));
        Person marc = new Person("marc", "Janse", "MarcJ", new Date(57, 7, 8));
        HashSet personSet = new HashSet();
        personSet.add(thomas);
        personSet.add(dries);
        personSet.add(marc);
        Event e = new Event();
        e.addPerson(marc);
        e.addPerson(dries);
        e.addPerson(thomas);
        assertEquals(personSet, e.getEveryPerson());
    }

    /**
     * Tests if the getEveryPersonWithlink method gives all the person objects
     * and there link with the event.
     */
    @Test
    public void test_getEveryPersonWithLink_gives_all_the_person_objects_with_there_link_of_the_event() {
        Person thomas = new Person("Thomas", "Janse", "ThomasJ", new Date(47, 5, 5));
        Person dries = new Person("dries", "Janse", "DriesJ", new Date(67, 3, 1));
        Person marc = new Person("marc", "Janse", "MarcJ", new Date(57, 7, 8));
        HashMap<Person, String> persons = new HashMap<>();
        persons.put(thomas, "Organiser");
        persons.put(dries, "helper");
        persons.put(marc, "Guest");
        Event e = new Event();
        e.addPerson(thomas, "Organiser");
        e.addPerson(dries, "helper");
        e.addPerson(marc, "Guest");
        assertEquals(persons, e.getEveryPersonWithLink());
    }

    /**
     * Tests the removePerson method works, it throws a domainException if the
     * person object is null.
     */
    @Test
    public void test_removePerson_throws_domainException_if_the_person_object_is_null() {
        thrown.expect(DomainException.class);
        thrown.expectMessage("Person cannot be removed because, it is null.");
        emptyEvent.removePerson(null);
    }

    /**
     * Tests the removePerson method works, it removes the object if it exists.
     */
    @Test
    public void test_removePerson_it_removes_the_object_if_it_exists() {
        Person thomas = new Person("Thomas", "Janse", "ThomasJ", new Date(47, 5, 5));
        emptyEvent.addPerson(thomas);
        emptyEvent.removePerson(thomas);
        assertFalse(emptyEvent.getEveryPersonWithLink().containsKey(thomas));
    }

}
