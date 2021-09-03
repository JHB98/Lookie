package com.example.lookie;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Currency;
import java.util.Locale;

public class PrintCart extends AppCompatActivity {
    public void printMenu(MenuNum menuNum,SharedPreferences sp,TextView tv,TextView orderPrice,TextView priceAll)
    {
        BurgerSetData burgerSet;
        BurgerCartData burger;
        DrinkCartData drink;
        DessertCartData dessert;
        Gson gson;
        int sum=0;
        gson=new GsonBuilder().create();//버거 단품 = menu, 버거세트 = bmenu, 음료 = dmenu, 디저트 = demenu
        int bnum=menuNum.getBnum();
        int dnum=menuNum.getDnum();
        int denum=menuNum.getDenum();
        int num=menuNum.getNum();
        for(int i=1;i<num;i++)
        {
            String menu = sp.getString("menu" + String.valueOf(i), "");
            burger = gson.fromJson(menu, BurgerCartData.class);
            tv.append("burger : " + burger.getBurger() + "\nprice : " + burger.getPrice() + "\namount : " + burger.getAmount()+"\n");
            sum+=burger.getPrice()*burger.getAmount();
        }
        for(int i=1;i<bnum;i++)
        {
            String menu = sp.getString("bmenu" + String.valueOf(i), "");
            burgerSet = gson.fromJson(menu, BurgerSetData.class);
            tv.append("burger : " + burgerSet.getBurger() + "\ndessert : " + burgerSet.getDessert() +
                    "\ndrink : " + burgerSet.getDrink() + "\nprice : " + burgerSet.getPrice() + "\namount : " + burgerSet.getAmount()+"\n");
            sum+=burgerSet.getPrice()*burgerSet.getAmount();
        }
        for(int i=1;i<dnum;i++)
        {
            String menu = sp.getString("dmenu" + String.valueOf(i), "");
            drink = gson.fromJson(menu, DrinkCartData.class);
            tv.append("drink : " + drink.getDrink() + "\nsize : " + drink.getSize() +
                    "\nprice : " + drink.getPrice() + "\namount : " + drink.getAmount()+"\n");
            sum+=drink.getPrice()*drink.getAmount();
        }
        for(int i=1;i<denum;i++)
        {
            String menu = sp.getString("demenu" + String.valueOf(i), "");
            dessert = gson.fromJson(menu, DessertCartData.class);
            tv.append("dessert : " + dessert.getDessert() + "\nsize : " + dessert.getSize() +
                    "\nprice : " + dessert.getPrice() + "\namount : " + dessert.getAmount()+"\n");
            sum+=dessert.getPrice()*dessert.getAmount();
        }
        orderPrice.setText(Currency.getInstance(Locale.KOREA).getSymbol()+" "+String.valueOf(sum));
        priceAll.setText(Currency.getInstance(Locale.KOREA).getSymbol()+" "+String.valueOf(sum));
    }
    public void cancelAll(ImageView iv,MenuNum menuNum,SharedPreferences sp,TextView tv,TextView orderPrice,TextView priceAll)
    {
        iv.setImageResource(R.drawable.cancel_all_check);
        Handler h=new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                iv.setImageResource(R.drawable.cancel_all);
            }
        },200);
        SharedPreferences.Editor editor=sp.edit();
        editor.clear();
        editor.commit();
        menuNum.setBnum(1);
        menuNum.setDnum(1);
        menuNum.setDenum(1);
        menuNum.setNum(1);
        tv.setText("");
        orderPrice.setText(Currency.getInstance(Locale.KOREA).getSymbol()+" "+String.valueOf(0));
        priceAll.setText(Currency.getInstance(Locale.KOREA).getSymbol()+" "+String.valueOf(0));
    }
}
