package com.example.spellingbee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Lobby extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobby);
        final Button joinAct =(Button)findViewById(R.id.joinBtn);
        final Button createAct =(Button)findViewById(R.id.createBtn);
        final Button backAct =(Button)findViewById(R.id.backBtn);

        joinAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent playIntent = new Intent(Lobby.this,Lobby.class);
                startActivity(playIntent);

            }
        });

        createAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent aboutIntent = new Intent(Lobby.this,Lobby.class);
                startActivity(aboutIntent);
            }
        });


        backAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent howIntent = new Intent(Lobby.this,selectMode.class);
                startActivity(howIntent);
            }
        });
    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed(); // this can go before or after your stuff below
        // do your stuff when the back button is pressed
        Intent intent = new Intent(getApplicationContext(), selectMode.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        // super.onBackPressed(); calls finish(); for you

        // clear your SharedPreferences
        getSharedPreferences("preferenceName",0).edit().clear().commit();
    }
}
