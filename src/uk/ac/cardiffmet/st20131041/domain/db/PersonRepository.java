package uk.ac.cardiffmet.st20131041.domain.db;

import java.util.ArrayList;
import uk.ac.cardiffmet.st20131041.domain.model.Person;

/**
 * The PersonRepository interface is used for all repositories of Person Objects.
 * For example this can be a database, an in memory ArrayList, for testing...
 * 
 * @author Dries Janse
 * @version 1.0
 */
public interface PersonRepository {
    ArrayList<Person> getPersons();
    void setPersons(ArrayList<Person> persons);
    void addPerson(Person person);
    Person getPerson(int index);
    Person getPerson(String nickname);
    ArrayList<String> getAllNicknames();
}
