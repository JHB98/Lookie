package com.example.lookie;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MenuChoice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_choice);
    }

    public void check(View view)
    {
        Intent intent;
        ImageView i;
        switch(view.getId())
        {
            case R.id.burger:
                i=(ImageView)findViewById(R.id.burger);
                i.setImageResource(R.drawable.burger_check);
                intent=new Intent(this,Burger.class);
                startActivity(intent);
                break;
            case R.id.drink:
                i=(ImageView)findViewById(R.id.drink);
                i.setImageResource(R.drawable.drink_check);
                intent=new Intent(this,Drink.class);
                startActivity(intent);
                break;
            case R.id.dessert:
                i=(ImageView)findViewById(R.id.dessert);
                i.setImageResource(R.drawable.dessert_check);
                intent=new Intent(this,Dessert.class);
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
        Intent intent=new Intent(this,menuSearch.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

}