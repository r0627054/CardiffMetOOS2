package uk.ac.cardiffmet.st20131041.domain.db;

import java.util.ArrayList;
import java.util.Date;
import uk.ac.cardiffmet.st20131041.domain.model.Person;

/**
 * The PersonRepositoryInMemory class keeps track of all persons in an
 * ArrayList.
 *
 * @author Dries Janse
 * @version 1.0
 */
public class PersonRepositoryInMemory implements PersonRepository {

    /**
     * An in memory ArrayList of persons
     */
    private ArrayList<Person> persons;

    /**
     * The empty constructor initialises the person ArrayList. Load already
     * created persons, for demo purpose.
     */
    public PersonRepositoryInMemory() {
        this.persons = new ArrayList<Person>();
        this.addPerson(new Person("Harry", "Smith", "HarryS", new Date(87, 10, 19)));
        this.addPerson(new Person("Thomas", "Jones", "ThomasJ", new Date(77, 9, 9)));
        this.addPerson(new Person("Oliver", "Williams", "OliverW", new Date(60, 5, 5)));
        this.addPerson(new Person("Henry", "Brown", "HenryB", new Date(90, 5, 5)));
    }

    /**
     * Gets the ArrayList with all persons in it.
     *
     * @return ArrayList with all persons.
     */
    @Override
    public ArrayList<Person> getPersons() {
        return persons;
    }

    /**
     * Sets the ArrayList of all persons.
     *
     * Throws DatabaseException if ArrayList with persons is null.
     *
     * @param persons the ArrayList with Persons
     */
    @Override
    public void setPersons(ArrayList<Person> persons) {
        if (persons == null) {
            throw new DatabaseException("Cannot set persons ArrayList, if null!");
        }
        this.persons = persons;
    }

    /**
     * Adds a Person to the ArrayList with all the events.
     *
     * Throws DatabaseExecption if the Person object is null.
     *
     * @param person the person object that needs to be added.
     */
    @Override
    public void addPerson(Person person) {
        if (person == null) {
            throw new DatabaseException("Person cannot be null.");
        }
        if (persons.contains(person)) {
            throw new DatabaseException("Person already exists with this nickname!");
        }
        this.persons.add(person);
    }

    /**
     * Gets the Person object at the given index.
     *
     * @param index the index of the person object in the ArrayList.
     * @return the person object at the given index.
     */
    @Override
    public Person getPerson(int index) {
        return this.persons.get(index);
    }

    /**
     * Gets the person with the given nickname
     *
     * @param nickname the nickname of the person
     * @return the person object with the given nickname Throws a
     * DatabaseException if nickname is null
     */
    @Override
    public Person getPerson(String nickname) {
        if (nickname == null) {
            throw new DatabaseException("Nickname not found in the database.");
        }
        for (Person p : this.getPersons()) {
            if (p.getNickname().equals(nickname)) {
                return p;
            }
        }
        return null;
    }

    /**
     * Gets an an ArrayList of all the nicknames of all the users.
     *
     * @return an ArrayList of all the nicknames of all the users.
     */
    @Override
    public ArrayList<String> getAllNicknames() {
        ArrayList<String> nicknameArray = new ArrayList<>();
        for (Person p : this.getPersons()) {
            nicknameArray.add(p.getNickname());
        }
        return nicknameArray;
    }

    /**
     * Adds an ArrayList of Persons to the current ArrayList.
     *
     * @param personsList the ArrayListOfPersons that need to be added. Throws a
     * DatabaseException if personList is null.
     */
    @Override
    public void addPersons(ArrayList<Person> personsList) {
        if (personsList == null) {
            throw new DatabaseException("PersonsList cannot be null.");
        }
        this.getPersons().addAll(personsList);
    }
}
