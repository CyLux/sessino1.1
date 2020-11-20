package com.example.testproject;
import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class LaunchScreenActivity extends Activity {
    // Время в милесекундах, в течение которого будет отображаться Splash Screen
    private final int SPLASH_DISPLAY_LENGTH = 2000;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launch_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // По истечении времени, запускаем главный активити, а Splash Screen закрываем
                Intent mainIntent = new Intent(LaunchScreenActivity.this, SignIn.class);
                LaunchScreenActivity.this.startActivity(mainIntent);
                LaunchScreenActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }

}