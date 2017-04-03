/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Zheliang
 */
public class BookingModel extends AbstractTableModel {
    private ArrayList<Booking> bookings;
    
    public BookingModel(ArrayList<Booking> bookings) {
        setBookings(bookings);
    }
    
    public BookingModel() {
        setBookings(new ArrayList<>());
    }
    
    public int getRowCount() {
        return getBookings().size();
    }
    
    public int getColumnCount() {
        return 4;
    }
    
    public Object getValueAt(int rowIndex, int columnIndex) {
        Booking b1 = getBookings().get(rowIndex);
        switch (columnIndex) {
            case 0:
                return b1.getDeptName();
            case 1:
                return b1.getDateFrom();
            case 2:
                return b1.getDateTo();
            case 3:
                return b1.getNumberOfDays();
            default:
                return "<some data>";
        }
    }
    
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
     * @return the bookings
     */
    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    /**
     * @param bookings the bookings to set
     */
    public void setBookings(ArrayList<Booking> bookings) {
        this.bookings = bookings;
    }
    
    
}
