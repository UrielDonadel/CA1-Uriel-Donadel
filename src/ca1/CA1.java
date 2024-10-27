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
        }
        
    }
    
}
