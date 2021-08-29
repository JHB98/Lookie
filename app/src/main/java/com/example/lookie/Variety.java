package com.example.lookie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Variety extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_variety);
    }
    public void check(View view)
    {
        Intent intent;
        ImageView i;
        switch (view.getId())
        {
            case R.id.coke:
                i=(ImageView)findViewById(R.id.coke);
                i.setImageResource(R.drawable.coke_check);
                intent=new Intent(this,PrintMenu.class);
                intent.putExtra("is_ice",false);
                intent.putExtra("category",1);
                intent.putExtra("previous","Variety");
                startActivity(intent);
                break;
            case R.id.fruit:
                i=(ImageView)findViewById(R.id.fruit);
                i.setImageResource(R.drawable.fruit_check);
                intent=new Intent(this,PrintMenu.class);
                intent.putExtra("is_ice",false);
                intent.putExtra("category",3);
                intent.putExtra("previous","Variety");
                startActivity(intent);
                break;
            case R.id.milk:
                i=(ImageView)findViewById(R.id.milk);
                i.setImageResource(R.drawable.milk_check);
                intent=new Intent(this,PrintMenu.class);
                intent.putExtra("is_ice",false);
                intent.putExtra("category",2);
                intent.putExtra("previous","Variety");
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