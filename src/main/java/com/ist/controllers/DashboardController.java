package com.ist.controllers;

import java.io.IOException;

import com.ist.models.Sale;
import com.ist.utils.SceneUtils;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
    SceneUtils.swtichScene(e, "/fxml/products.fxml");
}

@FXML
public void switchToSales(ActionEvent e){
    SceneUtils.swtichScene(e, "/fxml/sales.fxml");
}

@FXML 
public void switchToReports(ActionEvent e){
    SceneUtils.swtichScene(e, "/fxml/reports.fxml");
}

}
