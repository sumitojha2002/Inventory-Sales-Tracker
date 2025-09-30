package com.ist.controllers;

import com.ist.dao.ProductDAO;
import com.ist.models.Product;
import com.ist.utils.AlertUtils;
import com.ist.utils.SceneUtils;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ProductController {
    @FXML private TextField product_name;
    @FXML private TextField quantity;
    @FXML private TextField price;
    @FXML private TextField category;

    @FXML private Button save;
    @FXML private Button update;
    @FXML private Button delete;
    @FXML private Button clear;

    @FXML private TableView<Product> productTable;
    @FXML private TableColumn<Product,Integer> tableId;
    @FXML private TableColumn<Product,String> productId;
    @FXML private TableColumn<Product,Integer>quantityId;
    @FXML private TableColumn<Product,String>categoryId;
    @FXML private TableColumn<Product,Double>priceId;


    @FXML
    public void initialize(){
        tableId.setCellValueFactory(new PropertyValueFactory<>("id"));
        productId.setCellValueFactory(new PropertyValueFactory<>("name"));
        quantityId.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        categoryId.setCellValueFactory(new PropertyValueFactory<>("category"));
        priceId.setCellValueFactory(new PropertyValueFactory<>("price"));
    ProductDAO pDao = new ProductDAO();
    productTable.setItems(pDao.getAllProducts());
    }
    

    @FXML
    public void performSave(ActionEvent e) {
    try {
        String pname = product_name.getText();
        String pcategory = category.getText();
        int pquantity = Integer.parseInt(quantity.getText());
        double pprice = Double.parseDouble(price.getText());

        System.out.println("Saving product: " + pname + ", " + pcategory + ", " + pquantity + ", " + pprice);

        Product p = new Product(pname, pcategory, pquantity, pprice);
        ProductDAO pDao = new ProductDAO();
        pDao.addProduct(p);

        product_name.clear();
        category.clear();
        quantity.clear();
        price.clear();

    } catch (NumberFormatException ex) {
        AlertUtils.NumberExceptionAlert(ex);
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    }

    public void deleteSwitch(ActionEvent e){
        SceneUtils.swtichScene(e, "/fxml/alert/deleteAlert.fxml");        
    }


}
