/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Zheliang
 */
public abstract class Vehicle {
    private String registrationNumber;
    private String make;
    private String model;
    private ArrayList<Booking> bookings;
    
    public Vehicle() {
        this("Not Set", "Not Set", "Not Set");
    }
    
    public Vehicle(String registationNumber, String make, String model) {
        setRegistrationNumber(registationNumber);
        setMake(make);
        setModel(model);
        setBookings(new ArrayList<Booking>());
    }
    
    public abstract double usageCost();

    /**
     * @return the registrationNumber
     */
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    /**
     * @param registrationNumber the registrationNumber to set
     */
    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    /**
     * @return the make
     */
    public String getMake() {
        return make;
    }

    /**
     * @param make the make to set
     */
    public void setMake(String make) {
        this.make = make;
    }

    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * @return the bookings
     */
    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    /**
     * @param bookings the bookings to set
     */
    public void setBookings(ArrayList<Booking> bookings) {
        this.bookings = bookings;
    }
    
    public boolean isOverlap(Date dateFrom, Date dateTo) {
        boolean overlap = true;
        for (Booking aBooking: getBookings()){
            if (dateFrom.before(aBooking.getDateFrom()) && 
                    dateTo.before(aBooking.getDateFrom()) ||
                    dateFrom.after(aBooking.getDateTo()) && 
                    dateTo.after(aBooking.getDateTo()) ){
                overlap = false;
            } else {
                return true;
            }
        }
        return overlap;
    }
    
    public boolean add(Booking newBooking){
        return getBookings().add(newBooking);
    }
    
    public String toString(){
        return getRegistrationNumber() +", Make: " + getMake() + 
                ", Model: "  + getModel();
    }
}