package com.example.spellingbee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity2 extends AppCompatActivity {
private int chosenLVL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result2);

        SharedPreferences levelUnlock = getSharedPreferences(Levels.levelUnlock, MODE_PRIVATE);
        chosenLVL = levelUnlock.getInt("chosenLVL", 0);

        TextView resultLabel = (TextView)findViewById(R.id.resultLabel);
        TextView totalScoreLabel =(TextView)findViewById(R.id.totalScoreLabel);

        int score =getIntent().getIntExtra("RIGHT_ANSWER_COUNT", 0);
        resultLabel.setText(score + " / 3");

        SharedPreferences settings = getSharedPreferences("SpellingBee", Context.MODE_PRIVATE);
        int totalScore = settings.getInt("totalScore", 0);
        totalScore +=score;

        resultLabel.setText(score + " / 3");
        totalScoreLabel.setText("Total Score: " + totalScore);

        //update total score
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("totalScore: " , totalScore);
        editor.commit();

        if (score >=2) {
            if (chosenLVL == 7) {
                SharedPreferences.Editor levelEditor = getSharedPreferences(Levels.levelUnlock, MODE_PRIVATE).edit();
                levelEditor.putInt("LVL8_unlocked", 1);
                levelEditor.commit();
                levelEditor.apply();
            }
            else if (chosenLVL == 8 ) {
                SharedPreferences.Editor levelEditor = getSharedPreferences(Levels.levelUnlock, MODE_PRIVATE).edit();
                levelEditor.putInt("LVL9_unlocked", 1);
                levelEditor.commit();
                levelEditor.apply();
            }
            else if (chosenLVL == 9 ) {
                SharedPreferences.Editor levelEditor = getSharedPreferences(Levels.levelUnlock, MODE_PRIVATE).edit();
                levelEditor.putInt("LVL10_unlocked", 1);
                levelEditor.commit();
                levelEditor.apply();
            }
            else if (chosenLVL == 10 ) {
                SharedPreferences.Editor levelEditor = getSharedPreferences(Levels.levelUnlock, MODE_PRIVATE).edit();
                levelEditor.putInt("LVL11_unlocked", 1);
                levelEditor.commit();
                levelEditor.apply();
            }
            else if (chosenLVL ==11 ) {
                SharedPreferences.Editor levelEditor = getSharedPreferences(Levels.levelUnlock, MODE_PRIVATE).edit();
                levelEditor.putInt("LVL12_unlocked", 1);
                levelEditor.commit();
                levelEditor.apply();
            }
            else if (chosenLVL == 12 ) {
                SharedPreferences.Editor levelEditor = getSharedPreferences(Levels.levelUnlock, MODE_PRIVATE).edit();
                levelEditor.putInt("LVL13_unlocked", 1);
                levelEditor.commit();
                levelEditor.apply();
            }
        }

        if (score ==3){
            if (chosenLVL == 13) {
                SharedPreferences.Editor levelEditor = getSharedPreferences(Levels.levelUnlock, MODE_PRIVATE).edit();
                levelEditor.putInt("LVL14_unlocked", 1);
                levelEditor.commit();
                levelEditor.apply();
            }
            else if (chosenLVL == 14) {
                SharedPreferences.Editor levelEditor = getSharedPreferences(Levels.levelUnlock, MODE_PRIVATE).edit();
                levelEditor.putInt("LVL15_unlocked", 1);
                levelEditor.commit();
                levelEditor.apply();
            }
            else if (chosenLVL == 15) {
                SharedPreferences.Editor levelEditor = getSharedPreferences(Levels.levelUnlock, MODE_PRIVATE).edit();
                levelEditor.putInt("LVL16_unlocked", 1);
                levelEditor.commit();
                levelEditor.apply();
            }
            else if (chosenLVL == 16) {
                SharedPreferences.Editor levelEditor = getSharedPreferences(Levels.levelUnlock, MODE_PRIVATE).edit();
                levelEditor.putInt("LVL17_unlocked", 1);
                levelEditor.commit();
                levelEditor.apply();
            }
            else if (chosenLVL == 17) {
                SharedPreferences.Editor levelEditor = getSharedPreferences(Levels.levelUnlock, MODE_PRIVATE).edit();
                levelEditor.putInt("LVL18_unlocked", 1);
                levelEditor.commit();
                levelEditor.apply();
            }
        }

        final Button playGameAct =(Button)findViewById(R.id.BackBtn);
        playGameAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent playIntent = new Intent(ResultActivity2.this,Levels.class);
                startActivity(playIntent);
            }
        });
    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed(); // this can go before or after your stuff below
        // do your stuff when the back button is pressed
        Intent intent = new Intent(getApplicationContext(), Levels.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        // super.onBackPressed(); calls finish(); for you

        // clear your SharedPreferences
        getSharedPreferences("preferenceName",0).edit().clear().commit();
    }
}
