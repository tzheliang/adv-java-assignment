/*
 * NAME: TAN ZHELIANG
 * STUDENT ID: B1400653
 * DATE: 04/03/2017
 */
package assignment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
/**
 * This is the vehicle class which defines the vehicles in the company.
 * This class is abstract and cannot be instantiated, with 2 subclasses
 * car and van
 * @author Zheliang
 */
public abstract class Vehicle implements java.io.Serializable {
    /**
     * Variable to store registrationNumber
     */
    private String registrationNumber;
    /**
     * Variable to store vehicle make
     */
    private String make;
    /**
     * Variable to store model
     */
    private String model;
    /**
     * Variable to store collection of bookings
     */
    private ArrayList<Booking> bookings;
    /**
     * No argument constructor for vehicle class to set default 
     * values Not Set
     */
    public Vehicle() {
        this("Not Set", "Not Set", "Not Set");
    }
    /**
     * Three argument constructor for vehicle class to construct 
     * vehicle object with three values
     * @param registationNumber the registration number of vehicle
     * @param make the make of the vehicle
     * @param model the model of the vehicle
     */
    public Vehicle(String registationNumber, String make, String model) {
        setRegistrationNumber(registationNumber);
        setMake(make);
        setModel(model);
        setBookings(new ArrayList<>());
    }
    /**
     * Abstract method of the usage cost for the car and van class 
     * to implement their own version of the usage cost
     * @return returns nothing as it is abstract
     */
    public abstract double usageCost();
    /**
     * Method to return the registration number of vehicle
     * @return the registrationNumber
     */
    public String getRegistrationNumber() {
        return registrationNumber;
    }
    /**
     * Method to set the registration number of vehicle
     * @param registrationNumber the registrationNumber to set
     */
    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
    /**
     * Method to return the make of the vehicle
     * @return the make of the vehicle
     */
    public String getMake() {
        return make;
    }
    /**
     * Method to set the make of the vehicle
     * @param make the make to set
     */
    public void setMake(String make) {
        this.make = make;
    }
    /**
     * Method to return the model of the vehicle
     * @return the model
     */
    public String getModel() {
        return model;
    }
    /**
     * Method to set the model of the vehicle 
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
    }
    /**
     * Method to return the collection of the bookings
     * @return the bookings
     */
    public ArrayList<Booking> getBookings() {
        return bookings;
    }
    /**
     * Method to set the collection of the bookings
     * @param bookings the bookings to set
     */
    public void setBookings(ArrayList<Booking> bookings) {
        this.bookings = bookings;
    }
    /**
     * Method that checks if two dates are overlapping with each other
     * @param dateFrom the dateFrom to be checked
     * @param dateTo the dateTo to be checked
     * @return a boolean indicating false if not overlap
     */
    public boolean isOverlap(Date dateFrom, Date dateTo) {
        // Default initialization set to true
        boolean overlap = true;
        // If there are no bookings return false
        if (getBookings().isEmpty()) {
            return false;
        }
        for (Booking aBooking: getBookings()){
            // Checks if the two dates are not within the range of dates
            if (dateFrom.before(aBooking.getDateFrom()) && 
                    dateTo.before(aBooking.getDateFrom()) ||
                    dateFrom.after(aBooking.getDateTo()) && 
                    dateTo.after(aBooking.getDateTo()) ){
                // Changes to false if it is available
                overlap = false;
            } else {
                // Immediately return true if the dates are in the range
                return true;
            }
        }
        return overlap;
    }
    /**
     * Method that checks if two dates are overlappnig with each other
     * @param b1 the booking that is updated
     * @param dateFrom the dateFrom
     * @param dateTo the dateTo
     * @return true if overlapping, false if not overlapping
     */
    public boolean updateIsOverlap(Booking b1, Date dateFrom, Date dateTo) {
        // Default initialization set to true
        boolean overlap = true;
        // Creates a temporary list to check for overlap
        ArrayList<Booking> temp = new ArrayList<Booking>(getBookings());
        // Removes the booking to be updated from the list
        temp.remove(b1);
        // If there are no bookings return false
        if (temp.isEmpty()) {
            return false;
        }
        for (Booking aBooking: temp){
            // Checks if the two dates are not within the range of dates
            if (dateFrom.before(aBooking.getDateFrom()) && 
                    dateTo.before(aBooking.getDateFrom()) ||
                    dateFrom.after(aBooking.getDateTo()) && 
                    dateTo.after(aBooking.getDateTo()) ){
                // Changes to false if it is available
                overlap = false;
            } else {
                // Immediately return true if the dates are in the range
                return true;
            }
        }
        return overlap;
    }
    /**
     * Method to add a new booking to the booking collection
     * @param newBooking the new booking object
     * @return true if booking addition is successful
     */
    public boolean add(Booking newBooking){
        return getBookings().add(newBooking);
    }
    /**
     * Method to remove booking from the booking collection
     * @param theBooking the booking object to be removed
     * @return true if the booking deletion is successful
     */
    public boolean remove(Booking theBooking){
        return getBookings().remove(theBooking);
    }
    /**
     * Method to search the collection of bookings in the vehicle according
     * to the dates given
     * @param dateFrom the start date of the booking
     * @param dateTo the end date of the booking
     * @return the booking object if found, null if not found
     */
    public Booking search(Date dateFrom, Date dateTo){
        for(Booking aBooking: getBookings()){
            if (aBooking.getDateFrom().equals(dateFrom) &&
                    aBooking.getDateTo().equals(dateTo)){
                return aBooking;
            }
        }
        return null;
    }
    /**
     * Method to search collection of bookings given the department 
     * name of the booking
     * @param dept the department name
     * @return an ArrayList of bookings containing the bookings with 
     * the same department name sorted according to date
     */
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
    /**
     * Method to return all the bookings in the list unsorted
     * @return a string containing all the booking objects information
     */
    public String allBookings() {
        String allBookings = "";
        
        for (Booking aBooking: getBookings()){
            allBookings += aBooking.toString() + "\n";
        }
        
        return allBookings;
    }
    /**
     * Method to return all the bookings in the list sorted by date 
     * with total cost
     * @return a string containing all the booking objects information 
     * sorted by date with grand total cost
     */
    public String sortedBookings() {
        String sortedBookings = "";
        if (getBookings().size() > 0){
            ArrayList<Booking> copy = 
                    new ArrayList<Booking>(getBookings());
            Collections.sort(copy, new BookingDateComparator());
            for (Booking aBooking: copy){
                sortedBookings += aBooking.toString() +"\n";
            }
            sortedBookings += String.format("Vehicle %s has a usage cost"
                    + " of RM%.2f.\n", getRegistrationNumber(),
                    usageCost());
        } else {
            sortedBookings = "There are no bookings made for this "
                    + "vehicle.\n";
        }
        return sortedBookings;
    }
    /**
     * Method to return a string with information of the vehicle class
     * @return a string with information of the vehicle class which 
     * details the registration number, make and model of the vehicle
     */
    public String toString(){
        return getRegistrationNumber() +", Make: " + getMake() + 
                ", Model: " + getModel();
    }
}
