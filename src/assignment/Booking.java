/*
 * NAME: TAN ZHELIANG
 * STUDENT ID: B1400653
 * DATE: 04/03/2017
 */
package assignment;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * This is a booking class which defines the booking object.
 * A vehicle object will have a collection of booking objects.
 * 
 * @author Zheliang
 */
public class Booking {
    /**
     * Variable that stores the name of the department in the company
     * A department can make bookings 
     */
    private String deptName;
    /**
     * Variable that stores the beginning date of a booking
     */
    private Date dateFrom;
    /**
     * Variable that stores the ending date of a booking
     */
    private Date dateTo;
    /**
     * The date format object which formats a string into a date with 
     * dd-MM-yyyy format.
     */
    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    /**
     * Creates a new booking with the department's name, the start date and 
     * end date
     * @param deptName  Department name
     * @param dateFrom  Start Date
     * @param dateTo    End Date
     */
    public Booking(String deptName, Date dateFrom, Date dateTo) {
        setDeptName(deptName);
        setDateFrom(dateFrom);
        setDateTo(dateTo);
    }
    /**
     * Method to return the department name
     * @return the deptName
     */
    public String getDeptName() {
        return deptName;
    }
    /**
     * Method to set the department name from deptName
     * @param deptName the name of the department
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
    /**
     * Method to return the start date of booking
     * @return the dateFrom
     */
    public Date getDateFrom() {
        return dateFrom;
    }
    /**
     * Method to set the start date from dateFrom
     * @param dateFrom the dateFrom to set
     */
    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }
    /**
     * Method to return the end date of booking
     * @return the dateTo
     */
    public Date getDateTo() {
        return dateTo;
    }
    /**
     * Method to set the end date from dateTo
     * @param dateTo the dateTo to set
     */
    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }
    /**
     * To string method to display the object instance in output
     * @return a string with information about the booking
     */
    public String toString() {
        return String.format("Booking made by %s department, from"
                + " %s to %s.", getDeptName(), sdf.format(getDateFrom()), 
                sdf.format(getDateTo()));
    }
    /**
     * Method to retrieve the number of days a booking
     * @return number of days of booking
     */
    public int getNumberOfDays() {
        long diff = (getDateTo().getTime() - getDateFrom().getTime());
        int noOfDays = (int) ((diff / (1000 * 60 * 60 * 24)) + 1);
        return noOfDays;
    }
    
    public boolean equalDate(Booking aBooking) {
        if (getDateFrom().equals(aBooking.getDateFrom()
        ) && getDateTo().equals(aBooking.getDateTo())){
            return true;
        } else {
            return false;
        }
    }
}
