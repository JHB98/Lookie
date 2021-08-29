package com.example.lookie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Coffee extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee);
    }
    public void check(View view)
    {
        Intent intent;
        ImageView i;
        switch (view.getId())
        {
            case R.id.ice:
                i=(ImageView)findViewById(R.id.ice);
                i.setImageResource(R.drawable.coffee_ice_check);
                intent=new Intent(this,PrintMenu.class);
                intent.putExtra("is_ice",true);
                intent.putExtra("category",0);
                intent.putExtra("previous","Coffee");
                startActivity(intent);
                break;
            case R.id.hot:
                i=(ImageView)findViewById(R.id.hot);
                i.setImageResource(R.drawable.coffee_hot_check);
                intent=new Intent(this,PrintMenu.class);
                intent.putExtra("is_ice",false);
                intent.putExtra("category",0);
                intent.putExtra("previous","Coffee");
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
        Intent intent=new Intent(this,Drink.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}