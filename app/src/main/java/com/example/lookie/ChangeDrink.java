package com.example.lookie;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Currency;
import java.util.Locale;

public class ChangeDrink extends AppCompatActivity {

    Intent intent;
    BurgerData b;
    ImageView i;
    TextView tv;
    boolean check=false;
    int saveId;
    String drink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_drink);intent=getIntent();
        b=(BurgerData) intent.getSerializableExtra("burgerData");
        i=findViewById(R.id.print);
        i.setImageResource(getResources().getIdentifier("@drawable/" + b.getId()+"_set", "drawable", getPackageName()));
        i=findViewById(R.id.name);
        i.setImageResource(getResources().getIdentifier("@drawable/" + b.getId()+"_set_name", "drawable", getPackageName()));
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
            drink=null;
            check=false;
        }
        else
        {
            if(check)
            {
                iv = findViewById(saveId);
                String saveName = getResources().getResourceName(saveId);
                saveName = saveName.substring(saveName.indexOf("/") + 1);
                iv.setImageResource(getResources().getIdentifier("@drawable/" + saveName + "_change", "drawable", getPackageName()));
            }
            iv=findViewById(id);
            iv.setImageResource(getResources().getIdentifier("@drawable/" + name+"_change_check", "drawable", getPackageName()));
            saveId=id;
            drink=name;
            check=true;
        }
    }
    public void finish(View view)
    {
        ImageView iv=findViewById(view.getId());
        iv.setImageResource(R.drawable.choice_finish_check);
        Intent i=new Intent(this,BurgerSet.class);
        i.putExtra("drink",drink);
        i.putExtra("from","drink");
        if(TextUtils.isEmpty(drink))
        {
            drink=" ";
        }
        switch (drink)
        {
            case "a_m":
            case "ia_m":
                i.putExtra("change",700);
                break;
            case "bs_m":
            case "c_shake_m":
            case "cl_m":
            case "cpc_m":
            case "icl_m":
            case "s_shake_m":
                i.putExtra("change",1200);
                break;
            case "ep_m":
            case "pr_m":
                i.putExtra("change",200);
                break;
            default:
                i.putExtra("change",0);
        }
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(i);
    }
}