package com.example.lookie;

public class DessertCartData {
    String dessert;
    String size;
    int price;
    int amount;

    public DessertCartData(String dessert, String size, int price, int amount) {
        this.dessert = dessert;
        this.size = size;
        this.price = price;
        this.amount = amount;
    }

    public String getDessert() {
        return dessert;
    }

    public void setDessert(String dessert) {
        this.dessert = dessert;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
