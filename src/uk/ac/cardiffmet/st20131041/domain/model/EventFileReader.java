package uk.ac.cardiffmet.st20131041.domain.model;

import java.io.File;
import java.util.ArrayList;

/**
 * Interface that species the method(s) to retrieve an ArrayList of all the
 * events of a file
 *
 * @author Dries Janse
 * @version 1.0
 */
public interface EventFileReader {

    /**
     * Reads a file and extracts all the events of this File. Exports the
     * readable events of the file to an ArrayList.
     *
     * @param file File that contains Events in a given format.
     * @return ArrayList of Events
     */
    ArrayList<Event> getAllEventsOfFile(File file);
}
