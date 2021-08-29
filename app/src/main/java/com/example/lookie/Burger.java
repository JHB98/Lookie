package com.example.lookie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Burger extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burger);
    }
    public void check(View view)
    {
        Intent intent;
        ImageView i;
        switch (view.getId())
        {
            case R.id.normal:
                i=(ImageView)findViewById(R.id.normal);
                i.setImageResource(R.drawable.normal_check);
                intent=new Intent(this,BurgerNormal.class);
                startActivity(intent);
                break;
            case R.id.double_burger:
                i=(ImageView)findViewById(R.id.double_burger);
                i.setImageResource(R.drawable.double_burger_check);
                intent=new Intent(this,BurgerDouble.class);
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
    public void previous(View view)
    {
        ImageView i;
        i=(ImageView)findViewById(view.getId());
        i.setImageResource(R.drawable.button_share);
        Intent intent=new Intent(this,MenuChoice.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}