package com.example.spellingbee;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
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
            {"NOUN; the ability to speak or write well in a effective way" , "eloquence"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficult);

        label = (TextView) findViewById(R.id.label);
        qLabel = (TextView) findViewById(R.id.qLabel);
        editTextInput = (EditText) findViewById(R.id.editTextInput);

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
        label.setText("Q" + quizCount);

        Random random = new Random();
//        randomNum = random.nextInt(quizArray.size());

        //pick a quiz set
        ArrayList<String> quiz = quizArray.get(randomNum);

        //set question and right answer
        //Array format: {"description, right answer"}
        qLabel.setText(quiz.get(0));
        rightAnswer=quiz.get(1);

        //remove this from quiz array
        quizArray.remove(randomNum);
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
            alertTitle = "Correct!";
            rightAnswerCount++;
        } else {
            //Wrong
            alertTitle = "Incorrect!";
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

}
