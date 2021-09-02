package com.example.lookie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MenuNum menuNum=(MenuNum)getApplication();
        menuNum.setBnum(1);
        menuNum.setDnum(1);
        menuNum.setDenum(1);
        menuNum.setNum(1);
    }

    public void onClick(View view)
    {
        Intent intent=new Intent(this,menuSearch.class);
        startActivity(intent);
    }
}