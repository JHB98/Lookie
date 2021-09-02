package com.example.lookie;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Currency;
import java.util.Locale;

public class BurgerSet extends AppCompatActivity {

    Intent intent;
    Gson gson;
    ImageView i;
    TextView tv;
    BurgerData b;
    BurgerSetData bs;
    int amount=1;
    int dessertChange;
    int drinkChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burger_set);
        intent=getIntent();
        b=(BurgerData) intent.getSerializableExtra("burgerData");
        bs=new BurgerSetData(b.getId(),"ff_m","coke_n_m",b.getSet_price(),1);
        i=findViewById(R.id.print);
        i.setImageResource(getResources().getIdentifier("@drawable/" + b.getId()+"_set", "drawable", getPackageName()));
        i=findViewById(R.id.name);
        i.setImageResource(getResources().getIdentifier("@drawable/" + b.getId()+"_set_name", "drawable", getPackageName()));
        tv=findViewById(R.id.price);
        tv.setText(Currency.getInstance(Locale.KOREA).getSymbol()+" "+String.valueOf(b.getSet_price()));
        tv=findViewById(R.id.count);
        tv.setText(String.valueOf(amount));
        i=findViewById(R.id.dessert_change);
        i.setImageResource(R.drawable.dessert_change);
        i=findViewById(R.id.drink_change);
        i.setImageResource(R.drawable.drink_change);
    }
    public void check(View view)
    {
        switch (view.getId())
        {
            case R.id.dessert_change:
                intent = new Intent(this, ChangeDessert.class);
                intent.putExtra("burgerData", b);
                startActivity(intent);
                break;
            case R.id.drink_change:
                intent = new Intent(this, ChangeDrink.class);
                intent.putExtra("burgerData", b);
                startActivity(intent);
                break;
        }
    }
    @Override
    protected void onNewIntent(Intent intent)
    {
        String from=intent.getStringExtra("from");
        tv=findViewById(R.id.price);
        if(from.equals("dessert"))
        {
            dessertChange=intent.getIntExtra("change",0);
            bs.setDessert(intent.getStringExtra("dessert"));
            if((TextUtils.isEmpty(bs.getDessert()))||(bs.getDessert().equals("ff_m")))
            {
                i=findViewById(R.id.dessert_change);
                i.setImageResource(R.drawable.dessert_change);
            }
            else
            {
                i=findViewById(R.id.dessert_change);
                i.setImageResource(getResources().getIdentifier("@drawable/" + bs.getDessert()+"_change", "drawable", getPackageName()));
            }
        }
        if(from.equals("drink"))
        {
            drinkChange=intent.getIntExtra("change",0);
            bs.setDrink(intent.getStringExtra("drink"));
            if ((TextUtils.isEmpty(bs.getDrink()) || (bs.getDrink().equals("coke_n_m"))))
            {
                i = findViewById(R.id.drink_change);
                i.setImageResource(R.drawable.drink_change);
            }
            else
            {
                i = findViewById(R.id.drink_change);
                i.setImageResource(getResources().getIdentifier("@drawable/" + bs.getDrink() + "_change", "drawable", getPackageName()));
            }
        }
        tv.setText(Currency.getInstance(Locale.KOREA).getSymbol()+" "+String.valueOf(b.getSet_price()+dessertChange+drinkChange));
        bs.setPrice(b.getSet_price()+dessertChange+drinkChange);
    }
    public void plus(View view)
    {
        TextView count=findViewById(R.id.count);
        TextView price=findViewById(R.id.price);
        count.setText(String.valueOf(++amount));
        price.setText(Currency.getInstance(Locale.KOREA).getSymbol()+" "+String.valueOf(bs.getPrice()*amount));
    }
    public void minus(View view)
    {
        if(amount>1)
        {
            TextView count = findViewById(R.id.count);
            TextView price = findViewById(R.id.price);
            count.setText(String.valueOf(--amount));
            price.setText(Currency.getInstance(Locale.KOREA).getSymbol() + " " + String.valueOf(bs.getPrice() * amount));
        }
    }
    public void next(View view)
    {
        ImageView iv=findViewById(view.getId());
        iv.setImageResource(R.drawable.insert_cart_check);
        gson=new GsonBuilder().create();
        bs.setAmount(amount);
        String menu=gson.toJson(bs,BurgerSetData.class);
        SharedPreferences sp=getSharedPreferences("cart",MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        MenuNum menuNum=(MenuNum)getApplication();
        int num=menuNum.getBnum();
        editor.putString("bmenu"+String.valueOf(num),menu);
        menuNum.setBnum(++num);
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
        Intent myintent = new Intent(this, SingleOrSet.class);
        myintent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        myintent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(myintent);
    }
}