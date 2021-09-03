package com.example.lookie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ForhereOrTogo extends AppCompatActivity {

    int sum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forhere_or_togo);
        sum=getIntent().getIntExtra("sum",0);
    }
    public void check(View view)
    {
        Intent intent;
        ImageView i;
        switch (view.getId())
        {
            case R.id.forhere:
                i=(ImageView)findViewById(R.id.forhere);
                i.setImageResource(R.drawable.forhere_check);
                intent=new Intent(this,ChoicePayment.class);
                intent.putExtra("sum",sum);
                startActivity(intent);
                break;
            case R.id.togo:
                i=(ImageView)findViewById(R.id.togo);
                i.setImageResource(R.drawable.togo_check);
                intent=new Intent(this,ChoicePayment.class);
                intent.putExtra("sum",sum);
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