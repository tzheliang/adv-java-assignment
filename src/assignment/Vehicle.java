/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.util.ArrayList;
import java.util.Collections;
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
        setBookings(new ArrayList<>());
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
    
    public boolean remove(Booking theBooking){
        return getBookings().remove(theBooking);
    }
    
    public Booking search(Date dateFrom, Date dateTo){
        for(Booking aBooking: getBookings()){
            if (aBooking.getDateFrom().equals(dateFrom) &&
                    aBooking.getDateTo().equals(dateTo)){
                return aBooking;
            }
        }
        return null;
    }
    
    public ArrayList<Booking> search(String dept){
        ArrayList<Booking> deptBookings = new ArrayList<>();
        for(Booking aBooking: getBookings()){
                if (aBooking.getDeptName().equalsIgnoreCase(dept)){
                    deptBookings.add(aBooking);
            }
        }
        
        Collections.sort(deptBookings, new BookingDateComparator());
        
        return deptBookings;
    }
    
    public String allBookings() {
        String allBookings = "";
        
        for (Booking aBooking: getBookings()){
            allBookings += aBooking.toString() + "\n";
        }
        
        return allBookings;
    }
    
    public String sortedBookings() {
        String sortedBookings = "";
        if (getBookings().size() > 0){
            ArrayList<Booking> copy = 
                    new ArrayList<Booking>(getBookings());
            Collections.sort(copy, new BookingDateComparator());
            for (Booking aBooking: copy){
                sortedBookings += aBooking.toString() +"\n";
            }
            sortedBookings += String.format("Vehicle %s has a usage cost of "
                    + "RM%.2f.\n", getRegistrationNumber(),
                    usageCost());
        } else {
            sortedBookings = "There are no bookings made for this vehicle.\n";
        }
        return sortedBookings;
    }
    
    public String toString(){
        return getRegistrationNumber() +", Make: " + getMake() + 
                ", Model: "  + getModel();
    }
}
