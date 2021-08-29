package com.example.lookie;

import java.io.Serializable;

public class BurgerData implements Serializable {
    private String id;
    private boolean is_double;
    private int patty;
    private int price;
    private int set_price;

    public BurgerData(String id, boolean is_double, int patty, int price,int set_price) {
        this.id = id;
        this.is_double = is_double;
        this.patty = patty;
        this.price = price;
        this.set_price=set_price;
    }

    public String getId() {
        return id;
    }

    public boolean getIs_double() {
        return is_double;
    }

    public int getPatty() {
        return patty;
    }

    public int getPrice() {
        return price;
    }
    public int getSet_price(){
        return set_price;
    }
}
