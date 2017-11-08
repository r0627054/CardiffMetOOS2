/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.cardiffmet.st20131041.app;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Dries
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
