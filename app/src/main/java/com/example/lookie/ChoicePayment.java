package com.example.lookie;

import android.content.Intent;
import android.renderscript.ScriptGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Currency;
import java.util.Locale;

public class ChoicePayment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_payment);
        TextView tv=findViewById(R.id.price);
        tv.setText(Currency.getInstance(Locale.KOREA).getSymbol()+" "+String.valueOf(getIntent().getIntExtra("sum",0)));
    }
    public void check(View view)
    {
        Intent intent;
        ImageView i;
        switch (view.getId())
        {
            case R.id.card:
                i=(ImageView)findViewById(R.id.card);
                i.setImageResource(R.drawable.card_check);
                intent=new Intent(this,InputCard.class);
                startActivity(intent);
                break;
            case R.id.cash:
                i=(ImageView)findViewById(R.id.cash);
                i.setImageResource(R.drawable.cash_check);
                break;
        }
    }
    public void home(View view)
    {
        Intent intent=new Intent(this,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}