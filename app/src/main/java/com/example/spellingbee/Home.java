package com.example.spellingbee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class Home extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Intent svc=new Intent(this, BackgroundSoundService.class);
        startService(svc);
        final Button playGameAct =(Button)findViewById(R.id.playGameBtn);
        final Button aboutUsAct =(Button)findViewById(R.id.aboutUsBtn);
        final Button howToPlayAct =(Button)findViewById(R.id.howToPlayBtn);
        final Button exitGameAct =(Button)findViewById(R.id.exitBtn);
        final Button settingsAct =(Button)findViewById(R.id.settingsBtn);

        playGameAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent playIntent = new Intent(Home.this,Levels.class);
                startActivity(playIntent);

            }
        });

        aboutUsAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent aboutIntent = new Intent(Home.this,AboutUs.class);
                startActivity(aboutIntent);
            }
        });


        howToPlayAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent howIntent = new Intent(Home.this,HowTo.class);
                startActivity(howIntent);
            }
        });

        settingsAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent howIntent = new Intent(Home.this,Settings.class);
                startActivity(howIntent);
            }
        });

        exitGameAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent exitIntent = new Intent(Home.this,ExitApp.class);
                startActivity(exitIntent);
            }
        });
    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed(); // this can go before or after your stuff below
        // do your stuff when the back button is pressed
        Intent intent = new Intent(getApplicationContext(), ExitApp.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        // super.onBackPressed(); calls finish(); for you

        // clear your SharedPreferences
        getSharedPreferences("preferenceName",0).edit().clear().commit();
    }
}
