/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Zheliang
 */
public class ResourceBookingConsole {
    static Scanner sc;
    static Company company1;
    static SimpleDateFormat sdf;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException{
        // TODO code application logic here
        sc = new Scanner(System.in);
        company1 = new Company("HELP Business Group");
        sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        int select;
        do {
            select = menu();
            switch (select) {
                case 1:
                    addVehicle();
                    break;
                case 2:
                    createBooking();
                    break;
                case 3:
                    deleteVehicle();
                    break;
                case 4:
                    updateVehicle();
                    break;
                case 5:
                    displayBooking();
                    break;
                case 6:
                    displayVehicle();
                    break;
                case 7:
                    deleteBooking();
                    break;
                case 8:
                    updateBooking();
                    break;
                case 9:
                    displayDeptBooking();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid Selection");
            }
        } while (select != 0);
        System.out.println("Exit");
    }
    
    public static void addVehicle() {
        System.out.println("---Adding Vehicle---");
        System.out.println("Enter the registration number:");
        String registrationNumber = sc.nextLine().toUpperCase();
        System.out.println("Enter the make of the vehicle:");
        String make = sc.nextLine();
        System.out.println("Enter the model of the vehicle:");
        String model = sc.nextLine();
        System.out.println("Would you like to add a <C>ar or <V>an?");
        String type = sc.nextLine();
        if (company1.search(registrationNumber) == null){
            if (type.equalsIgnoreCase("C")){
                company1.add(new Car(registrationNumber, make, model));
                System.out.println("Vehicle successfully added into system.\n");
            }
            else if (type.equalsIgnoreCase("V")){
                company1.add(new Van(registrationNumber, make, model));
                System.out.println("Vehicle successfully added into system.\n");
            }
            else {
                System.out.println("Type <C> for Car, <V> for Van");
                System.out.println("Vehicle is not added");
            }
        } else {
            System.out.println("Vehicle with registration number " +
                    registrationNumber + " already exists in the system.\n");
        }
    }
    
    public static void createBooking() throws ParseException {
        System.out.println("---Creating Booking---");
        System.out.println("Enter the registration number of the vehicle:");
        String registrationNumber = sc.nextLine().toUpperCase();
        Vehicle aVehicle = company1.search(registrationNumber);
        if (aVehicle != null){
            System.out.println(aVehicle);
            System.out.println("Enter the representing department:");
            String dept = sc.nextLine();
            System.out.println("Enter the starting date:");
            sdf.setLenient(false);
            String dateStr = sc.nextLine();
            Date dateFrom = sdf.parse(dateStr);
            System.out.println("Enter the ending date:");
            dateStr = sc.nextLine();
            Date dateTo = sdf.parse(dateStr);
            if (dateTo.compareTo(dateFrom) >= 0){
                if (aVehicle.getBookings().size() > 0){
                    if (!aVehicle.isOverlap(dateFrom, dateTo)){
                        aVehicle.add(new Booking(dept, dateFrom, dateTo));
                        System.out.println("Booking successfully added\n");
                    } else {
                        System.out.println("The booking is overlapping with "
                                + "another booking.\n");
                    }
                } else {
                    aVehicle.add(new Booking(dept, dateFrom, dateTo));
                    System.out.println("Booking successfully added\n");
                }
            } else {
                System.out.println("The end date must not be before the "
                        + "start date");
            }
        } else {
            System.out.println("This vehicle does not exist in the system.\n");
        }
    }
    
    public static void deleteVehicle() {
        System.out.println("---Deleting vehicle---");
        System.out.println("Enter the registration of the vehicle:");
        String registrationNumber = sc.nextLine().toUpperCase();
        Vehicle aVehicle = company1.search(registrationNumber);
        if (aVehicle != null){
            if (aVehicle.getBookings().size() > 0){
                System.out.println("There are " + aVehicle.getBookings().size()
                        + " bookings made for this vehicle, "
                        + "would you still like to delete? Y/N:");
                String decision = sc.nextLine();
                if (decision.equalsIgnoreCase("y")){
                    company1.remove(aVehicle);
                    System.out.println("Vehicle is deleted.\n");
                }
                else if (decision.equalsIgnoreCase("n")){
                    System.out.println("The vehicle is not deleted.\n");
                } else {
                    System.out.println("Please only enter Y or N.\n");
                }
            } else {
                company1.remove(aVehicle);
                System.out.println("Vehicle is deleted.\n");
            }
        } else {
            System.out.println("This vehicle does not exist in the system.\n");
        }        
    }
    
    public static void updateVehicle() {
        System.out.println("---Updating vehicle---");
        System.out.println("Enter the registration of the vehicle:");
        String registrationNumber = sc.nextLine().toUpperCase();
        Vehicle aVehicle = company1.search(registrationNumber);
        if (aVehicle != null){
            System.out.println("Enter new registration number:");
            String newRegNumber = sc.nextLine();
            aVehicle.setRegistrationNumber(newRegNumber);
            System.out.println("Enter new make of vehicle:");
            String newMake = sc.nextLine();
            aVehicle.setMake(newMake);
            System.out.println("Enter new model of vehicle:");
            String newModel = sc.nextLine();
            aVehicle.setModel(newModel);
            System.out.println("Vehicle details updated successfully.\n");
        } else{
            System.out.println("This vehicle does not exist in the system.\n");
        }
    }
    
    public static void displayBooking() {
        System.out.println("---Displaying Bookings of Vehicle---");
        System.out.println("Enter the registration of the vehicle:");
        String registrationNumber = sc.nextLine().toUpperCase();
        Vehicle aVehicle = company1.search(registrationNumber);
        if (aVehicle != null){
            System.out.println("List of all bookings:");
            System.out.println(aVehicle.allBookings());
        } else {
            System.out.println("This vehicle does not exist in the system.\n");
        }     
    }
    
    public static void displayVehicle() {
        System.out.println("---Displaying all vehicles details---");
        System.out.println(company1.allVehicles());
        System.out.println("");
        
    }
    
    public static void deleteBooking() throws ParseException {
        System.out.println("---Deleting Booking---");
        System.out.println("Enter the registration of the vehicle:");
        String registrationNumber = sc.nextLine().toUpperCase();
        Vehicle aVehicle = company1.search(registrationNumber);
        if (aVehicle != null){
            if (aVehicle.getBookings().size() > 0){
                System.out.println(aVehicle.allBookings());
                System.out.println("Enter the date of the booking to delete");
                System.out.println("The starting date: ");
                String dateStr = sc.nextLine();
                Date dateFrom = sdf.parse(dateStr);
                System.out.println("The ending date: ");
                dateStr = sc.nextLine();
                Date dateTo = sdf.parse(dateStr);
                Booking aBooking = aVehicle.search(dateFrom, dateTo);
                if (aBooking != null){
                    aVehicle.remove(aBooking);
                    System.out.println("The booking is deleted.");
                } else {
                    System.out.println("This booking does not exist.");
                }
            } else {
                System.out.println("This vehicle does not have any "
                        + "bookings made.\n");
            }
        } else {
            System.out.println("This vehicle does not exist in the system.\n");
        }
    }
    
    public static void updateBooking() {
        
    }
    
    public static void displayDeptBooking() {
        
    }
    
    public static int menu() {
        System.out.println("Vehicle booking system for " + company1.getName());
        System.out.println("");
        System.out.println("1. Add a vehicle");
        System.out.println("2. Create a booking");
        System.out.println("3. Delete a vehicle");
        System.out.println("4. Update vehicle information");
        System.out.println("5. Display all booking information");
        System.out.println("6. Display all vehicle information");
        System.out.println("7. Delete a booking");
        System.out.println("8. Update a booking");
        System.out.println("9. Display booking made by department");
        System.out.println("0. Exit");
        System.out.println("");
        System.out.print("Which option would you like to peform?: ");
        int select = sc.nextInt();
        sc.nextLine();
        System.out.println("");
        return select;
    }
    
}
