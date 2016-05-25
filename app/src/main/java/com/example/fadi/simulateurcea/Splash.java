package com.example.fadi.simulateurcea;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Splash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Thread(new Runnable() {
            public void run() {

                try {
                    Thread.sleep(2000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent startMain = new Intent(Splash.this, MainActivity.class);
                 Splash.this.startActivity(startMain) ;
            }
        }).start();
    }


    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
}
