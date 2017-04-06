/*
 * NAME: TAN ZHELIANG
 * STUDENT ID: B1400653
 * DATE: 06/04/2017
 */
package assignment;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 * Class that acts as a model for the vehicle table
 * @author Zheliang
 */
public class VehicleModel extends AbstractTableModel {
    /**
     * Variable to store the collection of vehicles
     */
    private ArrayList<Vehicle> vehicles;
    
    /**
     * Constructor which accepts a parameter vehicles
     * @param vehicles 
     */
    public VehicleModel(ArrayList<Vehicle> vehicles) {
        setVehicles(vehicles);
    }
    
    /**
     * Method to return the row count for the table
     * @return 
     */
    public int getRowCount() {
        return getVehicles().size();
    }
    
    /**
     * Method to return the column count for the table
     * @return 
     */
    public int getColumnCount() {
        return 5;
    }
    
    /**
     * Method to return the value of the table based on the column and row
     * @param rowIndex the selected row
     * @param columnIndex the selected column
     * @return the value based on the row and column
     */
    public Object getValueAt(int rowIndex, int columnIndex) {
        Vehicle v1 = getVehicle(rowIndex);
        switch (columnIndex) {
            case 0:
                return v1.getRegistrationNumber();
            case 1:
                if (v1 instanceof Car) {
                    return "Car";
                } else {
                    return "Van";
                }
            case 2:
                return v1.getMake();
            case 3:
                return v1.getModel();
            case 4:
                return String.format("RM%.2f",v1.usageCost());
            default:
                return "<some data>";
        }
    }
    
    /**
     * Method to return the column name for the vehicle table
     * @param columnIndex
     * @return column name based on columnIndex
     */
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Registration No.";
            case 1:
                return "Vehicle Type";
            case 2:
                return "Vehicle Make";
            case 3:
                return "Vehicle Model";
            case 4:
                return "Usage Cost";
            default:
                return "<column name>";
        }
    }
    
    /**
     * Method to add a vehicle to the model
     * @param v1 
     */
    public void addVehicle(Vehicle v1) {
        getVehicles().add(v1);
        updateTable();
    }
    
    /**
     * Method to remove vehicle from the model
     * @param v1 
     */
    public void removeVehicle(int v1) {
        getVehicles().remove(v1);
        updateTable();
    }
    
    /**
     * Method to get vehicle from model 
     * @param index
     * @return vehicle based on index
     */
    public Vehicle getVehicle(int index) {
        return getVehicles().get(index);
    }
    
    /**
     * Method to return collection of vehicles
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
    
    /**
     * Method to refresh the table
     */
    public void updateTable() {
        fireTableDataChanged();
    }
}
