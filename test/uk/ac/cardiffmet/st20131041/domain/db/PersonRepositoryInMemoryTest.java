package uk.ac.cardiffmet.st20131041.domain.db;

import java.util.ArrayList;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import uk.ac.cardiffmet.st20131041.domain.model.Person;

/**
 * A JUnit test class that tests all the methods for the
 * PersonRepositoryInMemory class.
 *
 * @author Dries Janse
 * @version 1.0
 */
public class PersonRepositoryInMemoryTest {

    /**
     * Used for checking if the exception is thrown.
     */
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    /**
     * An object that can be tested
     */
    private PersonRepository repo = PersonRepositoryInMemory.getInstance();

    /**
     * Test the getPersons method. It has to return all the person in the in
     * memory database.
     */
    @Test
    public void test_getPersons_returns_all_the_persons_in_the_list() {
        this.resetInMemoryRepository();
        ArrayList<Person> allPersons = repo.getPersons();
        assertTrue(allPersons.contains(new Person("Harry", "Smith", "HarryS", new Date(87, 10, 19))));
        assertTrue(allPersons.contains(new Person("Thomas", "Jones", "ThomasJ", new Date(77, 9, 9))));
        assertTrue(allPersons.contains(new Person("Oliver", "Williams", "OliverW", new Date(60, 5, 5))));
        assertTrue(allPersons.contains(new Person("Henry", "Brown", "HenryB", new Date(90, 5, 5))));
    }

    /**
     * Test the setPersons method it should throw a database exception if the
     * parameter is null.
     */
    @Test
    public void test_setPersons_throws_databaseException_if_parameter_is_null() {
        thrown.expect(DatabaseException.class);
        thrown.expectMessage("Cannot set persons ArrayList, if null!");
        repo.setPersons(null);
    }

    /**
     * Test the addPerson method it should throw a database exception if the
     * parameter is null.
     */
    @Test
    public void test_addPerson_throws_databaseException_if_parameter_is_null() {
        thrown.expect(DatabaseException.class);
        thrown.expectMessage("Person cannot be null.");
        repo.addPerson(null);
    }

    /**
     * Test the addPerson method it should throw a database exception if the
     * parameter is null.
     */
    @Test
    public void test_addPerson_throws_databaseException_if_repository_already_contains_persons() {
        this.resetInMemoryRepository();
        thrown.expect(DatabaseException.class);
        thrown.expectMessage("Person already exists with this nickname!");
        repo.addPerson(new Person("Harry", "Smith", "HarryS", new Date(87, 10, 19)));
    }

    /**
     * Test the addPerson method it should add a valid person to the repository.
     */
    @Test
    public void test_addPerson_adds_a_valid_person_to_the_repository() {
        this.resetInMemoryRepository();
        repo.addPerson(new Person("Dries", "Janse", "DriesJ", new Date(17, 10, 19)));
        assertTrue(repo.getPersons().contains(new Person("Dries", "Janse", "DriesJ", new Date(17, 10, 19))));
    }

    /**
     * Test the getPerson method it should get the person at the given index.
     */
    @Test
    public void test_getPerson_returns_the_person_on_that_index_of_the_repository() {
        this.resetInMemoryRepository();
        assertEquals(new Person("Harry", "Smith", "HarryS", new Date(87, 10, 19)), repo.getPerson(0));
        assertEquals(new Person("Thomas", "Jones", "ThomasJ", new Date(77, 9, 9)), repo.getPerson(1));
        assertEquals(new Person("Oliver", "Williams", "OliverW", new Date(60, 5, 5)), repo.getPerson(2));
        assertEquals(new Person("Henry", "Brown", "HenryB", new Date(90, 5, 5)), repo.getPerson(3));
    }

    /**
     * Test the getPerson method it should get the person with the given
     * nickname.
     */
    @Test
    public void test_getPerson_returns_the_person_with_the_given_nickname() {
        this.resetInMemoryRepository();
        assertEquals(new Person("Harry", "Smith", "HarryS", new Date(87, 10, 19)), repo.getPerson("HarryS"));
        assertEquals(new Person("Thomas", "Jones", "ThomasJ", new Date(77, 9, 9)), repo.getPerson("ThomasJ"));
        assertEquals(new Person("Oliver", "Williams", "OliverW", new Date(60, 5, 5)), repo.getPerson("OliverW"));
        assertEquals(new Person("Henry", "Brown", "HenryB", new Date(90, 5, 5)), repo.getPerson("HenryB"));
    }

    /**
     * Test the getPerson method it should return null if person is not found.
     */
    @Test
    public void test_getPerson_returns_null_if_there_is_no_person_with_the_given_nickname() {
        this.resetInMemoryRepository();
        assertEquals(null, repo.getPerson("I don't exist"));
    }

    /**
     * Test the getPerson method it should throw a database exception if the
     * parameter is null.
     */
    @Test
    public void test_getPerson_throws_database_exceptiom_if_the_parameter_is_null() {
        thrown.expect(DatabaseException.class);
        thrown.expectMessage("Nickname not found in the database.");
        repo.getPerson(null);
    }

    /**
     * Test the getAllNicknames method. It returns all the nicknames of the
     * person objects.
     */
    @Test
    public void test_getAllNicknames_gives_an_ArrayList_of_all_the_nicknames_back() {
        this.resetInMemoryRepository();
        ArrayList<String> names = new ArrayList<>();
        names.add("HarryS");
        names.add("ThomasJ");
        names.add("OliverW");
        names.add("HenryB");
        assertEquals(names, repo.getAllNicknames());
    }

    /**
     * Test the addPersons method. It throws a DatabaseException if the
     * parameter is null.
     */
    @Test
    public void test_addPersons_throws_DatabaseException_if_the_parameter_is_null() {
        thrown.expect(DatabaseException.class);
        thrown.expectMessage("PersonsList cannot be null.");
        repo.addPersons(null);
    }

    /**
     * Test the addPersons method. It throws a DatabaseException if the
     * parameter is null.
     */
    @Test
    public void test_addPersons_adds_an_ArrayList_of_persons_to_the_repository() {
        this.resetInMemoryRepository();
        ArrayList<Person> allPersons = new ArrayList<>();
        allPersons.add(new Person("Dries", "Janse", "DriesJ", new Date(70, 4, 5)));
        allPersons.add(new Person("William", "Haff", "WillyH", new Date(90, 5, 5)));
        repo.addPersons(allPersons);
        assertTrue(repo.getPersons().contains(new Person("Dries", "Janse", "DriesJ", new Date(70, 4, 5))));
        assertTrue(repo.getPersons().contains(new Person("William", "Haff", "WillyH", new Date(90, 5, 5))));
    }

    /**
     * Resets and sets the in memory repository.
     */
    private void resetInMemoryRepository() {
        ArrayList<Person> allPersons = new ArrayList<Person>();
        allPersons.add(new Person("Harry", "Smith", "HarryS", new Date(87, 10, 19)));
        allPersons.add(new Person("Thomas", "Jones", "ThomasJ", new Date(77, 9, 9)));
        allPersons.add(new Person("Oliver", "Williams", "OliverW", new Date(60, 5, 5)));
        allPersons.add(new Person("Henry", "Brown", "HenryB", new Date(90, 5, 5)));
        repo.setPersons(allPersons);
    }

}
