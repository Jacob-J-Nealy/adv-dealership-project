package com.pluralsight.contract;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class ContractDataManager {

    public void saveContract(Contract contract) {

        try {
            // Writes New Contracts to CSV File
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("contracts.csv", true));
            bufferedWriter.write(contract.toString());
            bufferedWriter.newLine();

            // Closes bufferedWriter
            bufferedWriter.flush();
            bufferedWriter.close();

        } catch (Exception e) {
            System.err.println("Could Not Store Contract");
        }
    }
}
