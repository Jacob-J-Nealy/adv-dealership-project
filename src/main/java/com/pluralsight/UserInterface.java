package com.pluralsight;

import com.pluralsight.contract.Contract;
import com.pluralsight.contract.ContractDataManager;
import com.pluralsight.contract.LeaseContract;
import com.pluralsight.contract.SalesContract;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private Dealership dealership;
    private Scanner scanner;

    public UserInterface() {
        scanner = new Scanner(System.in);
    }

    public void display() {
        init();
        boolean quit = false;
        while (!quit) {
            System.out.println("---------- Menu ----------");
            System.out.println("1. Get vehicles by price");
            System.out.println("2. Get vehicles by make and model");
            System.out.println("3. Get vehicles by year");
            System.out.println("4. Get vehicles by color");
            System.out.println("5. Get vehicles by mileage");
            System.out.println("6. Get vehicles by type");
            System.out.println("7. Get all vehicles");
            System.out.println("8. Add vehicle");
            System.out.println("9. Remove vehicle");
            System.out.println("---------- Extra Options ----------");
            System.out.println("10. Buy/Lease Vehicle");
            System.out.println("99. Quit");

            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    processGetByPriceRequest();
                    break;
                case "2":
                    processGetByMakeModelRequest();
                    break;
                case "3":
                    processGetByYearRequest();
                    break;
                case "4":
                    processGetByColorRequest();
                    break;
                case "5":
                    processGetByMileageRequest();
                    break;
                case "6":
                    processGetByVehicleTypeRequest();
                    break;
                case "7":
                    processGetAllVehiclesRequest();
                    break;
                case "8":
                    processAddVehicleRequest();
                    break;
                case "9":
                    processRemoveVehicleRequest();
                    break;
                case "10":
                    processContract();
                    break;
                case "99":
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void processGetByPriceRequest() {
        System.out.print("Enter minimum price: ");
        double min = scanner.nextDouble();
        System.out.print("Enter maximum price: ");
        double max = scanner.nextDouble();
        List<Vehicle> vehicles = dealership.getVehiclesByPrice(min, max);
        displayVehicles(vehicles);
    }

    public void processGetByMakeModelRequest() {
        System.out.print("Enter make: ");
        String make = scanner.nextLine();
        System.out.print("Enter model: ");
        String model = scanner.nextLine();
        List<Vehicle> vehicles = dealership.getVehiclesByMakeModel(make, model);
        displayVehicles(vehicles);
    }

    public void processGetByYearRequest() {
        System.out.print("Enter minimum year: ");
        int min = scanner.nextInt();
        System.out.print("Enter maximum year: ");
        int max = scanner.nextInt();
        List<Vehicle> vehicles = dealership.getVehiclesByYear(min, max);
        displayVehicles(vehicles);
    }

    public void processGetByColorRequest() {
        System.out.print("Enter color: ");
        String color = scanner.nextLine();
        List<Vehicle> vehicles = dealership.getVehiclesByColor(color);
        displayVehicles(vehicles);
    }

    public void processGetByMileageRequest() {
        System.out.print("Enter minimum mileage: ");
        int min = scanner.nextInt();
        System.out.print("Enter maximum mileage: ");
        int max = scanner.nextInt();
        List<Vehicle> vehicles = dealership.getVehiclesByMileage(min, max);
        displayVehicles(vehicles);
    }

    public void processGetByVehicleTypeRequest() {
        System.out.print("Enter vehicle type: ");
        String vehicleType = scanner.nextLine();
        List<Vehicle> vehicles = dealership.getVehiclesByType(vehicleType);
        displayVehicles(vehicles);
    }

    public void processGetAllVehiclesRequest() {
        List<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);
    }

    public void processAddVehicleRequest() {
        System.out.print("Enter vehicle vin: ");
        int vin = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter vehicle make: ");
        String make = scanner.nextLine();

        System.out.print("Enter vehicle model: ");
        String model = scanner.nextLine();

        System.out.print("Enter vehicle year: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter vehicle price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter vehicle color: ");
        String color = scanner.nextLine();

        System.out.print("Enter vehicle mileage: ");
        int mileage = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter vehicle type (Car, Truck, SUV, Motorcycle): ");
        String type = scanner.nextLine();

        Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, mileage, price);

        dealership.addVehicle(vehicle);
        System.out.println("Vehicle added successfully!");
        DealershipFileManager manager = new DealershipFileManager();
        manager.saveDealership(dealership);
    }

    public void processRemoveVehicleRequest() {
        System.out.print("Enter the VIN of the vehicle you wish to remove: ");
        int vin = scanner.nextInt();

        boolean vehicleRemoved = false;
        for (Vehicle vehicle : dealership.getAllVehicles()) {
            if (vehicle.getVin() == vin) {
                dealership.removeVehicle(vehicle);
                System.out.println("Vehicle removed successfully!");
                vehicleRemoved = true;

                DealershipFileManager fileManager = new DealershipFileManager();
                fileManager.saveDealership(dealership);
                break;
            }
        }

        if (!vehicleRemoved) {
            System.out.println("Vehicle not found. Please try again.");
            return;
        }
    }

    public void processContract() {

        // Displays Vehicle Inventory for User
        System.out.println("Vehicle Inventory");
        System.out.println("________________________________________________________________________");
        for (Vehicle vehicles : dealership.getAllVehicles()) {
            System.out.println(vehicles);

        }

        // Saves Local Time for Contract
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String formattedDate = LocalDateTime.now().format(formatter);

        // Saves First and Last Name
        System.out.print("Please enter First & Last Name:  ");
        String name = scanner.nextLine();

        // Saves Email
        System.out.print("Please Enter your Email: ");
        String email = scanner.nextLine();

        // Matches VIN Number to Vehicle
        System.out.print("Please Enter VIN Number of  Selected Vehicle: ");
        int vin = scanner.nextInt();
        scanner.nextLine(); // scanner eater

        Vehicle selectedVehicle = null;


        for (Vehicle foundvehicle : dealership.getAllVehicles()) {
            if (foundvehicle.getVin() == vin) {
                System.out.println(foundvehicle);
                selectedVehicle = foundvehicle;
            }
        }

        if (selectedVehicle == null) {
            System.out.println("No vehicle with that VIN was found.");

            return;
        }

        System.out.println("\nWould you like to Buy or Lease a Vehicle?");
        System.out.println("B - Buy Vehicle");
        System.out.println("L - Lease Vehicle");
        String contractOption = scanner.nextLine();

        boolean isSaved = false;
        switch (contractOption.toUpperCase()) {
            case "B":
                System.out.println("Would you like to Finance your Vehicle? (Y/N)");
                String choice = scanner.nextLine();
                boolean wantsToFinance = choice.equalsIgnoreCase("Y");

                Contract salesContract = new SalesContract(formattedDate, name, email, selectedVehicle, wantsToFinance);
                ContractDataManager contractManager = new ContractDataManager();
                contractManager.saveContract(salesContract);
                isSaved = true;
                break;
            case "L":
                int currentYear = LocalDateTime.now().getYear();
                int age = currentYear - selectedVehicle.getYear();
                if (age > 3) {
                    System.err.println("Vehicle is too Old");
                    return;
                } else {

                    Contract leaseContract = new LeaseContract(formattedDate, name, email, selectedVehicle);
                    ContractDataManager leaseManager = new ContractDataManager();
                    leaseManager.saveContract(leaseContract);
                    isSaved = true;
                }
                break;

        }
        if (isSaved) {
            System.out.println("Successfully Saved");
        }

        boolean vehicleRemoved = false;
        for (Vehicle vehicle : dealership.getAllVehicles()) {
            if (vehicle.getVin() == vin) {
                dealership.removeVehicle(vehicle);
                System.out.println("Vehicle removed successfully!");
                vehicleRemoved = true;
                break;
            }
        }
        DealershipFileManager manager = new DealershipFileManager();
        manager.saveDealership(dealership);
    }

    private void init() {
            DealershipFileManager manager = new DealershipFileManager();
            dealership = manager.getDealership();
        }

        private void displayVehicles (List < Vehicle > vehicles) {
            for (Vehicle vehicle : vehicles) {
                System.out.println(vehicle.toString());
            }
        }

}