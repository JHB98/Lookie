package com.example.lookie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Drink extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);
    }
    public void check(View view)
    {
        Intent intent;
        ImageView i;
        switch (view.getId())
        {
            case R.id.coffee:
                i=(ImageView)findViewById(R.id.coffee);
                i.setImageResource(R.drawable.coffee_check);
                intent=new Intent(this,Coffee.class);
                startActivity(intent);
                break;
            case R.id.variety:
                i=(ImageView)findViewById(R.id.variety);
                i.setImageResource(R.drawable.variety_check);
                intent=new Intent(this,Variety.class);
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