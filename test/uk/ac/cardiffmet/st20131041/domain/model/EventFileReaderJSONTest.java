package uk.ac.cardiffmet.st20131041.domain.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * A JUnit test class that tests all the methods for the EventFileReaderJSON class.
 *
 * @author Dries Janse
 * @version 1.0
 */
public class EventFileReaderJSONTest {

    private File file;
    private EventFileReader reader;

    public EventFileReaderJSONTest() {
        reader = new EventFileReaderJSON();
    }

    @Before
    public void setUp() throws IOException {
        file = File.createTempFile("prefix", "json");
    }

    @After
    public void tearDown() {
        file.delete();
    }

    /**
     * 
     * @throws IOException 
     */
    @Test
    public void test_event_file_reader_json_it_gets_the_correct_events_of_a_json_file() throws IOException {
        //write example events to a temporary file
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        String events = "[{\"persons\":[{\"person\":{\"birthday\":245199600000,\"forename\":\"Thomas\",\"surname\":\"Jones\",\"nickname\":\"ThomasJ\"},\"link\":\"Organiser\"}],\"endDate\":1484524800000,\"description\":\"This historical walking, talking and drinking tour will take you on a journey celebrating the people of Wales and their stories within the setting of it's capital city Cardiff.\",\"location\":{\"country\":\"United Kingdom\",\"streetName\":\"Duke Street\",\"postcode\":\"CF10 1 AY\",\"houseNumber\":\"14\"},\"title\":\"Cardifferent Historic Pub Tour\",\"startDate\":1484092800000},{\"persons\":[{\"person\":{\"birthday\":-302144400000,\"forename\":\"Oliver\",\"surname\":\"Williams\",\"nickname\":\"OliverW\"},\"link\":\"Sales Coordinator\"},{\"person\":{\"birthday\":644540400000,\"forename\":\"Henry\",\"surname\":\"Brown\",\"nickname\":\"HenryB\"},\"link\":\"Organiser\"}],\"endDate\":1578268800000,\"description\":\"Dates and information not yet released\",\"location\":{\"country\":\"United Kingdom\",\"streetName\":\"Queen St\",\"postcode\":\"CF24\",\"houseNumber\":\"5\"},\"title\":\"Son of a Preacher Man\",\"startDate\":1577923200000}]";
        writer.write(events);
        writer.close();

        //The solution list
        ArrayList<Event> eventsList = new ArrayList();
        Event exampleEvent1 = new Event("Cardifferent Historic Pub Tour", "This historical walking, talking and drinking tour will take you on a journey celebrating the people of Wales and their stories within the setting of it's capital city Cardiff.", new Location("United Kingdom", "CF10 1 AY", "Duke Street", "14"), new Date(117, 00, 11), new Date(117, 00, 16));
        exampleEvent1.addPerson(new Person("Thomas", "Jones", "ThomasJ", new Date(77, 9, 9)), "Organiser");
        Event exampleEvent2 = new Event("Son of a Preacher Man", "Dates and information not yet released", new Location("United Kingdom", "CF24", "Queen St", "5"), new Date(120, 00, 02), new Date(120, 00, 06));
        exampleEvent2.addPerson(new Person("Henry", "Brown", "HenryB", new Date(90, 5, 5)), "Organiser");
        exampleEvent2.addPerson(new Person("Oliver", "Williams", "OliverW", new Date(60, 5, 5)), "Sales Coordinator");
        eventsList.add(exampleEvent1);
        eventsList.add(exampleEvent2);

        
        //the events found in the file
        ArrayList<Event> eventsFromFile = reader.getAllEventsOfFile(file);
        assertEquals(exampleEvent1.getTitle(), eventsFromFile.get(0).getTitle());
        assertEquals(exampleEvent2.getTitle(), eventsFromFile.get(1).getTitle());
        assertEquals(eventsList.size(), eventsFromFile.size());        
    }
}
