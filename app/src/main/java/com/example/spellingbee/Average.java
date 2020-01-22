package com.example.spellingbee;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Random;

public class Average extends AppCompatActivity {
    private TextView label;
    private TextView qLabel;
    private Button choiceBtn1;
    private Button choiceBtn2;
    private Button choiceBtn3;
    private Button choiceBtn4;
    private Button audioBtn;
    private String rightAnswer;
    private int rightAnswerCount =0;
    private int quizCount =1;
    static final private int QUIZ_COUNT=3;

    private static final long COUNTDOWN_IN_MILLIS = 5000;
    private TextView countDown;
    private ColorStateList textColorDefaultcd;
    private CountDownTimer countDownTimer;
    private long timeLeftInMillis;

    MediaPlayer mediaPlayer;

    ArrayList<ArrayList<String>>quizArray = new ArrayList<>();
    int randomNum = 0;

    String quizData[][]={
            //words, right answer, first choice, second choice, third choice
            {"VERB; to destroy the collective existence or main body of" ,  "Annihilate" , "anihillate" , "annihillate" , "anihilate"},
            {"NOUN; a sermon to a graduating class of graduatings students at a school" , "Baccalaureate" , "bacalaureate" , "bacalleureate" , "baccaleureate"},
            {"NOUN; a tropical plant that has usually red or purple flowers" , "bougainvillea" , "Bougainevillea" , "bougainvilea" , "bougainnevillea"},
            {"NOUN; a device such as a pattern of letters, ideas, or associations that assists in remembering something" , "Mnemonic" , "pnemonic" , "nemonic" , "mnemounic"},
            {"NOUN; a large flat area of land that is higher than other areas of land that surrounds it" , "Plateau" , "plataeu" , "platue" , "plateou"},
            {"NOUN; a plant with large red, pink, or white leaves that looks like petals" , "Poinsettia" ,"ponseittia" , "ponseitia" , "poinsetia"},
            {"NOUN; a part of an apparatus in which a liquid is held" , "Reservoir", "reservour" , "reservouire" , "reservoar"},
            {"NOUN; providing supplementary or additional help and support" , "Auxiliary" , "auxilliary" , "oxiliary" , "oxilliary"},
            {"NOUN; punishment inflicted in retaliaton for an injury or offense" , "Vengeance" , "venjeans" , "vengents" , "vengeants"},
            {"NOUN; a plant that has brightly colored flowers and that is often grown in gardens" , "Chrysanthemum" , "chryssanthemum" , "chryssanthemmum" , "chrrysanthemum"},
            {"NOUN; loyalty or commitment of a subordinate to a superior or of an individual to a group or cause" , "Allegiance" , "alegance" , "allegence" , "allegance"},
            {"ADJ; pleasing or picturesque in natural simplicity" , "Idyllic" , "idylic" , "idealic" , "ideallic"},
            {"ADJ; unpleasant in a way that makes people feel offended" , "Obnoxious" , "obnotious" , "obnocious" , "obnoxius"},
            {"NOUN; a lightweight plain-woven or twilled silk usually decorated with a printed pattern" , "Foulard" , "folard" , "follard" , "foullard"},
            {"NOUN; the green substance in plants that makes it possible for them to make food from carbon dioxide and water" , "Chlorophyll" , "chlorophyl" , "clorophyl" , "chlorouphyll"},
            {"NOUN; a boat with two hulls" , "Catamaran" , "katamaran" , "chatamaran" , "khatamaran"},
            {"NOUN;  an open circular or oval building with a central space surrounded by tiers of seats for spectators, for the presentation of dramatic or sporting events" , "Amphitheater" , "ampitheater" , "ampitheather" , "amphitheather"},
            {"NOUN; a chronic skin disease characterized by red circumstance red patches covered with white scales" , "Psoriasis" , "soriacist" , "soriacist" , "soriacist"},
            {"NOUN; a usually triangularly folded kerchief for the head" , "Babushka" , "babbushka" , "babbushca" , "babushca"},
            {"NOUN; a large musical instrument that is shaped like a tube, makes low sounds, played by blowing into a small thin tube in its side" , "Bassoon" , "basoon" , "bassoun" , "basoun"},
            {"NOUN; a legal agreement by which a bank or other creditor lends money at interest in exchange for taking title of the debtor's property, with the condition that the conveyance of title becomes void upon the payment of the debt" , "Mortgage" , "morgage" , "morgedge" , "mortgedge"},
            {"NOUN; exact copy" , "Facsimile" , "facsimille" , "phacsimile" , "phacsimille"},
            {"VERB; move or swing back and forth at a regular speed" , "Oscillate" , "ocilate" , "ocillate" , "oscilate"},
            {"NOUN; an unbound printed publication with no cover or with a paper cover" , "Pamphlet" , "Pamplet" , "Phamphlet" , "Phamplet"},
            {"NOUN; a person who helps organizations or groups to work together and provide information to each other" , "Liaison" , "Liason" , "Liasone" , "Liasson"},
            {"VERB; take the place of (a person or thing previously in authority or use); supplant" , "Supersede" , "supercede" , "superseed" , "superceed"},
            {"NOUN; a book in which words that have the same or similar meanings are grouped together" , "Thesaurus" , "thesorus" , "thesurous" , "thesourus"},
            {"ADJ; happy and lively in a way that is attractive" , "Vivacious" , "vivatious" , "vivateous" , "vivaceous"},
            {"NOUN; a dramatic monologue that represents a series of unspoken reflections" , "Soliloquy" , "soliloqui" , "solilocoy" , "soliloquoy"},
            {"NOUN; an army officer of high rank, in particular an officer above a lieutenant colonel and below a brigadier general." , "Colonel" , "Kernel" , "Colenel" , "Kerenel"},
            {"NOUN; a line or sequence of people or vehicles awaiting their turn to be attended to or to proceed." , "Queue" , "Queueu" , "Qeue" , "Cue"},
            {"NOUN; the way in which a word is pronounced." , "Pronunciation" , "Pronounciation" , "Prononciation" , "Pronunsiation"},
            {"ADJ;  clever, original, and inventive" , "Ingenious" , "Ingenius" , "Inginews" , "Ingeniuos"},
            {"NOUN; a large mainly solitary arboreal ape with long reddish hair, long arms, and hooked hands and feet, native to Borneo and Sumatra." , "Orangutan" , "Orangutang" , "oranggutan" , "urangutan"},
            {"VERB; continue to investigate, explore, or discuss" , "Pursue" , "persue" , "porseu" , "persew"},
            {"NOUN; the process of maintaining or preserving someone or something, or the state of being maintained" , "Maintenance" , "maintainance" , "maintainence" , "maintenence"},
            {"NOUN; a right or privilege exclusive to a particular individual or class." , "Prerogative" , "Progative" , "Prerogitive" , "Perogitive"},
            {"NOUN; a person who brings a case against another in a court of law" , "Plaintiff" , "Planetiff" , "Plaintif" , "Plantiff"},
            {"VERB; delay or postpone action; put off doing something" , "Procrastinate" , "Pocrastinate" , "Procastinate" , "Prucrastinate"},
            {"VERB; a feeling of sickness with an inclination to vomit" , "Nausea" , "Nauseu" , "Nausia" , "Nauseau"},
            {"NOUN; the day after today" , "Tomorrow" , "Tommorow" , "Tommorrow" , "Tomorow"},
            {"ADJ; wanting or devouring great quantities of food." , "Voracious" , "boracius" , "Voratious" , "Voraycious"},
            {"ADJ; (of two or more people) fully in agreement" , "Unanimous" , "Unnanimous" , "Unanimious" , "Unannimous"},
            {"NOUN; a cabinet or small recess with a door and typically shelves, used for storage." , "Cupboard" , "Cuboard" , "Cuppoard" , "Cubpoard"},
            {"VERB; be better than; surpass" , "Exceed" , "Excede" , "Exseed" , "Excsede"},

//            {"description" , "chlorophyll" , "chlorophyl" , "clorophyl" , "chlorouphyll"},

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_average);

        label = (TextView)findViewById(R.id.label);
        qLabel = (TextView)findViewById(R.id.qLabel);
        choiceBtn1 = (Button)findViewById(R.id.choiceBtn1);
        choiceBtn2 = (Button)findViewById(R.id.choiceBtn2);
        choiceBtn3 = (Button)findViewById(R.id.choiceBtn3);
        choiceBtn4 = (Button)findViewById(R.id.choiceBtn4);

        //countdown
        countDown = (TextView) findViewById(R.id.timer2);
        textColorDefaultcd = countDown.getTextColors();

        //create quiz array from quiz data
        for(int i =0; i < quizData.length; i++){

            //prepare array
            ArrayList<String>tmpArray = new ArrayList<>();
            tmpArray.add(quizData[i][0]); //words
            tmpArray.add(quizData[i][1]); //right answer
            tmpArray.add(quizData[i][2]); //first choice
            tmpArray.add(quizData[i][3]); //second choice
            tmpArray.add(quizData[i][4]); //third choice

            //add tmpArray to quizArray
            quizArray.add(tmpArray);
        }

        showNextQuiz();
    }



    public void showNextQuiz(){

        // Resets mp
        if(mediaPlayer != null){
            mediaPlayer.reset();
        }

        //update quizCountLabel
        label.setText("Question " + quizCount);

        Random random = new Random();
        randomNum = random.nextInt(quizArray.size());

        //pick a quiz set
        ArrayList<String> quiz = quizArray.get(randomNum);

        //set question and right answer
        qLabel.setText(quiz.get(0));
        rightAnswer=quiz.get(1);

        quiz.remove(0);
        Collections.shuffle(quiz);

        //set choices
        choiceBtn1.setText(quiz.get(0));
        choiceBtn2.setText(quiz.get(1));
        choiceBtn3.setText(quiz.get(2));
        choiceBtn4.setText(quiz.get(3));

        //remove from quiz array
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
                checkAnswer(null);

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

    public void checkAnswer(View view){

        //Get pushed button


        String alertTitle;

        if (view == null) {
            final MediaPlayer mp = MediaPlayer.create(this, R.raw.wrong);
            mp.start();
            alertTitle="Incorrect!";
            countDownTimer.cancel();
        }
        else {
            Button answerBtn = (Button) findViewById(view.getId());
            String btnText = answerBtn.getText().toString();


            if (btnText.equals(rightAnswer)) {
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
        }

        //create dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(alertTitle);
        builder.setMessage("Answer: " + rightAnswer);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(quizCount == QUIZ_COUNT){
                    //Show resullt
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
        // super.onBackPressed(); calls finish(); for you

        // clear your SharedPreferences
        getSharedPreferences("preferenceName",0).edit().clear().commit();
    }




}
