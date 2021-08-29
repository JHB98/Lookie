package com.example.lookie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Currency;
import java.util.Locale;

public class DessertSize extends AppCompatActivity {
    Intent intent;
    ImageView i;
    TextView tv;
    LinearLayout l;
    DessertData d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dessert_size);
        intent=getIntent();
        d=(DessertData) intent.getSerializableExtra("dessertData");
        i=findViewById(R.id.print);
        i.setImageResource(getResources().getIdentifier("@drawable/" + d.getId()+"_menu", "drawable", getPackageName()));
        i=findViewById(R.id.name);
        i.setImageResource(getResources().getIdentifier("@drawable/" + d.getId()+"_name", "drawable", getPackageName()));
        i=findViewById(R.id.ex);
        i.setImageResource(getResources().getIdentifier("@drawable/" + d.getId()+"_ex", "drawable", getPackageName()));
        l=findViewById(R.id.choice);
        if(d.getS_price()!=0)
        {
            i = new ImageView(getApplicationContext());
            i.setScaleType(ImageView.ScaleType.FIT_XY);
            i.setLayoutParams(new ViewGroup.LayoutParams((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 300, getResources().getDisplayMetrics()),ViewGroup.LayoutParams.MATCH_PARENT));
            i.setImageResource(getResources().getIdentifier("@drawable/" + d.getId()+"_s", "drawable", getPackageName()));
            l.addView(i);
        }
        if(d.getM_price()!=0)
        {
            i = new ImageView(getApplicationContext());
            i.setScaleType(ImageView.ScaleType.FIT_XY);
            i.setLayoutParams(new ViewGroup.LayoutParams((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 300, getResources().getDisplayMetrics()),ViewGroup.LayoutParams.MATCH_PARENT));
            i.setImageResource(getResources().getIdentifier("@drawable/" + d.getId()+"_m", "drawable", getPackageName()));
            l.addView(i);
        }
        if(d.getL_price()!=0)
        {
            i = new ImageView(getApplicationContext());
            i.setScaleType(ImageView.ScaleType.FIT_XY);
            i.setLayoutParams(new ViewGroup.LayoutParams((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 300, getResources().getDisplayMetrics()),ViewGroup.LayoutParams.MATCH_PARENT));
            i.setImageResource(getResources().getIdentifier("@drawable/" + d.getId()+"_l", "drawable", getPackageName()));
            l.addView(i);
        }
        tv=findViewById(R.id.price);
        tv.setText(String.valueOf(Currency.getInstance(Locale.KOREA).getSymbol()+" "+d.getM_price()));
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