package com.example.lookie;

import java.io.Serializable;

public class DessertData implements Serializable {
    private String id;
    private boolean is_icecream;
    private int s_price;
    private int m_price;
    private int l_price;

    public DessertData(String id, boolean is_icecream, int s_price, int m_price, int l_price) {
        this.id = id;
        this.is_icecream = is_icecream;
        this.s_price = s_price;
        this.m_price = m_price;
        this.l_price = l_price;
    }

    public String getId() {
        return id;
    }

    public boolean getIs_icecream() {
        return is_icecream;
    }

    public int getS_price() {
        return s_price;
    }

    public int getM_price() {
        return m_price;
    }

    public int getL_price() {
        return l_price;
    }
}
