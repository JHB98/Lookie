package com.example.lookie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class BurgerNormal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burger_normal);
    }
    public void check(View view)
    {
        ImageView i;
        Intent intent;
        switch (view.getId())
        {
            case R.id.beef:
                i=(ImageView)findViewById(R.id.beef);
                i.setImageResource(R.drawable.beef_check);
                intent=new Intent(this,PrintMenu.class);
                intent.putExtra("is_double",false);
                intent.putExtra("patty",0);
                intent.putExtra("previous","BurgerNormal");
                startActivity(intent);
                break;
            case R.id.pork:
                i=(ImageView)findViewById(R.id.pork);
                i.setImageResource(R.drawable.pork_check);
                intent=new Intent(this,PrintMenu.class);
                intent.putExtra("is_double",false);
                intent.putExtra("patty",2);
                intent.putExtra("previous","BurgerNormal");
                startActivity(intent);
                break;
            case R.id.chicken:
                i=(ImageView)findViewById(R.id.chicken);
                i.setImageResource(R.drawable.chicken_check);
                intent=new Intent(this,PrintMenu.class);
                intent.putExtra("is_double",false);
                intent.putExtra("patty",1);
                intent.putExtra("previous","BurgerNormal");
                startActivity(intent);
                break;
            case R.id.seafood:
                i=(ImageView)findViewById(R.id.seafood);
                i.setImageResource(R.drawable.seafood_check);
                intent=new Intent(this,PrintMenu.class);
                intent.putExtra("is_double",false);
                intent.putExtra("patty",3);
                intent.putExtra("previous","BurgerNormal");
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
        Intent intent=new Intent(this,Burger.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}