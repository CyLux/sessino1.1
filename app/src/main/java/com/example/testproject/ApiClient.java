package com.example.testproject;
import okhttp3.OkHttpClient;

import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
//класс отвечающий за получения данных из заданного API
public class ApiClient {
    private static Retrofit getRetrofit(){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(logging).build();
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://api.larntech.net/")
                .client(okHttpClient)
                .build();
        return retrofit;
    }
    public static UserService getUserServices(){
        UserService userService = getRetrofit().create(UserService.class);
        return userService;
    }
}
