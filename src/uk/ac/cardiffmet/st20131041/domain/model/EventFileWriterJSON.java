package uk.ac.cardiffmet.st20131041.domain.model;

import java.util.ArrayList;
import java.util.Map.Entry;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Dries Janse
 */
public class EventFileWriterJSON implements EventFileWriter{

    @Override
    public String writeEvents(ArrayList<Event> allEvents) {
        String result = "";
        JSONArray list = new JSONArray();
        
        for(Event e: allEvents){
            JSONObject eventObject = new JSONObject();
            eventObject.put("title", e.getTitle());
            eventObject.put("description", e.getDescription());
            eventObject.put("startDate", e.getStartDate().getTime());
            eventObject.put("endDate", e.getEndDate().getTime());
            
            
            //personsHashmap
            JSONArray personArray = new JSONArray();
            for(Entry<Person, String> entry : e.getEveryPersonWithLink().entrySet()) {
                JSONObject personObject = new JSONObject();
                personObject.put("forename", entry.getKey().getForename());
                personObject.put("surname", entry.getKey().getSurname());
                personObject.put("birthday", entry.getKey().getBirthday().getTime());
                personObject.put("nickname", entry.getKey().getNickname());
                JSONObject personLinkObject = new JSONObject();
                personLinkObject.put(personObject, entry.getValue());
                personArray.add(personLinkObject);
            }
            eventObject.put("persons", personArray);
            
            
            //Location object
            JSONObject locationObject = new JSONObject();
            locationObject.put("country", e.getLocation().getCountry());
            locationObject.put("postcode", e.getLocation().getPostcode());
            locationObject.put("streetName", e.getLocation().getStreetName());
            locationObject.put("houseNumber", e.getLocation().getHouseNumber());
            eventObject.put("location", locationObject);
            
            list.add(eventObject);
        }
        result = list.toJSONString();
        return result;
    }
    
}
