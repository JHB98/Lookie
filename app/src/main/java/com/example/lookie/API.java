package com.example.lookie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface API {
    @GET("burger/{patty}")
    Call<List<BurgerData>> getBurgerList(@Path("patty")int patty,@Query("is_double") boolean is_double);
    @GET("dessert/{is_icecream}")
    Call<List<DessertData>> getDessertList(@Path("is_icecream")boolean is_icecream);
    @GET("drink/{category}")
    Call<List<DrinkData>> getDrinkList(@Path("category")int category,@Query("is_ice") boolean is_ice);
}