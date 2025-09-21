package com.ist.models;

public class Product {
    private int id;
    private String name;
    private String category;
    private double price;

    // setter
    public Product(String name, String category, double price){
        this.name = name;
        this.category = category;
        this.price = price;
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

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return ("id: "+id+"\nname: "+name+"\ncategory: "+category+"\nprice: "+price);
    }
}
