/*
 * NAME: TAN ZHELIANG
 * STUDENT ID: B1400653
 * DATE: 04/03/2017
 */

package assignment;

/**
 * Car class which is inherited from the vehicle class
 * Car can have a collection of bookings
 * @author Zheliang
 */
public class Car extends Vehicle {
    /**
     * A no argument constructor which creates a car object with default values.
     * The values are Not Set for all fields
     */
    public Car() {
        super();
    }
    /**
     * A three argument constructor which creates a car object with the 
     * given parameters
     * @param registrationNumber    registration number of the car
     * @param make                  the make of the car
     * @param model                 model of the car
     */
    public Car(String registrationNumber, String make, String model) {
        super(registrationNumber, make, model);
    }
    
    /**
     * To string method to display the object instance in output
     * @return String with car information
     */
    public String toString() {
        return "Car with registation number: " + super.toString();
    }
    /**
     * Calculates the usage cost of the car based on the number of days of 
     * the booking.
     * @return The total cost of the booking made for the car object
     */
    /*
    Loops through every booking object in the car to calculate total usage 
    cost
    */
    public double usageCost() {
        double totalCost = 0;
        for (Booking aBooking: getBookings()) {
            long diff = (aBooking.getDateTo().getTime() 
                    - aBooking.getDateFrom().getTime());
            int noOfDays = (int) ((diff / (1000 * 60 * 60 * 24)) + 1);
            totalCost += noOfDays * 50;
        }
        return totalCost;
    }
}
