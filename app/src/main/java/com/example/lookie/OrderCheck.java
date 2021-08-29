package com.example.lookie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class OrderCheck extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_check);
    }
    public void check(View view)
    {
        Intent intent;
        ImageView i;
        switch (view.getId())
        {
            case R.id.yes2:
                i=(ImageView)findViewById(R.id.yes2);
                i.setImageResource(R.drawable.yes2_check);
                intent=new Intent(this,MenuChoice.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
            case R.id.no2:
                i=(ImageView)findViewById(R.id.no2);
                i.setImageResource(R.drawable.no2_check);
                intent=new Intent(this,ForhereOrTogo.class);
                //intent=new Intent(this,BurgerDouble.class);
                startActivity(intent);
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