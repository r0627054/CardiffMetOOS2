/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.cardiffmet.st20131041.app;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Dries Janse
 */
public class Testje {

    public static void main(String[] args) {
        Calendar cal1 = new GregorianCalendar(2015,05,10);
        Date d1 = new Date(2020, 00, 04);
        Date d2 = new Date(2020, 00, 05);
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTimeInMillis(d1.getTime());
        System.out.println(cal.get(Calendar.YEAR));
        System.out.println(d1.getYear());
    }

}
