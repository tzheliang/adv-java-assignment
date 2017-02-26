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
public class Van extends Vehicle{
    
    public Van() {
        super();
    }
    
    public Van(String registrationNumber, String make, String model){
        super(registrationNumber, make, model);
    }
    
    public String toString() {
        return "Van with registration number: " + super.toString();
    }
    
    public double usageCost() {
        double totalCost = 0;
        for (Booking aBooking: getBookings()){
            long diff = aBooking.getDateTo().getTime() - aBooking.getDateFrom().getTime();
            int noOfDays = (int) ((diff / (1000 * 60 * 60 * 24)) + 1);
            if (noOfDays < 5){
                totalCost += 100 * noOfDays;
            } else {
                totalCost += (5 * 100) + ((noOfDays - 5) * 100 * 1.2);
            }
        }
        return totalCost;
    }
}
