package com.admin.calculatorapp;

import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CalculatorController {

    @FXML
    TextField inputID;

    List<Double> inputNumbers = new ArrayList<>();

    String currentNumber = "";
    String currentOperation = "";

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
    String comma = ".";

    public void current(int number) {
        currentNumber += number;
    }

    public void initialize() {
        inputID.setEditable(false);
    }

    public void btn_zero(ActionEvent e) {current(zero); inputID.appendText(String.valueOf(zero));}

    public void btn_one(ActionEvent e) {current(one);inputID.appendText(String.valueOf(one));}
    
    public void btn_two(ActionEvent e) {current(two); inputID.appendText(String.valueOf(two));}
      
    public void btn_three(ActionEvent e) {current(three); inputID.appendText(String.valueOf(three)); }
       
    public void btn_four(ActionEvent e) {current(four); inputID.appendText(String.valueOf(four)); }
    
    public void btn_five(ActionEvent e) {current(five); inputID.appendText(String.valueOf(five));}
      
    public void btn_six(ActionEvent e) {current(six); inputID.appendText(String.valueOf(six));}
     
    public void btn_seven(ActionEvent e) {current(seven);  inputID.appendText(String.valueOf(seven));}
     
    public void btn_eight(ActionEvent e) {current(eight);inputID.appendText(String.valueOf(eight));}
    
    public void btn_nine(ActionEvent e) {current(nine);inputID.appendText(String.valueOf(nine));}
    
    public void btn_comma(ActionEvent e) {
         if (!currentNumber.contains(".")) {
            currentNumber += ".";
        }
        inputID.appendText(comma);
    }
    
    public void setOperation(String operation) {
        currentOperation = operation;
    }

    public void btn_Addition(ActionEvent e) {
        if (!currentNumber.isEmpty()) {
            inputNumbers.add(Double.parseDouble(currentNumber));
            inputID.clear();
            currentNumber = "";
        }
        
        setOperation("+");

    }

    public void btn_subtract(ActionEvent e) {
        if (!currentNumber.isEmpty()) {
            inputNumbers.add(Double.parseDouble(currentNumber));
            inputID.clear();
            currentNumber = "";
        }
        setOperation("-");

    }

    public void btn_multiply(ActionEvent e) {
        if (!currentNumber.isEmpty()) {
            inputNumbers.add(Double.parseDouble(currentNumber));
            inputID.clear();
            currentNumber = "";
        }
        setOperation("*");
    }

    public void btn_division(ActionEvent e) {
        if (!currentNumber.isEmpty()) {
            inputNumbers.add(Double.parseDouble(currentNumber));
            inputID.clear();
            currentNumber = "";
        }
        setOperation("/");
    }

    public void btn_operation(ActionEvent e) {
        if (!currentNumber.isEmpty()) {
            inputNumbers.add(Double.parseDouble(currentNumber));
            currentNumber = "";
        }

       double result = inputNumbers.get(0);

        for (int i = 1; i < inputNumbers.size(); i++) {
            switch (currentOperation) {
                case "+" -> result += inputNumbers.get(i);
                case "-" -> result -= inputNumbers.get(i);
                case "*" -> result *= inputNumbers.get(i);
                case "/" -> result /= inputNumbers.get(i);
            }
        }
        
        inputID.setText(String.valueOf(result));
        inputNumbers.clear();
        inputNumbers.add(result);
    }

    public void btn_reset(ActionEvent e) {
        inputID.clear();
        inputNumbers.clear();
        currentNumber = "";
        currentOperation = "";
    }

    public void btn_clear(ActionEvent e) {
        inputID.clear();
        currentNumber = "";
    }

}
