/*
 * NAME: TAN ZHELIANG
 * STUDENT ID: B1400653
 * DATE: 04/03/2017
 */
package assignment;
import java.util.ArrayList;
/**
 * A company object which is the main object of this system
 * The company will have a collection of vehicles for booking
 * @author Zheliang
 */
public class Company {
    /**
     * The name of the company
     */
    private String name;
    /**
     * The array list which holds the collection of the vehicles
     */
    private ArrayList<Vehicle> vehicles;
    
    /**
     * No argument constructor which sets the company name to default value
     * Not Set.
     */
    public Company() {
        this("Not Set");
    }
    /**
     * Constructor which accepts one parameter name as company name
     * @param name 
     */
    public Company(String name) {
        setName(name);
        setVehicles(new ArrayList<>());
    }
    /**
     * Method to search collection of vehicles to retrieve the vehicle object
     * based on the registration number
     * @param registrationNumber    the registration number of vehicle
     * @return the vehicle object which matches the registration number,
     * returns null if not found
     */
    public Vehicle search(String registrationNumber) {
        for (Vehicle aVehicle: getVehicles()){
            if (aVehicle.getRegistrationNumber()
                    .equalsIgnoreCase(registrationNumber))
                return aVehicle;
        }
        return null;
    }
    /**
     * Method to add a vehicle into the collection of vehicles
     * @param newVehicle
     * @return the boolean value of the vehicle addition
     */
    public boolean add(Vehicle newVehicle){
        return getVehicles().add(newVehicle);
    }
    /**
     * Method to remove a vehicle from the collection of vehicles
     * @param theVehicle the vehicle object to be removed
     * @return the boolean value of the vehicle removal
     */
    public boolean remove(Vehicle theVehicle){
        return getVehicles().remove(theVehicle);
    }
    /**
     * Method to retrieve all the vehicles in the collection, with the bookings
     * information of how many bookings with the total usage cost
     * @return The string of the vehicle with booking information
     */
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
     * Method to retrieve list of bookings made by a department
     * @param dept the department name 
     * @return String with a list of bookings sorted by the date, for each 
     * vehicle with bookings made by a certain department
     */
    public String getBookingByDept(String dept){
        String bookingDetails = "";
        
        for (Vehicle aVehicle: getVehicles()){
            if (aVehicle.getBookings().size() > 0){
                //Retrieves a sorted list of bookings
                ArrayList<Booking> deptBookingsList = aVehicle.search(dept);
                if (deptBookingsList.size() > 0){
                    bookingDetails += String.format("\nBookings for %s "
                            + "department for %s.\n", dept, 
                            aVehicle.toString());
                    for (Booking aBooking: deptBookingsList){
                        bookingDetails += aBooking.toString() + "\n";
                    }
                }
            }
        }
        // Returns a statement if no bookings made by the department is found.
        if (bookingDetails.equals("")){
            bookingDetails = "No bookings found for " + dept + " department.\n";
            return bookingDetails;
        } else {
            return bookingDetails;
        }
    }
    /**
     * Method to return the name of the company
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Method to set the name of the company
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method to return the list of vehicles of the company
     * @return the vehicles
     */
    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    /**
     * Method to set the collection of vehicles
     * @param vehicles the vehicles to set
     */
    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
