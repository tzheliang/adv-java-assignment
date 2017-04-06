/*
 * NAME: TAN ZHELIANG
 * STUDENT ID: B1400653
 * DATE: 06/04/2017
 */
package assignment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 * Class that acts a the model for booking table
 * @author Zheliang
 */
public class BookingModel extends AbstractTableModel {
    /**
     * Variable to store the collection of bookings
     */
    private ArrayList<Booking> bookings;
    /**
     * Static object to format date into (dd/MM/yyyy) format
     */
    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    /**
     * Constructor which accepts a parameter bookings
     * @param bookings ArrayList of bookings
     */
    public BookingModel(ArrayList<Booking> bookings) {
        setBookings(bookings);
    }
    /**
     * Method to return the number of rows
     * @return number of rows based on the number of bookings
     */
    public int getRowCount() {
        return getBookings().size();
    }
    /**
     * Method to return number of columns
     * @return 4 
     */
    public int getColumnCount() {
        return 4;
    }
    /**
     * Method to return the value in each column of the row
     * @param rowIndex the selected row
     * @param columnIndex the selected column
     * @return value based on the column
     */
    public Object getValueAt(int rowIndex, int columnIndex) {
        Booking b1 = getBookings().get(rowIndex);
        switch (columnIndex) {
            case 0:
                return b1.getDeptName();
            case 1:
                return sdf.format(b1.getDateFrom());
            case 2:
                return sdf.format(b1.getDateTo());
            case 3:
                return b1.getNumberOfDays();
            default:
                return "<some data>";
        }
    }
    /**
     * Method to return the column name for the table
     * @param columnIndex the selected column
     * @return the column name based on the columnIndex
     */
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Booked By";
            case 1:
                return "Date From";
            case 2:
                return "Date To";
            case 3:
                return "No. Of Days";
            default:
                return "<column name>";
        }
    }
    /**
     * Method to add booking to the model
     * @param b1 the booking
     */
    public void addBooking(Booking b1) {
        getBookings().add(b1);
        updateTable();
    }
    /**
     * Method to remove booking from the model
     * @param rowSelected the booking row index
     */
    public void removeBooking(int rowSelected) {
        getBookings().remove(rowSelected);
        updateTable();
    }
    /**
     * Method to return the selected booking
     * @param index selected row index
     * @return the booking
     */
    public Booking getBooking(int index) {
        return getBookings().get(index);
        
    }
    /**
     * Method to return the collection of bookings
     * @return the bookings
     */
    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    /**
     * Method to set the collection of bookings
     * @param bookings the bookings to set
     */
    public void setBookings(ArrayList<Booking> bookings) {
        this.bookings = bookings;
    }
    /**
     * Method to refresh the table
     */
    public void updateTable() {
        fireTableDataChanged();
    }
}
