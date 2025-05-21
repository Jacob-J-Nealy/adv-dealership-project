package com.pluralsight.contract;

import com.pluralsight.Vehicle;

public abstract class Contract {

    // Contract Attributes
    public String  date;
    public String  name;
    public String  email;
    public Vehicle vehicle;


    // Contract Constructor
    public Contract(String date, String name, String email,
                    Vehicle vehicle, double totalPrice,
                    double monthlyPayment) {
        this.date = date;
        this.name = name;
        this.email = email;
        this.vehicle = vehicle;
    }

    // Contract Abstract toString
    public abstract String toString();

    // Contract Abstract Methods
    public abstract double getTotalPrice();

    public abstract double getMonthlyPayment();

    // Contract Getters & Setters
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
