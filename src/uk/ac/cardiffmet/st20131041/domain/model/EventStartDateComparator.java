/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.cardiffmet.st20131041.domain.model;

import java.util.Comparator;

/**
 *
 * @author Dries Janse
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
