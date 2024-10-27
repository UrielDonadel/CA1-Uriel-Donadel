/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca1;

/**
 * Customer class with validation and error messaging.
 */
public class Customer {
    private String firstName;
    private String secondName;
    private double totalPurchase;
    private int customerClass;
    private int lastPurchaseYear;
    private double discountRate;
    private boolean isValid;
    private String validationMessage;  // Armazena mensagens de erro de validação

    public Customer(String firstName, String secondName, String totalPurchaseStr, String classStr, String lastPurchaseYearStr) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.validationMessage = validateData(totalPurchaseStr, classStr, lastPurchaseYearStr);
        this.isValid = validationMessage == null;  // Define como válido apenas se não houver mensagens de erro
    }

    private String validateData(String totalPurchaseStr, String classStr, String lastPurchaseYearStr) {
        StringBuilder errors = new StringBuilder();

        // Validação do nome
        if (!firstName.matches("[A-Za-z]+")) {
            errors.append("Invalid first name (must contain only letters): ").append(firstName).append("\n");
        }

        if (!secondName.matches("[A-Za-z0-9]+")) {
            errors.append("Invalid second name (must contain only letters and numbers): ").append(secondName).append("\n");
        }

        // Validação do valor total da compra
        try {
            this.totalPurchase = Double.parseDouble(totalPurchaseStr);
        } catch (NumberFormatException e) {
            errors.append("Invalid total purchase amount (must be a decimal number): ").append(totalPurchaseStr).append("\n");
        }

        // Validação da classe
        try {
            this.customerClass = Integer.parseInt(classStr);
            if (customerClass < 1 || customerClass > 3) {
                errors.append("Invalid class (must be an integer between 1 and 3): ").append(classStr).append("\n");
            }
        } catch (NumberFormatException e) {
            errors.append("Invalid class (must be an integer between 1 and 3): ").append(classStr).append("\n");
        }

        // Validação do ano da última compra
        try {
            this.lastPurchaseYear = Integer.parseInt(lastPurchaseYearStr);
            if (lastPurchaseYear < 1900 || lastPurchaseYear > 2024) {
                errors.append("Invalid last purchase year (must be between 1900 and 2024): ").append(lastPurchaseYearStr).append("\n");
            }
        } catch (NumberFormatException e) {
            errors.append("Invalid last purchase year (must be a valid year): ").append(lastPurchaseYearStr).append("\n");
        }

        // Retorna null se não houver erros ou a mensagem de erro acumulada
        return errors.length() > 0 ? errors.toString() : null;
    }

    public boolean isValid() {
        return isValid;
    }

    public String getValidationMessage() {
        return validationMessage;
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
