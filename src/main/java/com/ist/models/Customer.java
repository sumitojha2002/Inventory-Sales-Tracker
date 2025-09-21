package com.ist.models;

public class Customer {
    private int id;
    private String name;
    private String contact;

    public Customer(String name,String contact){
        this.name = name;
        this.contact = contact;
    }

    public void setId(int id){
        this.id =id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getcontact() {
        return contact;
    }

    @Override
    public String toString(){
        return "id: "+id +"\nname: "+name+"\ncontact: "+contact;
    }
}
