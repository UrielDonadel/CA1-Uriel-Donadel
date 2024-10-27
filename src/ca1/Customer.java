/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca1;

/**
 *
 * @author URIEL
 */
public class Customer {
    private String firstName;
    private String secondName;
    private double totalPurchase;
    private int customerClass;
    private int lastPurchaseYear;
    private double discountRate;
    private boolean isValid;

    public Customer(String firstName, String secondName, String totalPurchaseStr, String classStr, String lastPurchaseYearStr) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.isValid = validateData(totalPurchaseStr, classStr, lastPurchaseYearStr);
    }

    private boolean validateData(String totalPurchaseStr, String classStr, String lastPurchaseYearStr) {
        try {
            if (!firstName.matches("[A-Za-z]+") || !secondName.matches("[A-Za-z0-9]+")) return false;

            this.totalPurchase = Double.parseDouble(totalPurchaseStr);
            this.customerClass = Integer.parseInt(classStr);
            this.lastPurchaseYear = Integer.parseInt(lastPurchaseYearStr);

            return (customerClass >= 1 && customerClass <= 3) && (lastPurchaseYear > 1900 && lastPurchaseYear <= 2024);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isValid() {
        return isValid;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public double getTotalPurchase() {
        return totalPurchase;
    }

    public int getCustomerClass() {
        return customerClass;
    }

    public int getLastPurchaseYear() {
        return lastPurchaseYear;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }
}