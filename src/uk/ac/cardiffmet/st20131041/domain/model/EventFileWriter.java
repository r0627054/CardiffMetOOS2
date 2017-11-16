package uk.ac.cardiffmet.st20131041.domain.model;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * Interface that species the method(s) to write an ArrayList of all the events
 * to a file.
 *
 * @author Dries Janse
 * @version 1.0
 */
public interface EventFileWriter {

    String writeEvents(ArrayList<Event> allEvents);
}
