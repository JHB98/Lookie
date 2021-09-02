package com.example.lookie;

import java.io.Serializable;

public class BurgerCartData implements Serializable {
    String burger;
    int price;
    int amount;

    public BurgerCartData(String burger, int price, int amount) {
        this.burger = burger;
        this.price = price;
        this.amount = amount;
    }

    public String getBurger() {
        return burger;
    }

    public void setBurger(String burger) {
        this.burger = burger;
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
