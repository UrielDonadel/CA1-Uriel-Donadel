/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca1;

import java.util.List;

/**
 * Main class to handle customer discount calculations.
 * GitHub Repository Link: 
 */
public class CA1 {

    public static void main(String[] args) {
        
        // Load customer data from file
        List<String> customerData = FileLoader.loadCustomerData("customer.txt");
        
        // Process each customer in blocks of 4 lines
        for (int i = 0; i + 3 < customerData.size(); i += 4) {  // Verifica se há pelo menos 4 linhas restantes
            String fullName = customerData.get(i);
            String totalPurchaseStr = customerData.get(i + 1);
            String classStr = customerData.get(i + 2);
            String lastPurchaseYearStr = customerData.get(i + 3);
            
            // Dividir o nome completo em primeiro e segundo nome
            String[] nameParts = fullName.split(" ", 2);  // Divide o nome completo em duas partes
            String firstName = nameParts[0];
            String secondName = nameParts.length > 1 ? nameParts[1] : "";  // Evita erro caso não haja segundo nome
            
            // Create and validate customer
            Customer customer = new Customer(firstName, secondName, totalPurchaseStr, classStr, lastPurchaseYearStr);
            if (customer.isValid()) {
                // Calculate final value with discount
                double finalValue = DiscountCalculator.calculateDiscountedValue(customer);
                
                // Write result to output file
                FileLoader.writeToFile(customer, finalValue);
                
                // Display result in console for verification
                System.out.printf("%s %s - Final Value: %.2f, Discount Applied: %.0f%%%n",
                                  customer.getFirstName(), customer.getSecondName(), finalValue, customer.getDiscountRate() * 100);
            } else {
                // Show error message if any validation fails
                System.out.println("Invalid data format for customer starting with: " + customer.getFirstName());
            }
        }
        
        System.out.println("Processing complete. Discounts calculated, saved, and displayed in console.");
    }
}

