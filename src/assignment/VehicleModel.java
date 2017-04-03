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
public class VehicleModel extends AbstractTableModel {
    
    private ArrayList<Vehicle> vehicles;
    
    public VehicleModel(ArrayList<Vehicle> vehicle) {
        setVehicles(vehicle);
    }
    public int getRowCount() {
        return getVehicles().size();
    }

    public int getColumnCount() {
        return 5;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Vehicle v1 = getVehicles().get(rowIndex);
        switch (columnIndex) {
            case 0:
                return v1.getRegistrationNumber();
            case 1:
                if (v1 instanceof Car) {
                    return "Car";
                } else {
                    return "Vehicle";
                }
            case 2:
                return v1.getMake();
            case 3:
                return v1.getModel();
            case 4:
                return v1.usageCost();
            default:
                return "<some data>";
        }
    }
    
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
     * @return the vehicles
     */
    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    /**
     * @param vehicles the vehicles to set
     */
    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
