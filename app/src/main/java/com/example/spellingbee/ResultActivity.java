package com.example.spellingbee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.logging.Level;

public class ResultActivity extends AppCompatActivity {
private int chosenLVL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        SharedPreferences levelUnlock = getSharedPreferences(Levels.levelUnlock, MODE_PRIVATE);
        chosenLVL = levelUnlock.getInt("chosenLVL", 0);

        TextView resultLabel = (TextView)findViewById(R.id.resultLabel);
        TextView totalScoreLabel =(TextView)findViewById(R.id.totalScoreLabel);

        int score =getIntent().getIntExtra("RIGHT_ANSWER_COUNT", 0);
        resultLabel.setText(score + " / 5");

        SharedPreferences settings = getSharedPreferences("backgroundcolor", Context.MODE_PRIVATE);
        int totalScore = settings.getInt("totalScore", 0);
        totalScore +=score;

        resultLabel.setText(score + " / 5");
        totalScoreLabel.setText("Total Score: " + totalScore);

        //update total score

        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("totalScore: " , totalScore);
        editor.commit();

        if (score >=3) {
            if (chosenLVL ==1 ){
                SharedPreferences.Editor levelEditor = getSharedPreferences(Levels.levelUnlock, MODE_PRIVATE).edit();
                levelEditor.putInt("LVL2_unlocked", 1);
                levelEditor.commit();
                levelEditor.apply();
            }

            else if (chosenLVL == 2 ) {
                SharedPreferences.Editor levelEditor = getSharedPreferences(Levels.levelUnlock, MODE_PRIVATE).edit();
                levelEditor.putInt("LVL3_unlocked", 1);
                levelEditor.commit();
                levelEditor.apply();
            }

            else if (chosenLVL == 3 ) {
                SharedPreferences.Editor levelEditor = getSharedPreferences(Levels.levelUnlock, MODE_PRIVATE).edit();
                levelEditor.putInt("LVL4_unlocked", 1);
                levelEditor.commit();
                levelEditor.apply();
            }
            else if (chosenLVL == 4 ) {
                SharedPreferences.Editor levelEditor = getSharedPreferences(Levels.levelUnlock, MODE_PRIVATE).edit();
                levelEditor.putInt("LVL5_unlocked", 1);
                levelEditor.commit();
                levelEditor.apply();
            }
            else if (chosenLVL == 5 ) {
                SharedPreferences.Editor levelEditor = getSharedPreferences(Levels.levelUnlock, MODE_PRIVATE).edit();
                levelEditor.putInt("LVL6_unlocked", 1);
                levelEditor.commit();
                levelEditor.apply();
            }
            else if (chosenLVL == 6 ) {
                SharedPreferences.Editor levelEditor = getSharedPreferences(Levels.levelUnlock, MODE_PRIVATE).edit();
                levelEditor.putInt("LVL7_unlocked", 1);
                levelEditor.commit();
                levelEditor.apply();
            }
        }

        final Button playGameAct =(Button)findViewById(R.id.BackBtn);
        playGameAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent playIntent = new Intent(ResultActivity.this,Levels.class);
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
