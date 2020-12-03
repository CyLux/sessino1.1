package com.example.testproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.google.android.material.textfield.TextInputEditText;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    TextInputEditText username, password;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    username = findViewById(R.id.edUsername);
    password=findViewById(R.id.edPassword);
    btnLogin=findViewById(R.id.btnLogin);

    btnLogin.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            if(TextUtils.isEmpty(username.getText().toString()) || TextUtils.isEmpty(password.getText())){
                Toast.makeText(MainActivity.this, "Введите логин/пароль",Toast.LENGTH_LONG).show();
            }
            else
            {
                login();
            }
        }
    });
    }
    public void login(){
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(username.getText().toString());
        loginRequest.setPassword(password.getText().toString());

       Call<LoginResponse> loginResponseCall = ApiClient.getUserServices().userLogin(loginRequest);
       loginResponseCall.enqueue(new Callback<LoginResponse>() {
           @Override
           public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
               if(response.isSuccessful()){
                   Toast.makeText(MainActivity.this, "Вход успешен",Toast.LENGTH_LONG).show();
               } else {
                   Toast.makeText(MainActivity.this, "Вход неудачен",Toast.LENGTH_LONG).show();
               }
           }

           @Override
           public void onFailure(Call<LoginResponse> call, Throwable t) {
               Toast.makeText(MainActivity.this, "Throwable"+t.getLocalizedMessage(),Toast.LENGTH_LONG).show();
           }
       });
    }
}