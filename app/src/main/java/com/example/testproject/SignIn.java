package com.example.testproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignIn extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);
        TextView Signup = (TextView) findViewById(R.id.create);
        Signup.setOnClickListener(this);
    }
    public void onClick(View view) {
        Intent i;
        i = new Intent(this, Signup.class);
        startActivity(i);
    }
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
    public void onClickVhod(View v) {
        EditText login = (EditText)findViewById(R.id.edUsername);
        EditText password = (EditText)findViewById(R.id.edPassword);


        if(login.getText().toString().equals("serk") && password.getText().toString().equals("123")){
            Intent o = new Intent(SignIn.this, StartScreen.class);
            startActivity(o);
            finish();

        }
        else
        {
            Toast.makeText(this, "Неправильно введен пароль или логин", Toast.LENGTH_SHORT).show();
        }
    }


}
