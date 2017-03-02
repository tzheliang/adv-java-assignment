/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.util.Comparator;

/**
 *
 * @author Zheliang
 */
public class BookingDateComparator implements Comparator<Booking> {
    public int compare(Booking lhs, Booking rhs) {
        int result;
        if (lhs.getDateFrom().compareTo(rhs.getDateFrom()) < 0 ){
            result = -1;
        } else if (lhs.getDateFrom().compareTo(rhs.getDateFrom()) > 0){
            result = 1;
        } else {
            result = 0;
        }
        if (result != 0)
            return result;
        
        if (lhs.getDateTo().compareTo(rhs.getDateTo()) < 0){
            result = -1;
        } else if (lhs.getDateTo().compareTo(rhs.getDateTo()) > 0){
            result = 1;
        } else {
            result = 0;
        }
        
        return result;
    }
}
