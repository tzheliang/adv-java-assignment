/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

/**
 *
 * @author Zheliang
 */
public class Car extends Vehicle {
    
    public Car() {
        super();
    }
    public Car(String registrationNumber, String make, String model) {
        super(registrationNumber, make, model);
    }
    
    public String toString() {
        return "Car with registation number: " + super.toString();
    }
    
    public double usageCost() {
        double totalCost = 0;
        for (Booking aBooking: getBookings()) {
            long diff = aBooking.getDateTo().getTime() - aBooking.getDateFrom().getTime();
            int noOfDays = (int) ((diff / (1000 * 60 * 60 * 24)) + 1);
            totalCost += noOfDays * 50;
        }
        return totalCost;
    }
}
