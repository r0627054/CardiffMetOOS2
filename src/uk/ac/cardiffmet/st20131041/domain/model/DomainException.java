package uk.ac.cardiffmet.st20131041.domain.model;

/**
 * The DomainException class is an unchecked runtime exception class. It is used in the
 * domain classes, it gets thrown if invalid input is provided.
 *
 * @author Dries
 * @version 1.0
 */
public class DomainException extends RuntimeException {

    /**
     * Construct a new domain exception with no detail message and no cause.
     */
    public DomainException() {
    }
    
    /**
     * Construct a new domain exception with the given detail message and no cause.
     * 
     * @param message error message
     */
    public DomainException(String message) {
        super(message);
    }

    /**
     * Construct a new domain exception with the given detail message and the given cause.
     * 
     * @param message the error message
     * @param cause the error cause
     */
    public DomainException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Construct a new domain exception with the given cause and the default message.
     * 
     * @param cause the error cause
     */
    public DomainException(Throwable cause) {
        super(cause);
    }

}
