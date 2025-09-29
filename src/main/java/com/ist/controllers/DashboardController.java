package com.ist.controllers;

import java.io.IOException;

import com.ist.models.Sale;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


/*
 * 
What your DashboardController should do

Initialize labels & table

Set product, customer, and sales counts (fetch from DAO or set default 0).

Configure TableColumn mappings (id, productId, quantity, saleDate).

Optionally load recent sales into TableView<Sale> from SaleDAO.

Handle button actions

addProduct → open product form / dialog.

addCustomer → open customer form / dialog.

addSale → open sale form.

viewProductsId → navigate to products view.

viewCustomerId → navigate to customers view.

viewSalesId → navigate to sales view.

Expose update methods

A method like updateCounts(int products, int customers, int sales) to refresh labels dynamically.

A method like loadRecentSales(List<Sale> sales) to refresh the table.

👉 In short, your controller = glue between UI (FXML) and data layer (DAO):

Initialize UI elements.

Wire up button clicks.

Update labels/tables with data from DAO.
 */

public class DashboardController {
    @FXML private Label productCountLabel;
    @FXML private Label customerCountLabel;
    @FXML private Label salesCountLabel;

    @FXML private Button addProduct;
    @FXML private Button addSale;
    @FXML private Button addCustomer;

    @FXML private Button viewProductsId;  // fixed name
    @FXML private Button viewCustomerId;
    @FXML private Button viewSalesId;

    @FXML private TableView<Sale> salesTable; // add this in FXML if missing
    @FXML private TableColumn<Sale, Integer> tabelId;
    @FXML private TableColumn<Sale, Integer> productId;
    @FXML private TableColumn<Sale, Integer> quantityId;
    @FXML private TableColumn<Sale, String> dateId;

    @FXML
    public void initialize() {
        // Set default counts
        System.out.println("DashboardController initialized!");
        productCountLabel.setText("0");
        customerCountLabel.setText("0");
        salesCountLabel.setText("0");

        // Setup table columns
        tabelId.setCellValueFactory(new PropertyValueFactory<>("id"));
        productId.setCellValueFactory(new PropertyValueFactory<>("productId"));
        quantityId.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        dateId.setCellValueFactory(new PropertyValueFactory<>("saleDate"));
    }


@FXML
public void switchToProduct(ActionEvent e) {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/products.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Product Manager"); // optional
        stage.show();
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}

@FXML
public void switchToSales(ActionEvent e){
    try{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/sales.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }catch(IOException ex){
        ex.printStackTrace();
    }
}

@FXML 
public void switchToReports(ActionEvent e){
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/reports.fxml"));
        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.show();
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}

}
