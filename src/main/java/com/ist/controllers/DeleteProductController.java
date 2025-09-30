package com.ist.controllers;

import com.ist.dao.ProductDAO;
import com.ist.utils.AlertUtils;
import com.ist.utils.SceneUtils;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class DeleteProductController {
    @FXML TextField deleteID;
    
    @FXML Button deleteButton;
    @FXML Button cancelButton;

    public void deleteProductById(ActionEvent e){
        try {
            int deleteId = Integer.parseInt(deleteID.getText());
            
            ProductDAO pDao = new ProductDAO();
            
          if( pDao.deleteProduct(deleteId)){
            Alert alertSuccess = new Alert(AlertType.CONFIRMATION);
            alertSuccess.setContentText("Deleted id "+deleteId+" successfully.");
            alertSuccess.show();
            deleteID.clear();
            
          }else{
            Alert alertFailure = new Alert(AlertType.ERROR);
            alertFailure.setContentText("Deleted faliure.");
            alertFailure.show();
          }

        } catch (NumberFormatException ex) {
             AlertUtils.NumberExceptionAlert(ex);
        }
    }

    public void switchToProduct(ActionEvent e){
     SceneUtils.swtichScene(e, "/fxml/products.fxml");
    }
}
