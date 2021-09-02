package com.example.lookie;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Currency;
import java.util.Locale;

public class SingleOrSet extends AppCompatActivity {

    Intent intent;
    ImageView i;
    TextView tv;
    Gson gson;
    BurgerData b;
    BurgerCartData bc;
    int amount = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_or_set);
        intent=getIntent();
        b=(BurgerData) intent.getSerializableExtra("burgerData");
        bc=new BurgerCartData(b.getId(),b.getPrice(),1);
        i=findViewById(R.id.print);
        i.setImageResource(getResources().getIdentifier("@drawable/" + b.getId()+"_single", "drawable", getPackageName()));
        i=findViewById(R.id.name);
        i.setImageResource(getResources().getIdentifier("@drawable/" + b.getId()+"_single_name", "drawable", getPackageName()));
        i=findViewById(R.id.ex);
        i.setImageResource(getResources().getIdentifier("@drawable/" + b.getId()+"_ex", "drawable", getPackageName()));
        i=findViewById(R.id.single);
        i.setImageResource(getResources().getIdentifier("@drawable/" + b.getId()+"_single_button", "drawable", getPackageName()));
        i=findViewById(R.id.set);
        i.setImageResource(getResources().getIdentifier("@drawable/" + b.getId()+"_set_button", "drawable", getPackageName()));
        tv=findViewById(R.id.price);
        tv.setText(Currency.getInstance(Locale.KOREA).getSymbol()+" "+String.valueOf(b.getPrice()));
        tv = findViewById(R.id.count);
        tv.setText(String.valueOf(amount));
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
    public void plus(View view)
    {
        TextView count=findViewById(R.id.count);
        TextView price=findViewById(R.id.price);
        count.setText(String.valueOf(++amount));
        price.setText(Currency.getInstance(Locale.KOREA).getSymbol()+" "+String.valueOf(bc.getPrice()*amount));
    }
    public void minus(View view)
    {
        if(amount>1)
        {
            TextView count = findViewById(R.id.count);
            TextView price = findViewById(R.id.price);
            count.setText(String.valueOf(--amount));
            price.setText(Currency.getInstance(Locale.KOREA).getSymbol() + " " + String.valueOf(bc.getPrice() * amount));
        }
    }
    public void next(View view)
    {
        ImageView iv=findViewById(view.getId());
        iv.setImageResource(R.drawable.next_check);
        gson=new GsonBuilder().create();
        bc.setAmount(amount);
        String menu=gson.toJson(bc,BurgerCartData.class);
        SharedPreferences sp=getSharedPreferences("cart",MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        MenuNum menuNum=(MenuNum)getApplication();
        int num=menuNum.getNum();
        editor.putString("menu"+String.valueOf(num),menu);
        menuNum.setNum(++num);
        editor.commit();
        Intent intent=new Intent(this,OrderCheck.class);
        startActivity(intent);
    }
    public void home(View view)
    {
        Intent intent=new Intent(this,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
    public void previous(View view)
    {
        ImageView i;
        i=(ImageView)findViewById(view.getId());
        i.setImageResource(R.drawable.button_share);
        Intent myintent = new Intent(this, PrintMenu.class);
        myintent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        myintent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(myintent);
    }
    public void set(View view)
    {
        i=findViewById(R.id.set);
        i.setImageResource(getResources().getIdentifier("@drawable/" + b.getId()+"_set_button_check", "drawable", getPackageName()));
        Intent in=new Intent(getApplicationContext(),BurgerSet.class);
        in.putExtra("burgerData", b);
        Handler h=new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                i.setImageResource(getResources().getIdentifier("@drawable/" + b.getId()+"_set_button", "drawable", getPackageName()));
                startActivity(in);
            }
        },200);
    }
    public void single(View view)
    {
        i=findViewById(R.id.single);
        i.setImageResource(getResources().getIdentifier("@drawable/" + b.getId()+"_single_button_check", "drawable", getPackageName()));
        Handler h=new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                i.setImageResource(getResources().getIdentifier("@drawable/" + b.getId()+"_single_button", "drawable", getPackageName()));
            }
        },200);
    }
}