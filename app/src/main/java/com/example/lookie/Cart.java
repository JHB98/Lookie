package com.example.lookie;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Cart extends AppCompatActivity {

    PrintCart print;
    TextView tv;
    int sum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        print=new PrintCart();
        MenuNum menuNum=(MenuNum)getApplication();
        SharedPreferences sp=getSharedPreferences("cart",MODE_PRIVATE);
        TextView tv=findViewById(R.id.cart);
        TextView priceAll=findViewById(R.id.priceAll);
        TextView orderPrice=findViewById(R.id.orderPrice);
        print.printMenu(menuNum,sp,tv,orderPrice,priceAll);
        String ref=priceAll.getText().toString();
        ref=ref.substring(ref.indexOf(" ")+1);
        sum=Integer.parseInt(ref);
    }
    public void next(View view)
    {
        ImageView i;
        i=findViewById(view.getId());
        i.setImageResource(R.drawable.pay_check);
        Intent intent = new Intent(this, ForhereOrTogo.class);
        intent.putExtra("sum",sum);
        startActivity(intent);
    }
    public void cancelAll(View view)
    {
        MenuNum menuNum=(MenuNum)getApplication();
        SharedPreferences sp=getSharedPreferences("cart",MODE_PRIVATE);
        tv=findViewById(R.id.cart);
        ImageView iv=findViewById(view.getId());
        TextView priceAll=findViewById(R.id.priceAll);
        TextView orderPrice=findViewById(R.id.orderPrice);
        print.cancelAll(iv,menuNum,sp,tv,orderPrice,priceAll);
    }
}