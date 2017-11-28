package uk.ac.cardiffmet.st20131041.domain.model;

import java.util.ArrayList;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * A JUnit test class that tests all the methods for the EventFileWriterJSON class.
 *
 * @author Dries Janse
 * @version 1.0
 */
public class EventFileWriterJSONTest {
    
    private EventFileWriter writer;
    
    public EventFileWriterJSONTest() {
        writer = new EventFileWriterJSON();
    }
    
    /**
     * Test the file writer if the output string is as expected.
     */
     @Test
     public void test_json_writer_will_give_the_correct_string_back_of_a_event_arraylist() {
         ArrayList<Event> events = new ArrayList();
         
        Event exampleEvent1 = new Event("Cardifferent Historic Pub Tour", "This historical walking, talking and drinking tour will take you on a journey celebrating the people of Wales and their stories within the setting of it's capital city Cardiff.", new Location("United Kingdom", "CF10 1 AY", "Duke Street", "14"), new Date(117, 00, 11), new Date(117, 00, 16));
        exampleEvent1.addPerson(new Person("Thomas", "Jones", "ThomasJ", new Date(77, 9, 9)), "Organiser");
        Event exampleEvent2 = new Event("Son of a Preacher Man", "Dates and information not yet released", new Location("United Kingdom", "CF24", "Queen St", "5"), new Date(120, 00, 02), new Date(120, 00, 06));
        exampleEvent2.addPerson(new Person("Henry", "Brown", "HenryB", new Date(90, 5, 5)), "Organiser");
        exampleEvent2.addPerson(new Person("Oliver", "Williams", "OliverW", new Date(60, 5, 5)), "Sales Coordinator");
        events.add(exampleEvent1);
        events.add(exampleEvent2);
        
        String solution = "[{\"persons\":[{\"person\":{\"birthday\":245199600000,\"forename\":\"Thomas\",\"surname\":\"Jones\",\"nickname\":\"ThomasJ\"},\"link\":\"Organiser\"}],\"endDate\":1484524800000,\"description\":\"This historical walking, talking and drinking tour will take you on a journey celebrating the people of Wales and their stories within the setting of it's capital city Cardiff.\",\"location\":{\"country\":\"United Kingdom\",\"streetName\":\"Duke Street\",\"postcode\":\"CF10 1 AY\",\"houseNumber\":\"14\"},\"title\":\"Cardifferent Historic Pub Tour\",\"startDate\":1484092800000},{\"persons\":[{\"person\":{\"birthday\":-302144400000,\"forename\":\"Oliver\",\"surname\":\"Williams\",\"nickname\":\"OliverW\"},\"link\":\"Sales Coordinator\"},{\"person\":{\"birthday\":644540400000,\"forename\":\"Henry\",\"surname\":\"Brown\",\"nickname\":\"HenryB\"},\"link\":\"Organiser\"}],\"endDate\":1578268800000,\"description\":\"Dates and information not yet released\",\"location\":{\"country\":\"United Kingdom\",\"streetName\":\"Queen St\",\"postcode\":\"CF24\",\"houseNumber\":\"5\"},\"title\":\"Son of a Preacher Man\",\"startDate\":1577923200000}]";
         assertEquals(solution, writer.writeEvents(events));
     }
}
