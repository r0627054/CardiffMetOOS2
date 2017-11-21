package uk.ac.cardiffmet.st20131041.domain.model;

/**
 * The location class keeps track of the address of a location.
 *
 * @author Dries Janse
 * @version 1.0
 */
public class Location {

    /**
     * Country of a location
     */
    private String country;

    /**
     * postcode of a location
     */
    private String postcode;

    /**
     * street name of a location
     */
    private String streetName;

    /**
     * house number/ bus number of location
     */
    private String houseNumber;

    /**
     * Empty constructor used for creation of the object afterwards setters can
     * be used separately for validation.
     */
    public Location() {
    }

    /**
     * Parameterised constructor used for object creation an assigned all values
     * at once.
     *
     * @param country country name of the location
     * @param postcode postcode of the location
     * @param streetName street name of the location
     * @param houseNumber house number of the location
     */
    public Location(String country, String postcode, String streetName, String houseNumber) {
        this.setCountry(country);
        this.setPostcode(postcode);
        this.setStreetName(streetName);
        this.setHouseNumber(houseNumber);
    }

    /**
     * Gets the name of the country.
     *
     * @return country name
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the name of the country.
     *
     * Throws DomainException if the country is null or empty.
     *
     * @param country name of the country
     */
    public void setCountry(String country) {
        if (country == null) {
            throw new DomainException("Country cannot be null.");
        }
        if (country.trim().isEmpty()) {
            throw new DomainException("Country cannot be empty.");
        }
        this.country = country;
    }

    /**
     * Gets the postcode of the location.
     *
     * @return the postcode
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * Sets the postcode of the location.
     *
     * Throws DomainException if the postcode is null or empty.
     *
     * @param postcode name of the postcode
     */
    public void setPostcode(String postcode) {
        if (postcode == null) {
            throw new DomainException("Postcode cannot be null.");
        }
        if (postcode.trim().isEmpty()) {
            throw new DomainException("Postcode cannot be empty.");
        }
        this.postcode = postcode;
    }

    /**
     * Gets the street name of the location.
     *
     * @return the street name
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * Sets the name of the street
     *
     * Throws DomainException if the name of the street is null or empty.
     *
     * @param streetName The street name of a location.
     */
    public void setStreetName(String streetName) {
        if (streetName == null) {
            throw new DomainException("Name of the street cannot be null.");
        }
        if (streetName.trim().isEmpty()) {
            throw new DomainException("Name of the street cannot be empty.");
        }
        this.streetName = streetName;
    }

    /**
     * Gets the number + box of the house.
     *
     * @return number + box of the house
     */
    public String getHouseNumber() {
        return houseNumber;
    }

    /**
     * Sets the number of the house.
     *
     * Throws DomainException if the number of the house is null or empty.
     *
     * @param houseNumber the house number (and post letter/number) of the
     * location
     */
    public void setHouseNumber(String houseNumber) {
        if (houseNumber == null) {
            throw new DomainException("The number of the house cannot be null.");
        }
        if (houseNumber.trim().isEmpty()) {
            throw new DomainException("The number of the house cannot be empty.");
        }
        this.houseNumber = houseNumber;
    }
}
