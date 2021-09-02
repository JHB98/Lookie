package com.example.lookie;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Currency;
import java.util.Locale;

public class DrinkSize extends AppCompatActivity {

    Intent intent;
    ImageView i;
    LinearLayout l;
    Gson gson;
    TextView tv;
    DrinkData d;
    DrinkCartData dc;
    int amount = 1;
    Boolean check=false;
    String saveName="";
    int saveId=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_size);
        intent = getIntent();
        d = (DrinkData) intent.getSerializableExtra("drinkData");
        dc = new DrinkCartData(d.getId(), "M", d.getM_price(), 1);
        i = findViewById(R.id.print);
        i.setImageResource(getResources().getIdentifier("@drawable/" + d.getId() + "_menu", "drawable", getPackageName()));
        i = findViewById(R.id.name);
        i.setImageResource(getResources().getIdentifier("@drawable/" + d.getId() + "_name", "drawable", getPackageName()));
        i = findViewById(R.id.ex);
        i.setImageResource(getResources().getIdentifier("@drawable/" + d.getId() + "_ex", "drawable", getPackageName()));
        l = findViewById(R.id.choice);
        if (d.getS_price() != 0) {
            i = new ImageView(getApplicationContext());
            i.setId(Integer.valueOf(1));
            i.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    ImageView iv;
                    TextView tv;
                    if(saveName.equals("s"))
                    {
                        iv=findViewById(v.getId());
                        iv.setImageResource(getResources().getIdentifier("@drawable/" + d.getId() +"_s", "drawable", getPackageName()));
                        saveName="";
                        saveId=-1;
                        dc.setSize("M");
                        dc.setPrice(d.getM_price());
                        check=false;
                        tv = findViewById(R.id.price);
                        tv.setText(Currency.getInstance(Locale.KOREA).getSymbol() + " " + d.getM_price());
                    }
                    else
                    {
                        if (check)
                        {
                            iv = findViewById(Integer.valueOf(saveId));
                            iv.setImageResource(getResources().getIdentifier("@drawable/" + d.getId() + "_" + saveName, "drawable", getPackageName()));
                        }
                        iv = findViewById(v.getId());
                        iv.setImageResource(getResources().getIdentifier("@drawable/" + d.getId() + "_s_check", "drawable", getPackageName()));
                        dc.setSize("S");
                        dc.setPrice(d.getS_price());
                        saveId=1;
                        saveName = "s";
                        check = true;
                        tv = findViewById(R.id.price);
                        tv.setText(Currency.getInstance(Locale.KOREA).getSymbol() + " " + d.getS_price());
                    }
                }
            });
            i.setScaleType(ImageView.ScaleType.FIT_XY);
            i.setLayoutParams(new ViewGroup.LayoutParams((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 300, getResources().getDisplayMetrics()), ViewGroup.LayoutParams.MATCH_PARENT));
            i.setImageResource(getResources().getIdentifier("@drawable/" + d.getId() + "_s", "drawable", getPackageName()));
            l.addView(i);
        }
        if (d.getM_price() != 0) {
            i = new ImageView(getApplicationContext());
            i.setId(Integer.valueOf(2));
            i.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    ImageView iv;
                    TextView tv;
                    if(saveName.equals("m"))
                    {
                        iv=findViewById(v.getId());
                        iv.setImageResource(getResources().getIdentifier("@drawable/" + d.getId() +"_m", "drawable", getPackageName()));
                        saveName="";
                        saveId=-1;
                        dc.setSize("M");
                        dc.setPrice(d.getM_price());
                        check=false;
                        tv = findViewById(R.id.price);
                        tv.setText(Currency.getInstance(Locale.KOREA).getSymbol() + " " + d.getM_price());
                    }
                    else
                    {
                        if (check)
                        {
                            iv = findViewById(Integer.valueOf(saveId));
                            iv.setImageResource(getResources().getIdentifier("@drawable/" + d.getId() + "_" + saveName, "drawable", getPackageName()));
                        }
                        iv = findViewById(v.getId());
                        iv.setImageResource(getResources().getIdentifier("@drawable/" + d.getId() + "_m_check", "drawable", getPackageName()));
                        dc.setSize("M");
                        dc.setPrice(d.getM_price());
                        saveId=2;
                        saveName = "m";
                        check = true;
                        tv = findViewById(R.id.price);
                        tv.setText(Currency.getInstance(Locale.KOREA).getSymbol() + " " + d.getM_price());
                    }
                }
            });
            i.setScaleType(ImageView.ScaleType.FIT_XY);
            i.setLayoutParams(new ViewGroup.LayoutParams((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 300, getResources().getDisplayMetrics()), ViewGroup.LayoutParams.MATCH_PARENT));
            i.setImageResource(getResources().getIdentifier("@drawable/" + d.getId() + "_m", "drawable", getPackageName()));
            l.addView(i);
        }
        if (d.getL_price() != 0) {
            i = new ImageView(getApplicationContext());
            i.setId(Integer.valueOf(3));
            i.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    ImageView iv;
                    TextView tv;
                    if(saveName.equals("l"))
                    {
                        iv=findViewById(v.getId());
                        iv.setImageResource(getResources().getIdentifier("@drawable/" + d.getId() +"_l", "drawable", getPackageName()));
                        saveName="";
                        saveId=-1;
                        dc.setSize("M");
                        dc.setPrice(d.getM_price());
                        check=false;
                        tv = findViewById(R.id.price);
                        tv.setText(Currency.getInstance(Locale.KOREA).getSymbol() + " " + d.getM_price());
                    }
                    else
                    {
                        if (check)
                        {
                            iv = findViewById(Integer.valueOf(saveId));
                            iv.setImageResource(getResources().getIdentifier("@drawable/" + d.getId() + "_" + saveName, "drawable", getPackageName()));
                        }
                        iv = findViewById(v.getId());
                        iv.setImageResource(getResources().getIdentifier("@drawable/" + d.getId() + "_l_check", "drawable", getPackageName()));
                        dc.setSize("L");
                        dc.setPrice(d.getL_price());
                        saveId=3;
                        saveName = "l";
                        check = true;
                        tv = findViewById(R.id.price);
                        tv.setText(Currency.getInstance(Locale.KOREA).getSymbol() + " " + d.getL_price());
                    }
                }
            });
            i.setScaleType(ImageView.ScaleType.FIT_XY);
            i.setLayoutParams(new ViewGroup.LayoutParams((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 300, getResources().getDisplayMetrics()), ViewGroup.LayoutParams.MATCH_PARENT));
            i.setImageResource(getResources().getIdentifier("@drawable/" + d.getId() + "_l", "drawable", getPackageName()));
            l.addView(i);
        }
        tv = findViewById(R.id.price);
        tv.setText(Currency.getInstance(Locale.KOREA).getSymbol() + " " + d.getM_price());
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
        price.setText(Currency.getInstance(Locale.KOREA).getSymbol()+" "+String.valueOf(dc.getPrice()*amount));
    }
    public void minus(View view)
    {
        if(amount>1)
        {
            TextView count = findViewById(R.id.count);
            TextView price = findViewById(R.id.price);
            count.setText(String.valueOf(--amount));
            price.setText(Currency.getInstance(Locale.KOREA).getSymbol() + " " + String.valueOf(dc.getPrice() * amount));
        }
    }
    public void next(View view)
    {
        ImageView iv=findViewById(view.getId());
        iv.setImageResource(R.drawable.next_check);
        gson=new GsonBuilder().create();
        dc.setAmount(amount);
        String menu=gson.toJson(dc,DrinkCartData.class);
        SharedPreferences sp=getSharedPreferences("cart",MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        MenuNum menuNum=(MenuNum)getApplication();
        int num=menuNum.getDnum();
        editor.putString("dmenu"+String.valueOf(num),menu);
        menuNum.setDnum(++num);
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
}