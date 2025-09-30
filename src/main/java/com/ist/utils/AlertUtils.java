package com.ist.utils;

import javafx.scene.control.Alert;

public class AlertUtils {
    
    public static void NumberExceptionAlert(Exception ex){
        System.err.println("Invalid number format: " + ex.getMessage());
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Invalid Input");
        alert.setHeaderText("Quantity and Price must be numbers!");
        alert.showAndWait();
    }
}
