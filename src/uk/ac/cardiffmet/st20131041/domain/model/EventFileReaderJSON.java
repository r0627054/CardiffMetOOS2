package uk.ac.cardiffmet.st20131041.domain.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * 
 * 
 * @author Dries Janse
 * @version 1.0
 */
public class EventFileReaderJSON implements EventFileReader {

    @Override
    public ArrayList<Event> getAllEventsOfFile(File file) {
        JSONParser parser = new JSONParser();
        JSONArray eventArray = null;
        try {
            eventArray = (JSONArray) parser.parse(new FileReader(file));
        } catch (FileNotFoundException ex) {
            throw new DomainException("The file was not found!");
        } catch (IOException ex) {
            throw new DomainException(ex.getMessage());
        } catch (ParseException ex) {
            throw new DomainException("The JSON string file, contains errors. Please check the json string.");
        }
        try {
            for(int i=0; i<eventArray.size(); i++){
                JSONObject eventObject = (JSONObject) eventArray.get(i);
                Event event = new Event();
                event.setTitle((String) eventObject.get("title"));
                event.setDescription((String) eventObject.get("description"));
                
            }
        } catch (Exception e) {
            throw new DomainException("The JSON string file, contains errors. Please check the json string.");
        }
        //System.out.println(eventArray);
        
        ArrayList<Event> events = new ArrayList<>();
        return events;
    }

}
