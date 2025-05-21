package com.pluralsight.contract;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class ContractDataManager {

    private void saveContract(Contract contract) {

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("contract.csv"));

        } catch (Exception e) {
            System.err.println("Could Not Store Contract");
        }

    }
}
