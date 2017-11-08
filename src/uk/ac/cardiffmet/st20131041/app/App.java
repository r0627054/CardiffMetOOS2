package uk.ac.cardiffmet.st20131041.app;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Dries Janse
 */
public class App {
    
    public static void main(String[] args) {
        
        Date date = new Date(1990, 5, 4);
        Calendar c = Calendar.getInstance();
        c.set(1990, 5, 4);
        
        System.out.println(c.getTime());
        System.out.println("test");
    }
}
