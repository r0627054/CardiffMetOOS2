package uk.ac.cardiffmet.st20131041.domain.db;

/**
 * EventRepositoryFactory represents a factory for creating an eventRepository.
 * For now it can only create an in memory EventRepository.
 *
 * @author Dries Janse
 * @version 1.0
 */
public class EventRepositoryFactory {

    /**
     * Depending of the type parameter, the method will give back an
     * EventRepository of that type. If there is no similarity of the type, the
     * method will return null.
     *
     * @param type type of repository
     * @return EventRepository object
     */
    public static EventRepository getEventRepository(String type) {
        switch (type) {
            case "MEMORY":
                return EventRepositoryInMemory.getInstance();
            default:
                return null;
        }
    }
}
