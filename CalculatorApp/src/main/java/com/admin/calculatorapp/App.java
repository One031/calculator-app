package com.admin.calculatorapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

     @Override
   public void start(Stage stage) throws Exception {
       Parent root = FXMLLoader.load(getClass().getResource("Calculator.fxml"));
       Scene scene = new Scene(root, 291, 318);
       stage.setTitle("Calculator App");
       String css = getClass().getResource("/com/admin/calculatorapp/calculatorstyle.css").toExternalForm();
       scene.getStylesheets().add(css);
       stage.setScene(scene);
       stage.show();
       
   }

   

    public static void main(String[] args) {
        launch();
    }

}