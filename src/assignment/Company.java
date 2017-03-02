/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Zheliang
 */
public class Company {
    private String name;
    private ArrayList<Vehicle> vehicles;
    
    public Company() {
        this("Not Set");
    }
    
    public Company(String name) {
        setName(name);
        setVehicles(new ArrayList<Vehicle>());
    }

    public Vehicle search(String registrationNumber) {
        for (Vehicle aVehicle: getVehicles()){
            if (aVehicle.getRegistrationNumber()
                    .equalsIgnoreCase(registrationNumber))
                return aVehicle;
        }
        return null;
    }
    
    public boolean add(Vehicle newVehicle){
        return getVehicles().add(newVehicle);
    }
    
    public boolean remove(Vehicle theVehicle){
        return getVehicles().remove(theVehicle);
    }
    
    public String allBookings(Vehicle theVehicle) {
        String allBookings = "";
        if (theVehicle.getBookings().size() > 0){
            ArrayList<Booking> copy = 
                    new ArrayList<Booking>(theVehicle.getBookings());
            Collections.sort(copy, new BookingDateComparator());
            for (Booking aBooking: copy){
                allBookings += aBooking.toString() +"\n";
            }
            allBookings += String.format("Vehicle %s has a usage cost of "
                    + "%.2f.\n", theVehicle.getRegistrationNumber(),
                    theVehicle.usageCost());
        } else {
            allBookings = "There are no bookings made for this vehicle.\n";
        }
        return allBookings;
    }
    
    public String allVehicles(){
        String allVehicles = "";
        if (getVehicles().size() > 0){
            for (Vehicle aVehicle: getVehicles()){
                double totalCost = 0;
                totalCost += aVehicle.usageCost();
                allVehicles += String.format("%s with %d bookings with grand "
                        + "total cost of RM%.2f.\n", aVehicle.toString(), 
                        aVehicle.getBookings().size(), totalCost);
            }
        } else {
            allVehicles = "There are no vehicles stored in the company.\n";
        }
        return allVehicles;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the vehicles
     */
    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    /**
     * @param vehicles the vehicles to set
     */
    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
