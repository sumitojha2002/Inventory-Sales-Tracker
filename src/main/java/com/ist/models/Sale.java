package com.ist.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Sale {
    private int id;
    private int productId;
    private int quantity;
    private LocalDateTime saleDate;

    public Sale (int productId,int quantity,LocalDateTime saleDate){
        this.productId = productId;
        this.quantity = quantity;
        this.saleDate = saleDate;
    }

    void setId(int id){
        this.id = id;
    }

    //getter
    public int getId() {
        return id;
    }

    public int getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDateTime getSaleDate() {
        return saleDate;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return ("id: "+id+"\nproduct id: "+productId+"\nquantity: "+quantity+"\nsale date: "+saleDate.format(formatter));
    }
}
