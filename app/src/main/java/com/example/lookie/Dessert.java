package com.example.lookie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Dessert extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dessert);
    }
    public void check(View view)
    {
        Intent intent;
        ImageView i;
        switch (view.getId())
        {
            case R.id.fried:
                i=(ImageView)findViewById(R.id.fried);
                i.setImageResource(R.drawable.fried_check);
                intent=new Intent(this,PrintMenu.class);
                intent.putExtra("is_icecream",false);
                intent.putExtra("previous","Dessert");
                startActivity(intent);
                break;
            case R.id.iceCream:
                i=(ImageView)findViewById(R.id.iceCream);
                i.setImageResource(R.drawable.ice_cream_check);
                intent=new Intent(this,PrintMenu.class);
                intent.putExtra("is_icecream",true);
                intent.putExtra("previous","Dessert");
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