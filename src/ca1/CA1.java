/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca1;

import java.util.List;

/**
 *
 * @author URIEL
 */
public class CA1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Load customer data from file
        List<String> customerData = FileHandler.LoadCustomerData ("customer.txt");
        
        //Process each customer
        for (int i = 0; i < customerData.size(); i += 4) {
            String firstName = customerData.get(1);
            String secondName = customerData.get(i + 1);
            String totalPurchaseStr = customerData.get(i + 2);
            String classStr = customerData.get (i + 3);
            String lastPurchaseYearStr = customerData.get (i + 4);
            
            //Create and validate customer
            Customer customer = new Customer(firstName, secondName, totalPurchaseStr, classStr, lastPurchaseYearStr);
            if (customer.isValid()) {
                //calculate final value with discount
                double finalValue = DiscountCalculator, calculateDiscountedValue(customer);
                
                //write result to output file
                FileHandler.writeToFile(customer, finalValue);
                
                //display result in console for verification
                System.out.println("%s %s - Final Value: %.2f, Discount Applied: %.0f%%%n", customer.getFirstName(), customer.getSecondName(), finalValue, customer.getDiscountRate() * 100);
            }
            else{
                //Show error message if any validation fails
                System.out.println("Invalid data format for customer starting with: " + customer.getFirstName());
            }
        }
            System.out.println("Processing complete. Discount calculated, saved, and displayed in console. ");
            }
        }
        
    }
    
}
