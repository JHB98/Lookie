package com.example.lookie;

import java.io.Serializable;

public class BurgerSetData implements Serializable {
    String burger;
    String dessert;
    String drink;
    int price;
    int amount;

    public BurgerSetData(String burger, String dessert, String drink, int price, int amount) {
        this.burger = burger;
        this.dessert = dessert;
        this.drink = drink;
        this.price = price;
        this.amount = amount;
    }

    public String getBurger() {
        return burger;
    }

    public void setBurger(String burger) {
        this.burger = burger;
    }

    public String getDessert() {
        return dessert;
    }

    public void setDessert(String dessert) {
        this.dessert = dessert;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
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
