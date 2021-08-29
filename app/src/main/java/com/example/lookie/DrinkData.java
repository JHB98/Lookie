package com.example.lookie;

import java.io.Serializable;

public class DrinkData implements Serializable {
    private String id;
    private boolean is_ice;
    private int category;
    private int s_price;
    private int m_price;
    private int l_price;

    public DrinkData(String id, boolean is_ice, int category, int s_price, int m_price, int l_price) {
        this.id = id;
        this.is_ice = is_ice;
        this.category = category;
        this.s_price = s_price;
        this.m_price = m_price;
        this.l_price = l_price;
    }

    public String getId() {
        return id;
    }

    public boolean getIs_ice() {
        return is_ice;
    }

    public int getCategory() {
        return category;
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
