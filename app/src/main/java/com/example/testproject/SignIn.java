package com.example.testproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
//Данный класс позволяет пользователю войти в аккаунт
//Так как отсутствует работа с серверами мы заменили это кодом, который "Узнавал" бы пользователя
public class SignIn extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);
        //Осуществляет переход по щелчку на текстовое поле create
        TextView Signup = (TextView) findViewById(R.id.create);
        Signup.setOnClickListener(this);
    }
    //код отвечающий за переход к sign_up activity через класс Signup
    public void onClick(View view) {
        Intent i;
        i = new Intent(this, Signup.class);
        startActivity(i);
    }
    //Класс который позволяет нажать по TextView
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
    //Класс отвечающий за авторизацию пользователя
    public void onClickVhod(View v) {
        //Инициализируем поля по id
        EditText login = (EditText)findViewById(R.id.edUsername);
        EditText password = (EditText)findViewById(R.id.edPassword);

        //Если условие выполнено осуществляется переход на start_screen activity через класс SignUp
        if(login.getText().toString().equals("serk") && password.getText().toString().equals("123")){
            Intent o = new Intent(SignIn.this, StartScreen.class);
            startActivity(o);
            finish();

        }
        //Если условие не выполнено вывести сообщение
        else
        {
            Toast.makeText(this, "Неправильно введен пароль или логин", Toast.LENGTH_SHORT).show();
        }
    }


}
