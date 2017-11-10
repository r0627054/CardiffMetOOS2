package uk.ac.cardiffmet.st20131041.domain.db;

/**
 * The DatabaseException class is an unchecked runtime exception class. It is used in the
 * database classes, it gets thrown if invalid input is provided.
 *
 * @author Dries
 * @version 1.0
 */
public class DatabaseException extends RuntimeException{

    /**
     * Construct a new database exception with no detail message and no cause.
     */
    public DatabaseException() {
    }

    /**
     * Construct a new database exception with the given detail message and no cause.
     * 
     * @param message error message
     */
    public DatabaseException(String message) {
        super(message);
    }

    /**
     * Construct a new database exception with the given detail message and the given cause.
     * 
     * @param message the error message
     * @param cause the error cause
     */
    public DatabaseException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Construct a new database exception with the given cause and the default message.
     * 
     * @param cause the error cause
     */
    public DatabaseException(Throwable cause) {
        super(cause);
    }

}
