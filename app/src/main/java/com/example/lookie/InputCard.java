package com.example.lookie;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class InputCard extends AppCompatActivity {

    Handler hand;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_card);
        hand = new Handler();
        hand.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(getApplicationContext(), Finish.class);
                startActivity(i);
                finish();
            }
        }, 3000);
    }

    public void cancel(View view)
    {
        ImageView iv=(ImageView)findViewById(R.id.cancel_all);
        iv.setImageResource(R.drawable.cancel_all_check);
        hand.removeMessages(0);
        Intent i=new Intent(this,ChoicePayment.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }
    public void home(View view)
    {
        hand.removeMessages(0);
        Intent intent=new Intent(this,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}