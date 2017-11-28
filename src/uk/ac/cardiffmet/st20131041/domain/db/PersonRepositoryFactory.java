package uk.ac.cardiffmet.st20131041.domain.db;

/**
 * PersonRepositoryFactory represents a factory for creating an
 * PersonRepository. For now it can only create an in memory PersonRepository.
 *
 * @author Dries Janse
 * @version 1.0
 */
public class PersonRepositoryFactory {

    /**
     * Depending of the type parameter, the method will give back an
     * PersonRepository of that type. If there is no similarity of the type, the
     * method will return null.
     *
     * @param type type of repository
     * @return PersonRepository object
     */
    public static PersonRepository getPersonRepository(String type) {
        switch (type) {
            case "MEMORY":
                return PersonRepositoryInMemory.getInstance();
            default:
                return null;
        }
    }
}
