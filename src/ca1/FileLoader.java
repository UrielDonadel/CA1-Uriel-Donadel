/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author URIEL
 */
public class FileLoader {
    // Loads customer data from the specified file and returns a list of string
    public static List<String> loadCustomerData(String fileName) {
        List <String> customerData = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) ! = null) {
            customerData.add(line);
        }
            System.out.println("Customer data loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return customerData;
    }
    
}
