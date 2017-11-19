package uk.ac.cardiffmet.st20131041.domain.model;

import java.io.File;
import java.util.ArrayList;

/**
 * Interface that species the method(s) to write an ArrayList of all the events
 * to a String.
 *
 * @author Dries Janse
 * @version 1.0
 */
public interface EventFileWriter {

    /**
     * Converts the data into a string of the correct format.
     * 
     * @param allEvents Event of which must be written to a String
     * @return a String that contains all given event data in the correct format. 
     */
    String writeEvents(ArrayList<Event> allEvents);
}
