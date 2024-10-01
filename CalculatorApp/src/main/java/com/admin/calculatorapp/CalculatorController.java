package com.admin.calculatorapp;

import java.util.ArrayList; // Import ArrayList for dynamic array usage
import java.util.List; // Import List interface
import javafx.event.ActionEvent; // Import ActionEvent for handling button actions
import javafx.fxml.FXML; // Import FXML annotation for JavaFX
import javafx.scene.control.TextField; // Import TextField for user input display

public class CalculatorController {

    @FXML
    TextField inputID; // TextField to display user input and results

    // List to store the numbers input by the user
    List<Double> inputNumbers = new ArrayList<>();

    // Variables to hold the current number being input and the current operation
    String currentNumber = "";
    String currentOperation = "";

    // Constants for number representation
    int zero = 0;
    int one = 1;
    int two = 2;
    int three = 3;
    int four = 4;
    int five = 5;
    int six = 6;
    int seven = 7;
    int eight = 8;
    int nine = 9;
    String comma = "."; // String for decimal point representation

    // Method to append a digit to the current number
    public void current(int number) {
        currentNumber += number; // Concatenate the digit to the current number
    }

    // Initialize method called when the controller is loaded
    public void initialize() {
        inputID.setEditable(false); // Make the TextField non-editable
    }

    // Button actions for each digit (0-9)
    public void btn_zero(ActionEvent e) { current(zero); inputID.appendText(String.valueOf(zero)); }
    public void btn_one(ActionEvent e) { current(one); inputID.appendText(String.valueOf(one)); }
    public void btn_two(ActionEvent e) { current(two); inputID.appendText(String.valueOf(two)); }
    public void btn_three(ActionEvent e) { current(three); inputID.appendText(String.valueOf(three)); }
    public void btn_four(ActionEvent e) { current(four); inputID.appendText(String.valueOf(four)); }
    public void btn_five(ActionEvent e) { current(five); inputID.appendText(String.valueOf(five)); }
    public void btn_six(ActionEvent e) { current(six); inputID.appendText(String.valueOf(six)); }
    public void btn_seven(ActionEvent e) { current(seven); inputID.appendText(String.valueOf(seven)); }
    public void btn_eight(ActionEvent e) { current(eight); inputID.appendText(String.valueOf(eight)); }
    public void btn_nine(ActionEvent e) { current(nine); inputID.appendText(String.valueOf(nine)); }

    // Handle decimal point button click
    public void btn_comma(ActionEvent e) {
        // Add a decimal point if it does not already exist in the current number
        if (!currentNumber.contains(".")) {
            currentNumber += ".";
        }
        inputID.appendText(comma); // Append decimal point to TextField
    }

    // Set the current operation (addition, subtraction, multiplication, division)
    public void setOperation(String operation) {
        currentOperation = operation; // Store the current operation
    }

    // Button actions for each arithmetic operation
    public void btn_Addition(ActionEvent e) {
        addCurrentNumberToList(); // Add current number to the list before setting operation
        setOperation("+"); // Set addition operation
    }

    public void btn_subtract(ActionEvent e) {
        addCurrentNumberToList(); // Add current number to the list
        setOperation("-"); // Set subtraction operation
    }

    public void btn_multiply(ActionEvent e) {
        addCurrentNumberToList(); // Add current number to the list
        setOperation("*"); // Set multiplication operation
    }

    public void btn_division(ActionEvent e) {
        addCurrentNumberToList(); // Add current number to the list
        setOperation("/"); // Set division operation
    }

    // Method to perform the selected operation on the input numbers
    public void btn_operation(ActionEvent e) {
        // Add the last entered number to the list
        if (!currentNumber.isEmpty()) {
            inputNumbers.add(Double.parseDouble(currentNumber));
            currentNumber = ""; // Clear current number after adding
        }

        // Start with the first number for calculations
        double result = inputNumbers.get(0);

        // Perform the operation based on the selected operation
        for (int i = 1; i < inputNumbers.size(); i++) {
            switch (currentOperation) {
                case "+" -> result += inputNumbers.get(i); // Addition
                case "-" -> result -= inputNumbers.get(i); // Subtraction
                case "*" -> result *= inputNumbers.get(i); // Multiplication
                case "/" -> result /= inputNumbers.get(i); // Division
            }
        }

        inputID.setText(String.valueOf(result)); // Display result in TextField
        inputNumbers.clear(); // Clear the list for new input
        inputNumbers.add(result); // Add the result back for potential further calculations
    }

    // Reset all inputs and outputs
    public void btn_reset(ActionEvent e) {
        inputID.clear(); // Clear the TextField
        inputNumbers.clear(); // Clear the input numbers list
        currentNumber = ""; // Reset the current number
        currentOperation = ""; // Reset the current operation
    }

    // Clear the current number being input
    public void btn_clear(ActionEvent e) {
        inputID.clear(); // Clear the TextField
        currentNumber = ""; // Reset the current number
    }

    // Helper method to add the current number to the list of input numbers
    private void addCurrentNumberToList() {
        if (!currentNumber.isEmpty()) {
            inputNumbers.add(Double.parseDouble(currentNumber)); // Parse and add to the list
            inputID.clear(); // Clear the input field
            currentNumber = ""; // Reset the current number
        }
    }
}

