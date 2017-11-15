package uk.ac.cardiffmet.st20131041.domain.model;

import java.util.Comparator;

/**
 * EventStartComparator is a custom comparator which sorts the event object ASC on their startdate.
 * 
 * @author Dries Janse
 * @version 1.0
 */
public class EventStartDateComparator implements Comparator<Event> {

    /**
     * {@inheritDoc }
     */
    @Override
    public int compare(Event o1, Event o2) {
        return o1.getStartDate().compareTo(o2.getStartDate());
    }

}
