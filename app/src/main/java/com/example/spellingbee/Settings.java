package com.example.spellingbee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Settings extends AppCompatActivity {
private int chosenLVL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        SharedPreferences levelUnlock = getSharedPreferences(Levels.levelUnlock, MODE_PRIVATE);
        chosenLVL = levelUnlock.getInt("chosenLVL", 0);

        final Button Reset =(Button)findViewById(R.id.resetBtn);
        Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor levelEditor = getSharedPreferences(Levels.levelUnlock, MODE_PRIVATE).edit();
                levelEditor.putInt("LVL2_unlocked", 0);
                levelEditor.putInt("LVL3_unlocked", 0);
                levelEditor.putInt("LVL4_unlocked", 0);
                levelEditor.putInt("LVL5_unlocked", 0);
                levelEditor.putInt("LVL6_unlocked", 0);
                levelEditor.putInt("LVL7_unlocked", 1);
                levelEditor.putInt("LVL8_unlocked", 0);
                levelEditor.putInt("LVL9_unlocked", 0);
                levelEditor.putInt("LVL10_unlocked", 0);
                levelEditor.putInt("LVL11_unlocked", 0);
                levelEditor.putInt("LVL12_unlocked", 0);
                levelEditor.putInt("LVL13_unlocked", 1);
                levelEditor.putInt("LVL14_unlocked", 0);
                levelEditor.putInt("LVL15_unlocked", 0);
                levelEditor.putInt("LVL16_unlocked", 0);
                levelEditor.putInt("LVL17_unlocked", 0);
                levelEditor.putInt("LVL18_unlocked", 0);
                levelEditor.commit();
                levelEditor.apply();

            }
        });

        final Button Back =(Button)findViewById(R.id.backBtn);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent playIntent = new Intent(Settings.this,Home.class);
                startActivity(playIntent);

            }
        });
    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed(); // this can go before or after your stuff below
        // do your stuff when the back button is pressed
        Intent intent = new Intent(getApplicationContext(), Home.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        // super.onBackPressed(); calls finish(); for you

        // clear your SharedPreferences
        getSharedPreferences("preferenceName",0).edit().clear().commit();
    }
}
