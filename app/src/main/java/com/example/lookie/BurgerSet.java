package com.example.lookie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Currency;
import java.util.Locale;

public class BurgerSet extends AppCompatActivity {

    Intent intent;
    ImageView i;
    TextView tv;
    BurgerData b;
    String dessert;
    String drink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burger_set);
        intent=getIntent();
        b=(BurgerData) intent.getSerializableExtra("burgerData");
        i=findViewById(R.id.print);
        i.setImageResource(getResources().getIdentifier("@drawable/" + b.getId()+"_set", "drawable", getPackageName()));
        i=findViewById(R.id.name);
        i.setImageResource(getResources().getIdentifier("@drawable/" + b.getId()+"_set_name", "drawable", getPackageName()));
        tv=findViewById(R.id.price);
        tv.setText(Currency.getInstance(Locale.KOREA).getSymbol()+" "+String.valueOf(b.getSet_price()));
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
        if(from.equals("dessert"))
        {
            dessert=intent.getStringExtra("dessert");
            if((TextUtils.isEmpty(dessert))||(dessert.equals("ff_m")))
            {
                i=findViewById(R.id.dessert_change);
                i.setImageResource(R.drawable.dessert_change);
            }
            else
            {
                i=findViewById(R.id.dessert_change);
                i.setImageResource(getResources().getIdentifier("@drawable/" + dessert+"_change", "drawable", getPackageName()));
            }
        }
        if(from.equals("drink"))
        {
            drink = intent.getStringExtra("drink");
            if ((TextUtils.isEmpty(drink) || (drink.equals("coke_n_m"))))
            {
                i = findViewById(R.id.drink_change);
                i.setImageResource(R.drawable.drink_change);
            }
            else
            {
                i = findViewById(R.id.drink_change);
                i.setImageResource(getResources().getIdentifier("@drawable/" + drink + "_change", "drawable", getPackageName()));
            }
        }
    }
    public void next(View view)
    {
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