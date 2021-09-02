package com.example.lookie;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Cart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        printMenu();
    }
    public void printMenu()
    {
        BurgerSetData burgerSet;
        BurgerCartData burger;
        DrinkCartData drink;
        DessertCartData dessert;
        TextView tv;
        Gson gson;
        gson=new GsonBuilder().create();//버거 단품 = menu, 버거세트 = bmenu, 음료 = dmenu, 디저트 = demenu
        MenuNum menuNum=(MenuNum)getApplication();
        int bnum=menuNum.getBnum();
        int dnum=menuNum.getDnum();
        int denum=menuNum.getDenum();
        int num=menuNum.getNum();
        SharedPreferences sp=getSharedPreferences("cart",MODE_PRIVATE);
        tv=findViewById(R.id.cart);
        for(int i=1;i<num;i++)
        {
            String menu = sp.getString("menu" + String.valueOf(i), "");
            burger = gson.fromJson(menu, BurgerCartData.class);
            tv.append("burger : " + burger.getBurger() + "\nprice : " + burger.getPrice() + "\namount : " + burger.getAmount()+"\n");
        }
        for(int i=1;i<bnum;i++)
        {
            String menu = sp.getString("bmenu" + String.valueOf(i), "");
            burgerSet = gson.fromJson(menu, BurgerSetData.class);
            tv.append("burger : " + burgerSet.getBurger() + "\ndessert : " + burgerSet.getDessert() +
                    "\ndrink : " + burgerSet.getDrink() + "\nprice : " + burgerSet.getPrice() + "\namount : " + burgerSet.getAmount()+"\n");
        }
        for(int i=1;i<dnum;i++)
        {
            String menu = sp.getString("dmenu" + String.valueOf(i), "");
            drink = gson.fromJson(menu, DrinkCartData.class);
            tv.append("drink : " + drink.getDrink() + "\nsize : " + drink.getSize() +
                    "\nprice : " + drink.getPrice() + "\namount : " + drink.getAmount()+"\n");
        }
        for(int i=1;i<denum;i++)
        {
            String menu = sp.getString("demenu" + String.valueOf(i), "");
            dessert = gson.fromJson(menu, DessertCartData.class);
            tv.append("dessert : " + dessert.getDessert() + "\nsize : " + dessert.getSize() +
                    "\nprice : " + dessert.getPrice() + "\namount : " + dessert.getAmount()+"\n");
        }
    }
    public void next(View view)
    {
        ImageView i;
        i=findViewById(view.getId());
        i.setImageResource(R.drawable.pay_check);
        Intent intent = new Intent(this, ForhereOrTogo.class);
        startActivity(intent);
    }
}