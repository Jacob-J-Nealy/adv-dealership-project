# 🏎️ Car Dealership CLI App

Welcome to my Car Dealership project — a Java-based command-line application. This app simulates a simple dealership system where vehicles can be listed, sold, or leased, and contracts are generated and saved.

---

## 💡 What This App Does
- Lists all vehicles available in inventory  
- Lets you search by VIN and initiate a sale or lease  
- Handles **SalesContracts** and **LeaseContracts** with correct pricing rules  
- Prevents leasing vehicles older than 3 years (no exceptions!)  
- Asks buyers if they want to finance — and calculates monthly payments accordingly  
- **Removes vehicles from inventory** once sold or leased  
- **Saves everything to file** using custom manager classes

---

## Core Features
- 📅 Grabs current date for each contract
- 🧑‍💼 Collects customer name and email
- 🚗 Validates VIN and finds the correct vehicle
- 💰 Applies business rules for:
  - Sales tax
  - Recording fees
  - Finance interest rates and loan terms
  - Lease ending value and lease fee
- 📝 Writes contracts to file via `ContractDataManager`
- 🧹 Removes sold/leased vehicle and saves the updated dealership with `DealershipFileManager`
---

## 🛠️ Technologies Used

- Java 17  
- IntelliJ IDEA  
- Command Line (no GUI!)  
- Plain ol’ text files for saving data  
- All contracts are saved with `.saveContract()` — like a boss

---

## ✍️ Final Thoughts
Special Thanks to Raymond (Potato Sensei OG) and Robot Potato Sensei with all of his corny jokes!

