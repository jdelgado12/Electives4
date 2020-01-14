package com.example.spellingbee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Levels extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);
        Intent svc=new Intent(this, BackgroundSoundService.class);
        stopService(svc);
        Button firstEasy = (Button)findViewById(R.id.easy_1);
        firstEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent easy1Intent = new Intent(Levels.this,Easy1.class);
                startActivity(easy1Intent);

            }
        });

        Button secondEasy = (Button)findViewById(R.id.easy_2);
        secondEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent average1Intent = new Intent(Levels.this,Easy1.class);
                startActivity(average1Intent);
            }
        });

        Button thirdEasy = (Button)findViewById(R.id.easy_3);
        thirdEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent average1Intent = new Intent(Levels.this,Easy1.class);
                startActivity(average1Intent);
            }
        });

        Button fourthEasy = (Button)findViewById(R.id.easy_4);
        fourthEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent average1Intent = new Intent(Levels.this,Easy1.class);
                startActivity(average1Intent);
            }
        });

        Button fifthEasy = (Button)findViewById(R.id.easy_5);
        fifthEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent average1Intent = new Intent(Levels.this,Easy1.class);
                startActivity(average1Intent);
            }
        });

        Button sixthEasy = (Button)findViewById(R.id.easy_6);
        sixthEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent average1Intent = new Intent(Levels.this,Easy1.class);
                startActivity(average1Intent);
            }
        });

        Button firstAve = (Button)findViewById(R.id.ave_1);
        firstAve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent average1Intent = new Intent(Levels.this,Average.class);
                startActivity(average1Intent);
            }
        });

        Button secondAve = (Button)findViewById(R.id.ave_2);
        secondAve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent average1Intent = new Intent(Levels.this,Average.class);
                startActivity(average1Intent);
            }
        });

        Button thirdAve = (Button)findViewById(R.id.ave_3);
        thirdAve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent average1Intent = new Intent(Levels.this,Average.class);
                startActivity(average1Intent);
            }
        });

        Button fourthAve = (Button)findViewById(R.id.ave_4);
        fourthAve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent average1Intent = new Intent(Levels.this,Average.class);
                startActivity(average1Intent);
            }
        });

        Button fifthAve = (Button)findViewById(R.id.ave_5);
        fifthAve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent average1Intent = new Intent(Levels.this,Average.class);
                startActivity(average1Intent);
            }
        });

        Button sixthAve = (Button)findViewById(R.id.ave_6);
        sixthAve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent average1Intent = new Intent(Levels.this,Average.class);
                startActivity(average1Intent);
            }
        });

        Button firstDif = (Button)findViewById(R.id.dif_1);
        firstDif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent average1Intent = new Intent(Levels.this,Difficult.class);
                startActivity(average1Intent);
            }
        });

        Button secondDif = (Button)findViewById(R.id.dif_2);
        secondDif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent average1Intent = new Intent(Levels.this,Difficult.class);
                startActivity(average1Intent);
            }
        });

        Button thirdDif = (Button)findViewById(R.id.dif_3);
        thirdDif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent average1Intent = new Intent(Levels.this,Difficult.class);
                startActivity(average1Intent);
            }
        });

        Button fourthDif = (Button)findViewById(R.id.dif_4);
        fourthDif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent average1Intent = new Intent(Levels.this,Difficult.class);
                startActivity(average1Intent);
            }
        });

        Button fifthDif = (Button)findViewById(R.id.dif_5);
        fifthDif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent average1Intent = new Intent(Levels.this,Difficult.class);
                startActivity(average1Intent);
            }
        });

        Button sixthDif = (Button)findViewById(R.id.dif_6);
        sixthDif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
