package uk.ac.cardiffmet.st20131041.domain.db;

import java.util.ArrayList;
import uk.ac.cardiffmet.st20131041.domain.model.Person;

/**
 * The PersonRepository interface is used for all repositories of Person
 * Objects. For example this can be a database, an in memory ArrayList, for
 * testing...
 *
 * @author Dries Janse
 * @version 1.0
 */
public interface PersonRepository {

    /**
     * Gets the ArrayList with all persons in it.
     *
     * @return ArrayList with all persons.
     */
    ArrayList<Person> getPersons();

    /**
     * Sets the ArrayList of all persons.
     *
     * @param persons the ArrayList with Persons
     */
    void setPersons(ArrayList<Person> persons);

    /**
     * Adds a Person to the ArrayList with all the events.
     *
     * @param person the person object that needs to be added.
     */
    void addPerson(Person person);

    /**
     * Gets the Person object at the given index.
     *
     * @param index the index of the person object in the ArrayList.
     * @return the person object at the given index.
     */
    Person getPerson(int index);

    /**
     * Gets the person with the given nickname
     *
     * @param nickname the nickname of the person
     * @return the person object with the given nickname
     */
    Person getPerson(String nickname);

    /**
     * Gets the nicknames of all the persons
     *
     * @return an ArrayList of nicknames
     */
    ArrayList<String> getAllNicknames();

    /**
     * Adds an ArrayList of Persons to the repository.
     *
     * @param personsList the ArrayListOfPersons that need to be added.
     */
    void addPersons(ArrayList<Person> personsList);
}
