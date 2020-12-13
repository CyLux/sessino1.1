package com.example.testproject;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
//Данный класс позволяет пользователю зарегестрироваться
//Функционал будет добавлен позже
public class  Signup extends AppCompatActivity {
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Строка отвечабщая за переход на activity
        setContentView(R.layout.sign_up);
    }
}
