package uk.ac.cardiffmet.st20131041.domain.model;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 * A JUnit test class that tests all the methods for the Location class.
 *
 * @author Dries Janse
 * @version 1.0
 */
public class LocationTest {

    private Location emptyLocation;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    public LocationTest() {
        emptyLocation = new Location();
    }

    /**
     * Test the constructor with all the instance variables. All the variables
     * needs to be set.
     */
    @Test
    public void test_constructor_with_all_instance_variables_sets_all_the_variables() {
        Location l = new Location("Belgium", "CF3110", "City Rd", "55A");
        assertEquals("Belgium", l.getCountry());
        assertEquals("CF3110", l.getPostcode());
        assertEquals("City Rd", l.getStreetName());
        assertEquals("55A", l.getHouseNumber());
    }

    /**
     * Tests if an empty constructor, creates an empty object with null values.
     */
    @Test
    public void test_empty_constructor_creates_location_object_with_null_values() {
        Location l = new Location();
        assertEquals(null, l.getHouseNumber());
        assertEquals(null, l.getCountry());
        assertEquals(null, l.getPostcode());
        assertEquals(null, l.getStreetName());
    }

    /**
     * Tests if the setter for the country works. It should throw a
     * domainException if the country is set to null
     */
    @Test
    public void test_setCountry_throws_DomainException_if_the_country_is_null() {
        thrown.expect(DomainException.class);
        thrown.expectMessage("Country cannot be null.");
        emptyLocation.setCountry(null);
    }

    /**
     * Tests if the setter for the country works. It should throw a
     * domainException if the country is empty
     */
    @Test
    public void test_setCountry_throws_DomainException_if_the_country_is_empty() {
        thrown.expect(DomainException.class);
        thrown.expectMessage("Country cannot be empty.");
        emptyLocation.setCountry("");
    }

    /**
     * Tests if the setter for the country works. It should set a correct
     * country String of the location.
     */
    @Test
    public void test_setCountry_will_set_the_country_if_a_correct_string_is_entered() {
        emptyLocation.setCountry("Belgium");
        assertEquals("Belgium", emptyLocation.getCountry());
    }

    /**
     * Tests if the setter for the postcode works. It should throw a
     * domainException if the postcode is set to null
     */
    @Test
    public void test_setPostcode_throws_DomainException_if_the_postcode_is_null() {
        thrown.expect(DomainException.class);
        thrown.expectMessage("Postcode cannot be null.");
        emptyLocation.setPostcode(null);
    }

    /**
     * Tests if the setter for the postcode works. It should throw a
     * domainException if the postcode is empty
     */
    @Test
    public void test_setPostcode_throws_DomainException_if_the_postcode_is_empty() {
        thrown.expect(DomainException.class);
        thrown.expectMessage("Postcode cannot be empty.");
        emptyLocation.setPostcode("");
    }

    /**
     * Tests if the setter for the postcode works. It should set a correct
     * postcode String of the location.
     */
    @Test
    public void test_setPostcode_will_set_the_postcode_if_a_correct_string_is_entered() {
        emptyLocation.setPostcode("3130");
        assertEquals("3130", emptyLocation.getPostcode());
    }

    /**
     * Tests if the setter for the street name works. It should throw a
     * domainException if the street name is set to null
     */
    @Test
    public void test_setStreetName_throws_DomainException_if_the_street_name_is_null() {
        thrown.expect(DomainException.class);
        thrown.expectMessage("Name of the street cannot be null.");
        emptyLocation.setStreetName(null);
    }

    /**
     * Tests if the setter for the street name works. It should throw a
     * domainException if the street name is empty
     */
    @Test
    public void test_setStreetName_throws_DomainException_if_the_street_name_is_empty() {
        thrown.expect(DomainException.class);
        thrown.expectMessage("Name of the street cannot be empty.");
        emptyLocation.setStreetName("");
    }

    /**
     * Tests if the setter for the street name works. It should set a correct
     * street name String of the location.
     */
    @Test
    public void test_setStreetName_will_set_the_street_name_if_a_correct_string_is_entered() {
        emptyLocation.setStreetName("Brussels Rd");
        assertEquals("Brussels Rd", emptyLocation.getStreetName());
    }

    /**
     * Tests if the setter for the house number works. It should throw a
     * domainException if the house number is set to null
     */
    @Test
    public void test_setHouseNumber_throws_DomainException_if_the_house_number_is_null() {
        thrown.expect(DomainException.class);
        thrown.expectMessage("The number of the house cannot be null.");
        emptyLocation.setHouseNumber(null);
    }

    /**
     * Tests if the setter for the house number works. It should throw a
     * domainException if the house number is empty
     */
    @Test
    public void test_setHouseNumber_throws_DomainException_if_the_house_number_is_empty() {
        thrown.expect(DomainException.class);
        thrown.expectMessage("The number of the house cannot be empty.");
        emptyLocation.setHouseNumber("");
    }

    /**
     * Tests if the setter for the house number works. It should set a correct
     * house number String of the location.
     */
    @Test
    public void test_setHouseNumber_will_set_the_house_number_if_a_correct_string_is_entered() {
        emptyLocation.setHouseNumber("3A");
        assertEquals("3A", emptyLocation.getHouseNumber());
    }

}
