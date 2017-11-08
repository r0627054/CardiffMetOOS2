package uk.ac.cardiffmet.st20131041.domain.service;
import java.util.ArrayList;
import uk.ac.cardiffmet.st20131041.domain.model.DomainException;
import uk.ac.cardiffmet.st20131041.domain.model.Person;

/**
 *The PersonService class keeps track of all persons in an ArrayList.
 * 
 * @author Dries Janse
 * @Version 1.0
 */
public class PersonService {
    private ArrayList<Person> persons;

    /**
     * The empty constructor initialises the person ArrayList.
     */
    public PersonService() {
        this.persons = new ArrayList<Person>();
    }

    /**
     * Gets the ArrayList with all persons in it.
     * @return ArrayList with all persons.
     */
    public ArrayList<Person> getPersons() {
        return persons;
    }

    /**
     * Sets the ArrayList of all persons.
     * @exception Throws DomainException if ArrayList with persons is null.
     * @param persons the ArrayList with Persons
     */
    public void setPersons(ArrayList<Person> persons) {
        if(persons == null){
            throw new DomainException("Cannot set persons ArrayList, if null!");
        }
        this.persons = persons;
    }
    
    /**
     * Adds a Person to the ArrayList with all the events.
     * 
     * @exception Throws DomainExecption if the Person object is null.
     * @param person 
     */
    public void addPerson(Person person){
        if(person == null){
            throw new DomainException("Person cannot be null.");
        }
    }
    
    /**
     * Gets the Person object at the given index.
     * 
     * @param index the index of the person object in the ArrayList.
     * @return the person object at the given index.
     */
    public Person getPerson(int index){
        return this.persons.get(index);
    }
}
