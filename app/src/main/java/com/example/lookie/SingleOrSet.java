package com.example.lookie;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Currency;
import java.util.Locale;

public class SingleOrSet extends AppCompatActivity {

    Intent intent;
    ImageView i;
    TextView tv;
    BurgerData b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_or_set);
        intent=getIntent();
        b=(BurgerData) intent.getSerializableExtra("burgerData");
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
}