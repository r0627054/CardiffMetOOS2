/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.cardiffmet.st20131041.app;

import java.util.Date;

/**
 *
 * @author Dries Janse
 */
public class Testje {
    public static void main(String[] args) {
      Date d1 =  new Date(2020, 00, 04);
      Date d2 =  new Date(2020, 00, 05);
      System.out.println(overlap(d1, d2));
    }
    
    private static boolean overlap(Date endEvent1, Date startEvent2){
        boolean overlap;
        if(endEvent1.after(startEvent2) || (!endEvent1.after(startEvent2)&& !endEvent1.before(startEvent2) )){
            overlap = true;
        }else{
            overlap = false;
        }
        return overlap;
    }
    
}
