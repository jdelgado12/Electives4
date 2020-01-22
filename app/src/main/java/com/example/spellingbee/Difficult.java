package com.example.spellingbee;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class Difficult extends AppCompatActivity {

    private TextView label;
    private TextView qLabel;
    private EditText editTextInput;

    private String rightAnswer;
    private int rightAnswerCount =0;
    private int quizCount =1;
    static final private int QUIZ_COUNT=3;

    MediaPlayer mediaPlayer;

    private static final long COUNTDOWN_IN_MILLIS = 20000;
    private TextView countDown;
    private ColorStateList textColorDefaultcd;
    private CountDownTimer countDownTimer;
    private long timeLeftInMillis;

    ArrayList<ArrayList<String>>quizArray = new ArrayList<>();
    int randomNum = 0;

    String quizData[][]={
            //description, right answer
            {"NOUN; members of the middle class" , "bourgeoisie"},
            {"NOUN; a bright or deep red color" , "cerise"},
            {"ADJ; practicing strict self-denial as a measure of personal and especially spiritual discipline" , "asceticism"},
            {"ADJ; including or involving too many people or things " , "promiscuous"},
            {"a bacterium of a genus that includes many pathogenic kinds that cause pus formation, especially in the skin and mucous membranes" , "staphylococci"},
            {"ADJ; requiring or using great exertion " , "strenuous"},
            {"ADJ; having or showing a lack of proper respect for a sacred person, place, or object" , "sacrilegious"},
            {"NOUN; a person employed to drive a motor vehicle " , "chauffeur"},
            {"ADJ; very careful about doing what you are supposed to do" , "conscientious"},
            {"NOUN; a pterosaur of the late Jurassic period, with a long slender head and neck and a very short tail" , "pterodactyl"},
            {"NOUN; an expression of good wishes when someone leaves" , "adieu"},
            {"NOUN; bright purplish red color" , "fuchsia"},
            {"VERB; to enhance the power, wealth, position or reputation" , "aggrandize"},
            {"NOUN; a green variety of smooth-skinned summer squash" , "zucchini"},
            {"ADJ; extremely small" , "minuscule"},
            {"ADJ; relating to or denoting an original that has been imitated" , "archetypal"},
            {"NOUN; theft or misappropriation of funds placed in one's trust or belonging to one's employer" , "embezzlement"},
            {"NOUN; one who is excessively fond of eating and drinking" , "gourmand"},
            {"NOUN; the ability to speak or write well in a effective way" , "eloquence"},
            {"NOUN; a large smoked, seasoned sausage made of various meats, especially beef and pork", "bologna"},
            {"NOUN; miscellaneous articles, especially the equipment needed for a particular activity", "paraphernalia"},
            {"ADJ; (of items or people gathered or considered together) of various types or from different sources", "miscellaneous"},
            {"ADJ; very generous or forgiving, especially toward a rival or someone less powerful than oneself", "magnanimous"},
            {"ADJ; (of a person or manner) feeling or appearing casually calm and relaxed; not displaying anxiety, interest, or enthusiasm", "nonchalant"},
            {"ADJ; likely or liable to be influenced or harmed by a particular thing", "susceptible"},
            {"VERB; cause great suffering to", "scourge"},
            {"ADJ; too powerful to be defeated or overcome", "invincible"},
            {"NOUN; mutual trust and friendship among people who spend a lot of time together", "camaraderie"},
            {"ADJ; exhibiting or characterized by dichotomy", "dichotomous"},
            {"ADJ; not able to be lost, annulled, or overturned", "indefeasible"},
            {"NOUN; an extremely confused, complicated, or embarrassing situation", "imbroglio"},
            {"NOUN; coolness or reserve between people", "froideur"},
            {"NOUN; a priest or clergyman", "ecclesiastic"},
            {"NOUN; the holder of a concession or grant, especially for the use of land or commercial premises", "concessionaire"},
            {"NOUN; a person assisting the celebrant in a religious service or procession.", "acolyte"},
            {"NOUN; an allusive or oblique remark or hint, typically a suggestive or disparaging one.", "innuendo"},
            {"NOUN; light and slightly contemptuous mockery or banter.", "persiflage"},
            {"NOUN; a large trunk or suitcase, typically made of stiff leather and opening into two equal parts", "portmanteau"},
            {"NOUN; a preparation of shredded or finely cut leaf vegetables, used as a garnish for soup.", "chiffonade"},
            {"ADJ; having an excessive or erotic interest in oneself and one's physical appearance", "narcissistic"},
            {"NOUN; an object or design resembling a cross but having a loop instead of the top arm, used in ancient Egypt as a symbol of life", "ankh"},
            {"NOUN; a sudden, violent, and illegal seizure of power from a government", "coup"},
            {"NOUN; a woman's bedroom or private room", "boudoir"},
            {"NOUNl a genus of unicellular protozoa that moves by means of temporary projections called pseudopodia", "amoeba"},
            {"NOUN; a person or thing that is a perfect example of a particular quality or type", "epitome"},
            {"NOUN; a dog of a short-legged, long-bodied breed", "dachshund"},
            {"ADJ; marked by or expressing an appealingly lively quality", "effervescent"},
            {"NOUN; a very small parasitic bacterium that, like a virus, requires the biochemical mechanisms of another cell in order to reproduce", "chlamydia"},
            {"NOUN; a vegetable dish consisting of onions, zucchini, tomatoes, eggplant", "ratatouille"},
            {"NOUN;  the horizontal coordinate of a point in a plane Cartesian coordinate", "abscissa"},
            {"NOUN; a county in the West Midlands of England", "worcestershire"},

//            {"definition", "word"},
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficult);

        label = (TextView) findViewById(R.id.label);
        qLabel = (TextView) findViewById(R.id.qLabel);
        editTextInput = (EditText) findViewById(R.id.editTextInput);

        //countdown
        countDown = (TextView) findViewById(R.id.timer2);
        textColorDefaultcd = countDown.getTextColors();

        editTextInput.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent keyEvent) {
                if(keyEvent.getAction() == KeyEvent.ACTION_DOWN){

                    if(keyCode == KeyEvent.KEYCODE_ENTER){
                        checkAnswer();
                    }
                }
                return false;
            }
        });

        //create quiz array from quiz data
        for (int i = 0; i < quizData.length; i++) {

            //prepare array
            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(quizData[i][0]); //words
            tmpArray.add(quizData[i][1]); //right answer

            //add tmpArray to quizArray
            quizArray.add(tmpArray);
        }
        showNextQuiz();
    }

    public void showNextQuiz(){

        //update quizCountLabel
        label.setText("Question " + quizCount);

        Random random = new Random();
        randomNum = random.nextInt(quizArray.size());

        //pick a quiz set
        ArrayList<String> quiz = quizArray.get(randomNum);

        //set question and right answer
        //Array format: {"description, right answer"}
        qLabel.setText(quiz.get(0));
        rightAnswer=quiz.get(1);

        //remove this from quiz array
        quizArray.remove(randomNum);

        timeLeftInMillis = COUNTDOWN_IN_MILLIS;
        startCountDown();
    }

    private void startCountDown(){
        countDownTimer = new CountDownTimer(timeLeftInMillis,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timeLeftInMillis = 0;
                updateCountDownText();
                checkAnswer();

            }
        }.start();
    }

    private void updateCountDownText(){
        int minutes = (int)(timeLeftInMillis / 1000) / 60;
        int seconds = (int)(timeLeftInMillis / 1000) % 60;

        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d",minutes, seconds);

        countDown.setText(timeFormatted);

        if(timeLeftInMillis < 10000){
            countDown.setTextColor(Color.RED);

        }else{
            countDown.setTextColor(textColorDefaultcd);
        }
    }

    public void playAudio(View view){

        // Play the audio here
        try {
            mediaPlayer = MediaPlayer.create(getApplicationContext(), getResources().getIdentifier(rightAnswer.toLowerCase(), "raw", getPackageName()));
            mediaPlayer.start();
        } catch (Exception e){
            Log.d(getLocalClassName(), "prolly no audio file");
        }
    }

    public void checkAnswer() {

        //Get editText
        String answer = editTextInput.getText().toString().toLowerCase();

        String alertTitle;

        if (answer.equals(rightAnswer)) {
            //correct
            final MediaPlayer mp = MediaPlayer.create(this, R.raw.correct);
            mp.start();
            alertTitle = "Correct!";
            rightAnswerCount++;
            countDownTimer.cancel();
        } else {
            //Wrong
            final MediaPlayer mp = MediaPlayer.create(this, R.raw.wrong);
            mp.start();
            alertTitle = "Incorrect!";
            countDownTimer.cancel();
        }

        //create dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(alertTitle);
        builder.setMessage("Answer: " + rightAnswer);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                editTextInput.setText("");
                if(quizCount == QUIZ_COUNT){
                    //Show result
                    Intent intent =new Intent(getApplicationContext(), ResultActivity2.class);
                    intent.putExtra("RIGHT_ANSWER_COUNT", rightAnswerCount);
                    startActivity(intent);
                }
                else{
                    quizCount++;
                    showNextQuiz();
                }
            }
        });
        builder.setCancelable(false);
        builder.show();
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
        countDownTimer.cancel();
        // super.onBackPressed(); calls finish(); for you

        // clear your SharedPreferences
        getSharedPreferences("preferenceName",0).edit().clear().commit();
    }
}
