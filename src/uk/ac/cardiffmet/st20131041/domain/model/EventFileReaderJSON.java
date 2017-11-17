package uk.ac.cardiffmet.st20131041.domain.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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
        ArrayList<Event> events = new ArrayList<>();
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
                //set startDate
                Date startDate = new Date( (long) eventObject.get("startDate"));
                event.setStartDate(startDate);
                
                //set endDate
                Date endDate = new Date( (long) eventObject.get("endDate"));
                event.setEndDate(endDate);
                
                
                JSONArray persons = (JSONArray) eventObject.get("persons");
                for(int j = 0; j < persons.size(); j++){
                 //link object with person and their link
                 JSONObject personlinkObject = (JSONObject) persons.get(j);
                 //person JSON object
                 JSONObject personJSONObject = (JSONObject) personlinkObject.get("person");
                 
                 //creating a person object
                 Person person = new Person();
                 person.setForename((String) personJSONObject.get("forename"));
                 person.setSurname((String) personJSONObject.get("surname"));
                 Date birthday = new Date((long) personJSONObject.get("birthday"));
                 person.setBirthday(birthday);
                 person.setNickname((String) personJSONObject.get("nickname"));

                 //get the link with that person
                 String linkWithPerson = (String) personlinkObject.get("link");
                 
                 //add person to event
                 event.addPerson(person, linkWithPerson);
                }
                
                //get the information of the location
                JSONObject locationObject = (JSONObject) eventObject.get("location");
                Location location = new Location();
                
                location.setCountry((String) locationObject.get("country"));
                location.setPostcode((String) locationObject.get("postcode"));
                location.setStreetName((String) locationObject.get("streetName"));
                location.setHouseNumber((String) locationObject.get("houseNumber"));
                event.setLocation(location);
                events.add(event);
            }
            
        } catch (DomainException e) {
            throw new DomainException("The JSON string file, contains errors. The JSON data has duplicate/ invalid events");
        } catch (Exception e1) {
            throw new DomainException("The JSON string file contains errors, there is an mistake in the String.");
        }
        //System.out.println(eventArray);
        
        
        return events;
    }

}
