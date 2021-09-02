package com.example.lookie;

public class DrinkCartData {
    String drink;
    String size;
    int price;
    int amount;

    public DrinkCartData(String drink, String size, int price, int amount) {
        this.drink = drink;
        this.size = size;
        this.price = price;
        this.amount = amount;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
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
