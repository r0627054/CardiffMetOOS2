package uk.ac.cardiffmet.st20131041.domain.model;

import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 * A JUnit test class that tests all the methods for the Person class.
 *
 * @author Dries Janse
 * @version 1.0
 */
public class PersonTest {

    Person emptyPerson;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    public PersonTest() {
        emptyPerson = new Person();
    }

    /**
     * Test the constructor with all the instance variables. All the variables
     * needs to be set.
     */
    @Test
    public void test_constructor_with_all_instance_variables_sets_all_the_variables() {
        Person p = new Person("Dries", "Janse", "DriesJ", new Date(45, 3, 2));
        assertEquals("Dries", p.getForename());
        assertEquals("Janse", p.getSurname());
        assertEquals("DriesJ", p.getNickname());
        assertEquals(new Date(45, 3, 2), p.getBirthday());
    }

    /**
     * Tests if an empty constructor, creates an empty object with null values.
     */
    @Test
    public void test_empty_constructor_creates_location_object_with_null_values() {
        Person p = new Person();
        assertEquals(null, p.getBirthday());
        assertEquals(null, p.getForename());
        assertEquals(null, p.getSurname());
        assertEquals(null, p.getNickname());
    }

    /**
     * Tests if the setter for the forename works. It should throw a
     * domainException if the forename is set to null
     */
    @Test
    public void test_setForename_throws_DomainException_if_the_forename_is_null() {
        thrown.expect(DomainException.class);
        thrown.expectMessage("Forename of a person cannot be null.");
        emptyPerson.setForename(null);
    }

    /**
     * Tests if the setter for the forename works. It should throw a
     * domainException if the forename is empty
     */
    @Test
    public void test_setForename_throws_DomainException_if_the_forename_is_empty() {
        thrown.expect(DomainException.class);
        thrown.expectMessage("Forename of person cannot be empty.");
        emptyPerson.setForename("");
    }

    /**
     * Tests if the setter for the forename works. It should set a correct
     * forename String of the Person.
     */
    @Test
    public void test_setForename_will_set_the_forename_if_a_correct_string_is_entered() {
        emptyPerson.setForename("Dries");
        assertEquals("Dries", emptyPerson.getForename());
    }

    /**
     * Tests if the setter for the surname works. It should throw a
     * domainException if the surname is set to null
     */
    @Test
    public void test_setSurname_throws_DomainException_if_the_surname_is_null() {
        thrown.expect(DomainException.class);
        thrown.expectMessage("Surname of the person cannot be null.");
        emptyPerson.setSurname(null);
    }

    /**
     * Tests if the setter for the surname works. It should throw a
     * domainException if the surname is empty
     */
    @Test
    public void test_setSurname_throws_DomainException_if_the_surname_is_empty() {
        thrown.expect(DomainException.class);
        thrown.expectMessage("Surname of person cannot be empty.");
        emptyPerson.setSurname("");
    }

    /**
     * Tests if the setter for the surname works. It should set a correct
     * surname String of the Person.
     */
    @Test
    public void test_setSurname_will_set_the_surname_if_a_correct_string_is_entered() {
        emptyPerson.setSurname("Janse");
        assertEquals("Janse", emptyPerson.getSurname());
    }

    /**
     * Tests if the setter for the nickname works. It should throw a
     * domainException if the nickname is set to null
     */
    @Test
    public void test_setNickname_throws_DomainException_if_the_nickname_is_null() {
        thrown.expect(DomainException.class);
        thrown.expectMessage("Nickname of a person cannot be null.");
        emptyPerson.setNickname(null);
    }

    /**
     * Tests if the setter for the nickname works. It should throw a
     * domainException if the nickname is empty
     */
    @Test
    public void test_setNickname_throws_DomainException_if_the_nickname_is_empty() {
        thrown.expect(DomainException.class);
        thrown.expectMessage("Nickname of a person cannot be empty.");
        emptyPerson.setNickname("");
    }

    /**
     * Tests if the setter for the nickname works. It should set a correct
     * nickname String of the person.
     */
    @Test
    public void test_setNickname_will_set_the_nickname_if_a_correct_string_is_entered() {
        emptyPerson.setNickname("Drekke");
        assertEquals("Drekke", emptyPerson.getNickname());
    }

    /**
     * Tests if the setter for the birthday works. It should throw a
     * domainException if the birthday is set to null
     */
    @Test
    public void test_setBirthday_throws_DomainException_if_the_date_is_null() {
        thrown.expect(DomainException.class);
        thrown.expectMessage("Please enter a valid birthday.");
        emptyPerson.setBirthday(null);
    }

    /**
     * Tests if the setter for the nickname works. It should set a correct
     * birthday Date of the person.
     */
    @Test
    public void test_setBirthday_will_set_the_birthday_if_a_correct_date_is_entered() {
        Date d = new Date(45, 3, 3);
        emptyPerson.setBirthday(d);
        assertEquals(d, emptyPerson.getBirthday());
    }

}
