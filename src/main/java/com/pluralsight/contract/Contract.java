package com.pluralsight.contract;

import com.pluralsight.Vehicle;

public abstract class Contract {

    // Attributes
    public String  date;
    public String  name;
    public String  email;
    public Vehicle vehicle;


    //Constructor
    public Contract(String date, String name, String email,
                    Vehicle vehicle, double totalPrice,
                    double monthlyPayment) {
        this.date = date;
        this.name = name;
        this.email = email;
        this.vehicle = vehicle;

    }


    // Abstract Methods
    public abstract double getTotalPrice();

    public abstract double getMonthlyPayment();
}
