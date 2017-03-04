/*
 * NAME: TAN ZHELIANG
 * STUDENT ID: B1400653
 * DATE: 04/03/2017
 */

package assignment;

/**
 * Van class which is inherited from the vehicle class
 * Van can have a collection of bookings
 * @author Zheliang
 */
public class Van extends Vehicle{
    /**
     * A no argument constructor which creates a van object with default values.
     * The values are Not Set for all fields
     */
    public Van() {
        super();
    }
    /**
     * A three argument constructor which creates a van object with the 
     * given parameters
     * @param registrationNumber    registration number of the van
     * @param make                  the make of the van
     * @param model                 model of the van
     */
    public Van(String registrationNumber, String make, String model){
        super(registrationNumber, make, model);
    }
    /**
     To string method to display the object instance in output
     * @return String with van information
     */
    public String toString() {
        return "Van with registration number: " + super.toString();
    }
    /**
     *     /**
     * Calculates the usage cost of the van based on the number of days of 
     * the booking.
     * @return The total cost of the booking made for the van object
     *
     * @return 
     */
    /*
     * Loops through every booking object in the van to calculate total usage 
     * cost
     */
    public double usageCost() {
        double totalCost = 0;
        for (Booking aBooking: getBookings()){
            long diff = (aBooking.getDateTo().getTime() 
                    - aBooking.getDateFrom().getTime());
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
