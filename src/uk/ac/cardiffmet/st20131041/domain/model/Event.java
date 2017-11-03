/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.cardiffmet.st20131041.domain.model;
import java.util.Date;
/**
 *
 * @author Dries
 */
public class Event {

    private String title;
    private String description;
    private Date date;

    public Event() {
    }

    public Event (String title, String desciption, Date date){
        
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return date;
    }

    public void setTitle(String title) {
        if(title == null){
            throw new DomainException("Event Title cannot be null!");
        }
        if(title.trim().isEmpty()){
            throw new DomainException("Event must have a title!");
        }
        this.title = title;
    }

    public void setDescription(String description) {
        if(description == null ){
            throw new DomainException("Event description cannot be null!");
        }
        this.description = description;
    }

    public void setDate(Date date) {
        if(date == null){
            throw new DomainException("Event date cannot be null!");
        }
        this.date = date;
    }    
}
