package com.example.lookie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Currency;
import java.util.Locale;

public class ChangeDessert extends AppCompatActivity {

    Intent intent;
    BurgerData b;
    ImageView i;
    TextView tv;
    boolean check=false;
    int saveId;
    String dessert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_dessert);
        intent=getIntent();
        b=(BurgerData) intent.getSerializableExtra("burgerData");
        i=findViewById(R.id.print);
        i.setImageResource(getResources().getIdentifier("@drawable/" + b.getId()+"_set", "drawable", getPackageName()));
        i=findViewById(R.id.name);
        i.setImageResource(getResources().getIdentifier("@drawable/" + b.getId()+"_set_name", "drawable", getPackageName()));
        tv=findViewById(R.id.price);
        tv.setText(Currency.getInstance(Locale.KOREA).getSymbol()+" "+String.valueOf(b.getSet_price()));
    }
    public void choice(View view)
    {
        int id=view.getId();
        String name=getResources().getResourceName(id);
        name=name.substring(name.indexOf("/")+1);
        ImageView iv;
        if(id==saveId)
        {
            iv=findViewById(id);
            iv.setImageResource(getResources().getIdentifier("@drawable/" + name +"_change", "drawable", getPackageName()));
            saveId=-1;
            dessert=null;
            check=false;
        }
        else
        {
            if(check)
            {
                iv=findViewById(saveId);
                String saveName=getResources().getResourceName(saveId);
                saveName=saveName.substring(saveName.indexOf("/")+1);
                iv.setImageResource(getResources().getIdentifier("@drawable/" + saveName+"_change", "drawable", getPackageName()));
                iv=findViewById(id);
                iv.setImageResource(getResources().getIdentifier("@drawable/" + name+"_change_check", "drawable", getPackageName()));
                saveId=id;
                dessert=name;
            }
            else
            {
                iv=findViewById(id);
                iv.setImageResource(getResources().getIdentifier("@drawable/" + name+"_change_check", "drawable", getPackageName()));
                saveId=id;
                dessert=name;
                check=true;
            }
        }
    }
    public void finish(View view)
    {
        ImageView iv=findViewById(view.getId());
        iv.setImageResource(R.drawable.choice_finish_check);
        Intent i=new Intent(this,BurgerSet.class);
        i.putExtra("dessert",dessert);
        i.putExtra("from","dessert");
        switch (dessert)
        {
            case "ff_l":
                i.putExtra("change",700);
                break;
            case "gc_m":
            case "msc_m":
                i.putExtra("change",400);
                break;
            case "mct_m":
                i.putExtra("change",900);
                break;
            case "mn_m":
                i.putExtra("change",100);
                break;
            default:
                i.putExtra("change",0);
        }
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(i);
    }
}