package uk.ac.cardiffmet.st20131041.domain.db;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * A JUnit test class that tests all the methods for the
 * EventRepositoryFactory class.
 *
 * @author Dries Janse
 * @version 1.0
 */
public class EventRepositoryFactoryTest {

    /**
     * Tests the getEventRepository method, it should return the
     * getEventRepository.
     */
    @Test
    public void test_getEventRepository_returns_an_instance_of_memory_with_the_correct_parameter() {
        EventRepository repo = EventRepositoryFactory.getEventRepository("MEMORY");
        assertTrue(repo instanceof EventRepositoryInMemory);
    }

    /**
     * Tests the getEvemtRepository method, it should return null if there is no
     * corresponding class.
     */
    @Test
    public void test_getEventRepository_returns_null_if_there_is_no_repository_class_for_the_parameter() {
        assertNull(EventRepositoryFactory.getEventRepository("NOT EXISTING"));
    }

}
