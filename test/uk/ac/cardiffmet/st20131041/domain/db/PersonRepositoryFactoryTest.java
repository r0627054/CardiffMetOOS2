package uk.ac.cardiffmet.st20131041.domain.db;


import org.junit.Test;
import static org.junit.Assert.*;

/**
 * A JUnit test class that tests all the methods for the
 * PersonRepositoryFactory class.
 *
 * @author Dries Janse
 * @version 1.0
 */
public class PersonRepositoryFactoryTest {
    

    /**
     * Tests the getPersonRepository method, it should return the
     * getPersontRepository.
     */
    @Test
    public void test_getPersonRepository_returns_an_instance_of_memory_with_the_correct_parameter() {
        PersonRepository repo =  PersonRepositoryFactory.getPersonRepository("MEMORY");
        assertTrue(repo instanceof PersonRepositoryInMemory);
    }

    /**
     * Tests the getPersonRepository method, it should return null if there is no
     * corresponding class.
     */
    @Test
    public void test_getPersonRepository_returns_null_if_there_is_no_repository_class_for_the_parameter() {
        assertNull(PersonRepositoryFactory.getPersonRepository("NOT EXISTING"));
    }
}
