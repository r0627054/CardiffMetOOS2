package uk.ac.cardiffmet.st20131041.domain.model;

import java.util.Objects;
/**
 * The Person class is used to store information (forename, surname, birthday) of a person.
 * A person can be created and standalone, but is eventually used to affiliate with an event.
 * 
 * @author Dries
 * @Version 1.0
 */
public class Person {

    private String forename;
    private String surname;
    private Date birthday;

    /**
     * Empty constructor used for creation of the object afterwards setters can
     * be used separately for validation.
     */
    public Person() {
    }

    /**
     * Parameterised constructor uses the forename, surname and a birthday object.
     * 
     * @param forename forename of the person
     * @param surname surname of the person
     * @param birthday birthday object of the person
     */
    public Person(String forename, String surname, Date birthday) {
        this.setForename(forename);
        this.setSurname(surname);
        this.setBirthday(birthday);
    }

    /**
     * Gets the forename of the person.
     * 
     * @return forename of the person
     */
    public String getForename() {
        return forename;
    }

    /**
     * Sets the forename of the person.
     * 
     * @exception Throws DomainException if the forename is null.
     * @param forename 
     */
    public void setForename(String forename) {
        if(forename == null){
            throw new DomainException("Forename of a person cannot be null.");
        }
        this.forename = forename;
    }

    /**
     * Gets the surname of the person.
     * 
     * @return surname of the person
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Sets the surname of the person.
     * 
     * @exception Throws DomainException if the surname is null.
     * @param surname surname of the person
     */
    public void setSurname(String surname) {
        if(surname == null){
            throw new DomainException("Surname of the person cannot be null.");
        }
        this.surname = surname;
    }

    /**
     * Gets the birthday of the person.
     * 
     * @return Birthday, date object
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * Sets the birthday (date object) of the person.
     * 
     * @exception Throws DomainException if the birthday object is null
     * @param birthday 
     */
    public void setBirthday(Date birthday) {
        if(birthday == null){
            throw new DomainException("Birthday of a person cannot be null.");
        }
        this.birthday = birthday;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.forename);
        hash = 79 * hash + Objects.hashCode(this.surname);
        hash = 79 * hash + Objects.hashCode(this.birthday);
        return hash;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (!Objects.equals(this.forename, other.forename)) {
            return false;
        }
        if (!Objects.equals(this.surname, other.surname)) {
            return false;
        }
        if (!Objects.equals(this.birthday, other.birthday)) {
            return false;
        }
        return true;
    }
}
