package com.example.spellingbee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.logging.Level;

public class Levels extends AppCompatActivity {
    private int chosenLVL, LVL2_unlocked, LVL3_unlocked, LVL4_unlocked, LVL5_unlocked, LVL6_unlocked,
            LVL7_unlocked, LVL8_unlocked, LVL9_unlocked, LVL10_unlocked, LVL11_unlocked, LVL12_unlocked,
            LVL13_unlocked, LVL14_unlocked, LVL15_unlocked, LVL16_unlocked, LVL17_unlocked, LVL18_unlocked;

    public static String levelUnlock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);
//        Intent svc=new Intent(this, BackgroundSoundService.class);
//        stopService(svc);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.click);

        Button firstEasy = (Button)findViewById(R.id.easy_1);
        Button secondEasy = (Button)findViewById(R.id.easy_2);
        Button thirdEasy = (Button)findViewById(R.id.easy_3);
        Button fourthEasy = (Button)findViewById(R.id.easy_4);
        Button fifthEasy = (Button)findViewById(R.id.easy_5);
        Button sixthEasy = (Button)findViewById(R.id.easy_6);
        Button firstAve = (Button)findViewById(R.id.ave_1);
        Button secondAve = (Button)findViewById(R.id.ave_2);
        Button thirdAve = (Button)findViewById(R.id.ave_3);
        Button fourthAve = (Button)findViewById(R.id.ave_4);
        Button fifthAve = (Button)findViewById(R.id.ave_5);
        Button sixthAve = (Button)findViewById(R.id.ave_6);
        Button firstDif = (Button)findViewById(R.id.dif_1);
        Button secondDif = (Button)findViewById(R.id.dif_2);
        Button thirdDif = (Button)findViewById(R.id.dif_3);
        Button fourthDif = (Button)findViewById(R.id.dif_4);
        Button fifthDif = (Button)findViewById(R.id.dif_5);
        Button sixthDif = (Button)findViewById(R.id.dif_6);

        SharedPreferences sharedPreferences = getSharedPreferences(levelUnlock, MODE_PRIVATE);
        chosenLVL = sharedPreferences.getInt("chosenLVL", 0);
        LVL2_unlocked = sharedPreferences.getInt("LVL2_unlocked", 0);
        LVL3_unlocked = sharedPreferences.getInt("LVL3_unlocked", 0);
        LVL4_unlocked = sharedPreferences.getInt("LVL4_unlocked", 0);
        LVL5_unlocked = sharedPreferences.getInt("LVL5_unlocked", 0);
        LVL6_unlocked = sharedPreferences.getInt("LVL6_unlocked", 0);
        LVL7_unlocked = sharedPreferences.getInt("LVL7_unlocked", 0);
        LVL8_unlocked = sharedPreferences.getInt("LVL8_unlocked", 0);
        LVL9_unlocked = sharedPreferences.getInt("LVL9_unlocked", 0);
        LVL10_unlocked = sharedPreferences.getInt("LVL10_unlocked", 0);
        LVL11_unlocked = sharedPreferences.getInt("LVL11_unlocked", 0);
        LVL12_unlocked = sharedPreferences.getInt("LVL12_unlocked", 0);
        LVL13_unlocked = sharedPreferences.getInt("LVL13_unlocked", 0);
        LVL14_unlocked = sharedPreferences.getInt("LVL14_unlocked", 0);
        LVL15_unlocked = sharedPreferences.getInt("LVL15_unlocked", 0);
        LVL16_unlocked = sharedPreferences.getInt("LVL16_unlocked", 0);
        LVL17_unlocked = sharedPreferences.getInt("LVL17_unlocked", 0);
        LVL18_unlocked = sharedPreferences.getInt("LVL18_unlocked", 0);

        if(LVL2_unlocked == 0) {
            secondEasy.setEnabled(false);
            secondEasy.setAlpha(0.5f);
        }
        else if (LVL2_unlocked == 1){
            secondEasy.setEnabled(true);
            secondEasy.setAlpha(1f);
        }


        if(LVL3_unlocked == 0) {
            thirdEasy.setEnabled(false);
            thirdEasy.setAlpha(0.5f);
        }
        else if (LVL3_unlocked == 1){
            thirdEasy.setEnabled(true);
            thirdEasy.setAlpha(1f);
        }

        if(LVL4_unlocked == 0) {
            fourthEasy.setEnabled(false);
            fourthEasy.setAlpha(0.5f);
        }
        else if (LVL4_unlocked == 1){
            fourthEasy.setEnabled(true);
            fourthEasy.setAlpha(1f);
        }

        if(LVL5_unlocked == 0) {
            fifthEasy.setEnabled(false);
            fifthEasy.setAlpha(0.5f);
        }
        else if (LVL5_unlocked == 1){
            fifthEasy.setEnabled(true);
            fifthEasy.setAlpha(1f);
        }

        if(LVL6_unlocked == 0) {
            sixthEasy.setEnabled(false);
            sixthEasy.setAlpha(0.5f);
        }
        else if (LVL6_unlocked == 1){
            sixthEasy.setEnabled(true);
            sixthEasy.setAlpha(1f);
        }

        if(LVL7_unlocked == 0) {
            firstAve.setEnabled(false);
            firstAve.setAlpha(0.5f);
        }
        else if (LVL7_unlocked == 1){
            firstAve.setEnabled(true);
            firstAve.setAlpha(1f);
        }

        if(LVL8_unlocked == 0) {
            secondAve.setEnabled(false);
            secondAve.setAlpha(0.5f);
        }
        else if (LVL8_unlocked == 1){
            secondAve.setEnabled(true);
            secondAve.setAlpha(1f);
        }

        if(LVL9_unlocked == 0) {
            thirdAve.setEnabled(false);
            thirdAve.setAlpha(0.5f);
        }
        else if (LVL9_unlocked == 1){
            thirdAve.setEnabled(true);
            thirdAve.setAlpha(1f);
        }

        if(LVL10_unlocked == 0) {
            fourthAve.setEnabled(false);
            fourthAve.setAlpha(0.5f);
        }
        else if (LVL10_unlocked == 1){
            fourthAve.setEnabled(true);
            fourthAve.setAlpha(1f);
        }

        if(LVL11_unlocked == 0) {
            fifthAve.setEnabled(false);
            fifthAve.setAlpha(0.5f);
        }
        else if (LVL11_unlocked == 1){
            fifthAve.setEnabled(true);
            fifthAve.setAlpha(1f);
        }

        if(LVL12_unlocked == 0) {
            sixthAve.setEnabled(false);
            sixthAve.setAlpha(0.5f);
        }
        else if (LVL12_unlocked == 1){
            sixthAve.setEnabled(true);
            sixthAve.setAlpha(1f);
        }

        if(LVL13_unlocked == 0) {
            firstDif.setEnabled(false);
            firstDif.setAlpha(0.5f);
        }
        else if (LVL13_unlocked == 1){
            firstDif.setEnabled(true);
            firstDif.setAlpha(1f);
        }

        if(LVL14_unlocked == 0) {
            secondDif.setEnabled(false);
            secondDif.setAlpha(0.5f);
        }
        else if (LVL14_unlocked == 1){
            secondDif.setEnabled(true);
            secondDif.setAlpha(1f);
        }

        if(LVL15_unlocked == 0) {
            thirdDif.setEnabled(false);
            thirdDif.setAlpha(0.5f);
        }
        else if (LVL15_unlocked == 1){
            thirdDif.setEnabled(true);
            thirdDif.setAlpha(1f);
        }

        if(LVL16_unlocked == 0) {
            fourthDif.setEnabled(false);
            fourthDif.setAlpha(0.5f);
        }
        else if (LVL16_unlocked == 1){
            fourthDif.setEnabled(true);
            fourthDif.setAlpha(1f);
        }

        if(LVL17_unlocked == 0) {
            fifthDif.setEnabled(false);
            fifthDif.setAlpha(0.5f);
        }
        else if (LVL17_unlocked == 1){
            fifthDif.setEnabled(true);
            fifthDif.setAlpha(1f);
        }

        if(LVL18_unlocked == 0) {
            sixthDif.setEnabled(false);
            sixthDif.setAlpha(0.5f);
        }
        else if (LVL18_unlocked == 1){
            sixthDif.setEnabled(true);
            sixthDif.setAlpha(1f);
        }


        firstEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor LevelEditor = getSharedPreferences(levelUnlock, MODE_PRIVATE).edit();
                LevelEditor.putInt("chosenLVL", 1);
                LevelEditor.commit();
                LevelEditor.apply();

                mp.start();
                Intent easy1Intent = new Intent(Levels.this,tuts_easy1.class);
                startActivity(easy1Intent);

            }
        });


        secondEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor LevelEditor = getSharedPreferences(levelUnlock, MODE_PRIVATE).edit();
                LevelEditor.putInt("chosenLVL", 2);
                LevelEditor.commit();
                LevelEditor.apply();

                mp.start();
                Intent average1Intent = new Intent(Levels.this,Easy1.class);
                startActivity(average1Intent);
            }
        });


        thirdEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor LevelEditor = getSharedPreferences(levelUnlock, MODE_PRIVATE).edit();
                LevelEditor.putInt("chosenLVL", 3);
                LevelEditor.commit();
                LevelEditor.apply();

                mp.start();
                Intent average1Intent = new Intent(Levels.this,Easy1.class);
                startActivity(average1Intent);
            }
        });


        fourthEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor LevelEditor = getSharedPreferences(levelUnlock, MODE_PRIVATE).edit();
                LevelEditor.putInt("chosenLVL", 4);
                LevelEditor.commit();
                LevelEditor.apply();

                mp.start();
                Intent average1Intent = new Intent(Levels.this,Easy1.class);
                startActivity(average1Intent);
            }
        });


        fifthEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor LevelEditor = getSharedPreferences(levelUnlock, MODE_PRIVATE).edit();
                LevelEditor.putInt("chosenLVL", 5);
                LevelEditor.commit();
                LevelEditor.apply();

                mp.start();
                Intent average1Intent = new Intent(Levels.this,Easy1.class);
                startActivity(average1Intent);
            }
        });


        sixthEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor LevelEditor = getSharedPreferences(levelUnlock, MODE_PRIVATE).edit();
                LevelEditor.putInt("chosenLVL", 6);
                LevelEditor.commit();
                LevelEditor.apply();

                mp.start();
                Intent average1Intent = new Intent(Levels.this,Easy1.class);
                startActivity(average1Intent);
            }
        });


        firstAve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor LevelEditor = getSharedPreferences(levelUnlock, MODE_PRIVATE).edit();
                LevelEditor.putInt("chosenLVL", 7);
                LevelEditor.commit();
                LevelEditor.apply();

                mp.start();
                Intent average1Intent = new Intent(Levels.this,tuts_ave1.class);
                startActivity(average1Intent);
            }
        });


        secondAve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor LevelEditor = getSharedPreferences(levelUnlock, MODE_PRIVATE).edit();
                LevelEditor.putInt("chosenLVL", 8);
                LevelEditor.commit();
                LevelEditor.apply();

                mp.start();
                Intent average1Intent = new Intent(Levels.this,Average.class);
                startActivity(average1Intent);
            }
        });

        thirdAve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor LevelEditor = getSharedPreferences(levelUnlock, MODE_PRIVATE).edit();
                LevelEditor.putInt("chosenLVL", 9);
                LevelEditor.commit();
                LevelEditor.apply();

                mp.start();
                Intent average1Intent = new Intent(Levels.this,Average.class);
                startActivity(average1Intent);
            }
        });

        fourthAve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor LevelEditor = getSharedPreferences(levelUnlock, MODE_PRIVATE).edit();
                LevelEditor.putInt("chosenLVL", 10);
                LevelEditor.commit();
                LevelEditor.apply();

                mp.start();
                Intent average1Intent = new Intent(Levels.this,Average.class);
                startActivity(average1Intent);
            }
        });

        fifthAve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor LevelEditor = getSharedPreferences(levelUnlock, MODE_PRIVATE).edit();
                LevelEditor.putInt("chosenLVL", 11);
                LevelEditor.commit();
                LevelEditor.apply();

                mp.start();
                Intent average1Intent = new Intent(Levels.this,Average.class);
                startActivity(average1Intent);
            }
        });

        sixthAve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor LevelEditor = getSharedPreferences(levelUnlock, MODE_PRIVATE).edit();
                LevelEditor.putInt("chosenLVL", 12);
                LevelEditor.commit();
                LevelEditor.apply();

                mp.start();
                Intent average1Intent = new Intent(Levels.this,Average.class);
                startActivity(average1Intent);
            }
        });

        firstDif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor LevelEditor = getSharedPreferences(levelUnlock, MODE_PRIVATE).edit();
                LevelEditor.putInt("chosenLVL", 13);
                LevelEditor.commit();
                LevelEditor.apply();

                mp.start();
                Intent average1Intent = new Intent(Levels.this,tuts_dif1.class);
                startActivity(average1Intent);
            }
        });

        secondDif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor LevelEditor = getSharedPreferences(levelUnlock, MODE_PRIVATE).edit();
                LevelEditor.putInt("chosenLVL", 14);
                LevelEditor.commit();
                LevelEditor.apply();

                mp.start();
                Intent average1Intent = new Intent(Levels.this,Difficult.class);
                startActivity(average1Intent);
            }
        });

        thirdDif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor LevelEditor = getSharedPreferences(levelUnlock, MODE_PRIVATE).edit();
                LevelEditor.putInt("chosenLVL", 15);
                LevelEditor.commit();
                LevelEditor.apply();

                mp.start();
                Intent average1Intent = new Intent(Levels.this,Difficult.class);
                startActivity(average1Intent);
            }
        });

        fourthDif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor LevelEditor = getSharedPreferences(levelUnlock, MODE_PRIVATE).edit();
                LevelEditor.putInt("chosenLVL", 16);
                LevelEditor.commit();
                LevelEditor.apply();

                mp.start();
                Intent average1Intent = new Intent(Levels.this,Difficult.class);
                startActivity(average1Intent);
            }
        });

        fifthDif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor LevelEditor = getSharedPreferences(levelUnlock, MODE_PRIVATE).edit();
                LevelEditor.putInt("chosenLVL", 17);
                LevelEditor.commit();
                LevelEditor.apply();

                mp.start();
                Intent average1Intent = new Intent(Levels.this,Difficult.class);
                startActivity(average1Intent);
            }
        });

        sixthDif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor LevelEditor = getSharedPreferences(levelUnlock, MODE_PRIVATE).edit();
                LevelEditor.putInt("chosenLVL", 18);
                LevelEditor.commit();
                LevelEditor.apply();

                mp.start();
                Intent average1Intent = new Intent(Levels.this,Difficult.class);
                startActivity(average1Intent);
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
