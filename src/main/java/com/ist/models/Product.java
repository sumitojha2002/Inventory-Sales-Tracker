package com.ist.models;

public class Product {
    private int id;
    private String name;
    private String category;
    private int quantity;
    private double price;

    // setter
    public Product(String name, String category,int quantity , double price){
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public void setId(int id){
        this.id = id;
    }

    // getter
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return ("id: "+id+"\nname: "+name+"\ncategory: "+category+"\nquantity:"+quantity+"\nprice: "+price);
    }
}
