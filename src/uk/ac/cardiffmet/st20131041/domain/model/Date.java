package uk.ac.cardiffmet.st20131041.domain.model;

/**
 * Custom implementation of the date class because of the deprecated functions.
 * With this implementation we can use custom error messages.
 *
 * @author Dries
 * @Version 1.0
 */
public class Date {

    private int year;
    private int day;
    private int month;

    /**
     * Parameterised constructor uses the private setters for validation.
     *
     * @param year
     * @param day
     * @param month
     */
    public Date(int year, int day, int month) {
        this.setYear(year);
        this.setDay(day);
        this.setMonth(month);
    }

    /**
     * Gets the year of the date.
     *
     * @return year
     */
    public int getYear() {
        return year;
    }

    /**
     * Sets the year of the date.
     *
     * @exception Throws DomainException if year is more than 2100 or less than
     * 1900
     * @param year of the date
     */
    private void setYear(int year) {
        if (year > 2100 || year < 1900) {
            throw new DomainException("Year is not valid, it must be between 2100 and 1900.");
        }
    }

    /**
     * Get the year of the date.
     *
     * @return day
     */
    public int getDay() {
        return day;
    }

    /**
     * Sets the day of the date.
     *
     * @exception Throws DomainException if they more than 31 or less than 0.
     * @param day
     */
    private void setDay(int day) {
        if (day < 1 || day > 31) {
            throw new DomainException("Day is not valid, must be between 1 and 31.");
        }
        this.day = day;
    }

    /**
     * Get the month of the year.
     *
     * @return month
     */
    public int getMonth() {
        return month;
    }

    /**
     * Set the month of the date.
     *
     * @param month
     */
    private void setMonth(int month) {
        if (month > 12 || month < 1) {
            throw new DomainException("Month is invalid, must be between 1 and 12.");
        }
        this.month = month;
    }

    /**
     * Custom hash code, made use of year, day and month.
     *
     * @return the hashcode
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.year;
        hash = 29 * hash + this.day;
        hash = 29 * hash + this.month;
        return hash;
    }

    /**
     * Custom equals method. Year, day and month must be all the same.
     *
     * @param obj
     * @return
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
        final Date other = (Date) obj;
        if (this.year != other.year) {
            return false;
        }
        if (this.day != other.day) {
            return false;
        }
        if (this.month != other.month) {
            return false;
        }
        return true;
    }

}
