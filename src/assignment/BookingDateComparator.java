/*
 * NAME: TAN ZHELIANG
 * STUDENT ID: B1400653
 * DATE: 04/03/2017
 */
package assignment;
import java.util.Comparator;
/**
 * A comparator class to perform comparisons between 2 booking objects
 * @author Zheliang
 */
public class BookingDateComparator implements Comparator<Booking> {
    /**
     * Overriding the compare method of the comparator class
     * @param lhs the object that is on the left on the comparison
     * @param rhs the object that is on the right on the comparison
     * @return an integer of either 0, 1 or -1. 0 means the objects 
     *         are equal, 1 means the left hand object comes after
     *         the right object, and -1 is the left hand object comes 
     *         before the right object.
     */
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
