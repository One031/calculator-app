package com.admin.calculatorapp;

import javafx.application.Application; // Import the JavaFX Application class
import javafx.fxml.FXMLLoader; // Import FXMLLoader for loading FXML files
import javafx.scene.Parent; // Import Parent class for the scene graph
import javafx.scene.Scene; // Import Scene class to set up the window
import javafx.stage.Stage; // Import Stage class for the main window

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception { // Override the start method to set up the stage
        // Load the FXML file that defines the layout of the calculator interface
        Parent root = FXMLLoader.load(getClass().getResource("Calculator.fxml"));
        
        // Create a new Scene with the loaded layout, setting the width and height of the window
        Scene scene = new Scene(root, 291, 318);
        
        // Set the title of the stage (window)
        stage.setTitle("Calculator App");
        
        // Load the CSS stylesheet for styling the calculator UI
        String css = getClass().getResource("/com/admin/calculatorapp/calculatorstyle.css").toExternalForm();
        scene.getStylesheets().add(css); // Add the stylesheet to the scene
        
        // Set the scene for the stage and show the window
        stage.setScene(scene);
        stage.show();
    }

    // The main method to launch the JavaFX application
    public static void main(String[] args) {
        launch(); // Call the launch method to start the application
    }
}
