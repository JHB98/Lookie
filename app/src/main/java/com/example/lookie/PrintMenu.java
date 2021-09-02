package com.example.lookie;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class PrintMenu extends AppCompatActivity {

    private Retrofit retrofit;
    private LinearLayout l;
    private int idCnt=0;
    private ImageView i;
    private TextView tv;
    private String menu;
    private Intent intent;
    private boolean extra1;
    private int extra2;
    private String path;
    private String previous;
    private final String BASE_URL="http://192.168.56.1:8080";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print_menu);

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        API api=retrofit.create(API.class);
        intent=getIntent();
        path=intent.getExtras().getString("previous");
        previous=intent.getExtras().getString("previous");
        if(previous.equals("BurgerNormal")||(previous.equals("BurgerDouble"))){
            menu="burger";
        }
        else if(previous.equals("Coffee")||(previous.equals("Variety"))) {
            menu="drink";
        }
        else if(previous.equals("Dessert")){
            if(intent.getExtras().getBoolean("is_icecream")) {
                menu = "icecream";
            }
            else{
                menu="side";
            }
        }
        i=(ImageView)findViewById(R.id.menu1);
        i.setScaleType(ImageView.ScaleType.FIT_START);
        i.setImageResource(getResources().getIdentifier("@drawable/print_"+menu, "drawable", getPackageName()));
        i=(ImageView)findViewById(R.id.menu2);
        i.setScaleType(ImageView.ScaleType.FIT_START);
        i.setImageResource(getResources().getIdentifier("@drawable/print_"+menu+"2", "drawable", getPackageName()));
        if(previous.equals("BurgerNormal")||(previous.equals("BurgerDouble"))) {
            extra1=intent.getExtras().getBoolean("is_double");
            extra2=intent.getExtras().getInt("patty");
            Call<List<BurgerData>> call = api.getBurgerList(extra2, extra1);
            call.enqueue(new Callback<List<BurgerData>>() {
                @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                @Override
                public void onResponse(Call<List<BurgerData>> call, Response<List<BurgerData>> response) {
                    if (response.isSuccessful()) {
                        List<BurgerData> burgerList = response.body();
                        l = (LinearLayout) findViewById(R.id.menuPrint);
                        for (BurgerData burger : burgerList) {
                            i = new ImageView(getApplicationContext());
                            i.setId(idCnt++);
                            i.setScaleType(ImageView.ScaleType.FIT_XY);
                            i.setLayoutParams(new ViewGroup.LayoutParams((int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 375, getResources().getDisplayMetrics()),ViewGroup.LayoutParams.MATCH_PARENT));
                            i.setImageResource(getResources().getIdentifier("@drawable/" + burger.getId(), "drawable", getPackageName()));
                            i.setOnClickListener(new View.OnClickListener(){
                                @Override
                                public void onClick(View v) {
                                    intent=new Intent(getApplicationContext(),SingleOrSet.class);
                                    intent.putExtra("burgerData", burgerList.get(v.getId()));
                                    ImageView iv=findViewById(v.getId());
                                    iv.setImageResource(getResources().getIdentifier("@drawable/" + burger.getId()+"_check", "drawable", getPackageName()));
                                    Handler h=new Handler();
                                    h.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            iv.setImageResource(getResources().getIdentifier("@drawable/" + burger.getId(), "drawable", getPackageName()));
                                            startActivity(intent);
                                        }
                                    },200);
                                }
                            });
                            l.addView(i);
                        }
                    } else {
                        Toast.makeText(PrintMenu.this, "정보받아오기 실패", Toast.LENGTH_LONG).show();
                    }
                    if(idCnt>3)
                    {
                        tv=(TextView)findViewById(R.id.slide);
                        tv.setText("옆으로 밀어 더 많은 메뉴를 확인하세요!");
                    }
                }

                @Override
                public void onFailure(Call<List<BurgerData>> call, Throwable t) {
                    Toast.makeText(PrintMenu.this, "정보받아오기 실패", Toast.LENGTH_LONG).show();
                }
            });
        }
        else if(previous.equals("Coffee")||(previous.equals("Variety"))) {
            extra1=intent.getExtras().getBoolean("is_ice");
            extra2=intent.getExtras().getInt("category");
            Call<List<DrinkData>> call = api.getDrinkList(extra2, extra1);
            call.enqueue(new Callback<List<DrinkData>>() {
                @Override
                public void onResponse(Call<List<DrinkData>> call, Response<List<DrinkData>> response) {
                    if (response.isSuccessful()) {
                        List<DrinkData> drinkList = response.body();
                        l = (LinearLayout) findViewById(R.id.menuPrint);
                        for (DrinkData drink : drinkList) {
                            i = new ImageView(getApplicationContext());
                            i.setId(idCnt++);
                            i.setScaleType(ImageView.ScaleType.FIT_XY);
                            i.setLayoutParams(new ViewGroup.LayoutParams((int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 375, getResources().getDisplayMetrics()),ViewGroup.LayoutParams.MATCH_PARENT));
                            i.setImageResource(getResources().getIdentifier("@drawable/" + drink.getId(), "drawable", getPackageName()));
                            i.setOnClickListener(new View.OnClickListener(){
                                @Override
                                public void onClick(View v) {
                                    intent=new Intent(getApplicationContext(),DrinkSize.class);
                                    intent.putExtra("drinkData", drinkList.get(v.getId()));
                                    ImageView iv=findViewById(v.getId());
                                    iv.setImageResource(getResources().getIdentifier("@drawable/" + drink.getId()+"_check", "drawable", getPackageName()));
                                    Handler h=new Handler();
                                    h.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            iv.setImageResource(getResources().getIdentifier("@drawable/" + drink.getId(), "drawable", getPackageName()));
                                            startActivity(intent);
                                        }
                                    },200);
                                }
                            });
                            l.addView(i);
                        }
                    } else {
                        Toast.makeText(PrintMenu.this, "정보받아오기 실패", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<List<DrinkData>> call, Throwable t) {
                    Toast.makeText(PrintMenu.this, "정보받아오기 실패", Toast.LENGTH_LONG).show();
                }
            });
        }
        else if(previous.equals("Dessert")) {
            extra1=intent.getExtras().getBoolean("is_icecream");
            Call<List<DessertData>> call = api.getDessertList(extra1);
            call.enqueue(new Callback<List<DessertData>>() {
                @Override
                public void onResponse(Call<List<DessertData>> call, Response<List<DessertData>> response) {
                    if (response.isSuccessful()) {
                        List<DessertData> dessertList = response.body();
                        l = (LinearLayout) findViewById(R.id.menuPrint);
                        for (DessertData dessert : dessertList) {
                            i = new ImageView(getApplicationContext());
                            i.setId(idCnt++);
                            i.setScaleType(ImageView.ScaleType.FIT_XY);
                            i.setLayoutParams(new ViewGroup.LayoutParams((int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 375, getResources().getDisplayMetrics()),ViewGroup.LayoutParams.MATCH_PARENT));
                            i.setImageResource(getResources().getIdentifier("@drawable/" + dessert.getId(), "drawable", getPackageName()));
                            i.setOnClickListener(new View.OnClickListener(){
                                @Override
                                public void onClick(View v) {
                                    intent=new Intent(getApplicationContext(),DessertSize.class);
                                    intent.putExtra("dessertData", dessertList.get(v.getId()));
                                    ImageView iv=findViewById(v.getId());
                                    iv.setImageResource(getResources().getIdentifier("@drawable/" + dessert.getId()+"_check", "drawable", getPackageName()));
                                    Handler h=new Handler();
                                    h.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            iv.setImageResource(getResources().getIdentifier("@drawable/" + dessert.getId(), "drawable", getPackageName()));
                                            startActivity(intent);
                                        }
                                    },200);
                                }
                            });
                            l.addView(i);
                        }
                    } else {
                        Toast.makeText(PrintMenu.this, "정보받아오기 실패", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<List<DessertData>> call, Throwable t) {
                    Toast.makeText(PrintMenu.this, "정보받아오기 실패", Toast.LENGTH_LONG).show();
                }
            });
        }
        printMenu();
    }
    public void printMenu()
    {
        BurgerSetData burgerSet;
        BurgerCartData burger;
        DrinkCartData drink;
        DessertCartData dessert;
        TextView tv;
        Gson gson;
        gson=new GsonBuilder().create();//버거 단품 = menu, 버거세트 = bmenu, 음료 = dmenu, 디저트 = demenu
        MenuNum menuNum=(MenuNum)getApplication();
        int bnum=menuNum.getBnum();
        int dnum=menuNum.getDnum();
        int denum=menuNum.getDenum();
        int num=menuNum.getNum();
        SharedPreferences sp=getSharedPreferences("cart",MODE_PRIVATE);
        tv=findViewById(R.id.cart);
        for(int i=1;i<num;i++)
        {
            String menu = sp.getString("menu" + String.valueOf(i), "");
            burger = gson.fromJson(menu, BurgerCartData.class);
            tv.append("burger : " + burger.getBurger() + "\nprice : " + burger.getPrice() + "\namount : " + burger.getAmount()+"\n");
        }
        for(int i=1;i<bnum;i++)
        {
            String menu = sp.getString("bmenu" + String.valueOf(i), "");
            burgerSet = gson.fromJson(menu, BurgerSetData.class);
            tv.append("burger : " + burgerSet.getBurger() + "\ndessert : " + burgerSet.getDessert() +
                    "\ndrink : " + burgerSet.getDrink() + "\nprice : " + burgerSet.getPrice() + "\namount : " + burgerSet.getAmount()+"\n");
        }
        for(int i=1;i<dnum;i++)
        {
            String menu = sp.getString("dmenu" + String.valueOf(i), "");
            drink = gson.fromJson(menu, DrinkCartData.class);
            tv.append("drink : " + drink.getDrink() + "\nsize : " + drink.getSize() +
                    "\nprice : " + drink.getPrice() + "\namount : " + drink.getAmount()+"\n");
        }
        for(int i=1;i<denum;i++)
        {
            String menu = sp.getString("demenu" + String.valueOf(i), "");
            dessert = gson.fromJson(menu, DessertCartData.class);
            tv.append("dessert : " + dessert.getDessert() + "\nsize : " + dessert.getSize() +
                    "\nprice : " + dessert.getPrice() + "\namount : " + dessert.getAmount()+"\n");
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
        if(path.equals("BurgerNormal")) {
            Intent myintent = new Intent(this, BurgerNormal.class);
            myintent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(myintent);
        }
        else if(path.equals("BurgerDouble")) {
            Intent myintent = new Intent(this, BurgerDouble.class);
            myintent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(myintent);
        }
        else if(path.equals("Coffee")) {
            Intent myintent = new Intent(this, Coffee.class);
            myintent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(myintent);
        }
        else if(path.equals("Variety")) {
            Intent myintent = new Intent(this, Variety.class);
            myintent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(myintent);
        }
        else if(path.equals("Dessert")) {
            Intent myintent = new Intent(this, Dessert.class);
            myintent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(myintent);
        }
    }
}

