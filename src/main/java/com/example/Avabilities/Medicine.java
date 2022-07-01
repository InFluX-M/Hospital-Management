package com.example.Avabilities;

public class Medicine {

    final private String ID;
    final private String name;
    private int stock;
    private double price;
    final private MyDate production;
    final private MyDate expiration;

    public Medicine(String ID, String name, int stock, double price, MyDate production, MyDate expiration) {

        this.ID = ID;
        this.name = name;
        this.stock = stock;
        this.price = price;
        this.production = production;
        this.expiration = expiration;

    }

    final public String getName() {return name;}
    public double getPrice() {return price;}
    public MyDate getProduction() {return this.production;}
    public MyDate getExpiration() {return this.expiration;}
    public int getStock() {return stock;}
    public void setStock(int stock) {this.stock = stock;}
}