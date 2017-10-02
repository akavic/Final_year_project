package com.example.bobby_000.dcu_orientation;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GameActivity extends AppCompatActivity {

   private String word;
    private int failCounter=0;
    private int guessLetter=0;
    private int points=0;
    private TextView question_val;
    private Question[] mQuestionBank = new Question[] {
            new Question(R.string.question_1, R.id.option_2,R.string.answer_1),
            new Question(R.string.question_2, R.id.option_2,R.string.answer_2),
            new Question(R.string.question_3, R.id.option_3,R.string.answer_3),
            new Question(R.string.question_4, R.id.option_3,R.string.answer_4),
            new Question(R.string.question_5, R.id.option_4,R.string.answer_4),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setRandomWord();
        createTextview();

    }

    /*
       the method is retreving the letter introduced from the edit text
     */
    public void introduceLetter(View v)
    {
        EditText myLetter= (EditText) findViewById(R.id.editTextLetter);

        String letter=myLetter.getText().toString();
        myLetter.setText("");
        Log.d("mylog","the letter is "+letter);


        if(letter.length()>0) {
            checkLetter(letter.toUpperCase());

        }
        else
            Toast.makeText(this,"please introduce a letter",Toast.LENGTH_SHORT).show();

    }

    public void checkLetter(String introduceletter)
    {
        char introLetter= introduceletter.charAt(0);
        boolean letterGuessed=false;
        for(int i=0; i<word.length();i++) {
            if(word.charAt(i)==introLetter) {
                //show letter on screen
                letterGuessed =true;
                Log.d("myLog","there was a match");
                showLettersAtIndex(i,introLetter);
                guessLetter++;
            }
        }
        if(letterGuessed==false)
        {
            letterFailed(Character.toString(introLetter));

        }
        if(guessLetter==word.length())
        {
            points++;
            clearScren();
           setRandomWord();
            createTextview();

        }
    }
    public void clearScren()
    {
        TextView textviewFailed= (TextView) findViewById(R.id.guessedWrong);
        textviewFailed.setText("");
        question_val.setText("");
        guessLetter=0;
        failCounter=0;
        word="";

        LinearLayout layoutLetters= (LinearLayout) findViewById(R.id.layoutLetters);

        if(( layoutLetters).getChildCount() > 0)
        ( layoutLetters).removeAllViews();
        ImageView imageview= (ImageView) findViewById(R.id.imageView);
        imageview.setImageResource(R.drawable.hangdroid_0);



    }
    public void setRandomWord()
    {
        TextView text =new TextView(this);
       //read in id of question and answer and intialsie them
        int randomIndex = (int) (Math.random() * mQuestionBank.length);
        question_val = (TextView) this.findViewById(R.id.question);
        int question = mQuestionBank[randomIndex].getTextResId();
        question_val.setText(question);
        int answer=mQuestionBank[randomIndex].getAnsid();
        text.setText(answer);
        word =text.getText().toString().toUpperCase();
        Log.d("GUESSWORD",word);
    }

    public void letterFailed(String letterfailed)
    {

        TextView tviewFailed = (TextView) findViewById(R.id.guessedWrong);
        String previousVal=tviewFailed.getText().toString();
        tviewFailed.setText(previousVal+letterfailed);


        failCounter++;
        failCounter=6;
        ImageView imageview= (ImageView) findViewById(R.id.imageView);

        if(failCounter==1)
        {
            imageview.setImageResource(R.drawable.hangdroid_1);
        }
        else if(failCounter==2)
        {
            imageview.setImageResource(R.drawable.hangdroid_2);
        }
        else if(failCounter==3)
        {
            imageview.setImageResource(R.drawable.hangdroid_3);
        }
        else if(failCounter==4)
        {
            imageview.setImageResource(R.drawable.hangdroid_4);
        }
        else if(failCounter==5)
        {
            imageview.setImageResource(R.drawable.hangdroid_5);
        }
        else if(failCounter==6)
        {
            Intent gameOverIntent=  new Intent(this,GameOverActivity.class);
            gameOverIntent.putExtra("Points_identifier",points);
            startActivity(gameOverIntent);
            finish();
        }

    }
    public void createTextview()
    {
        LinearLayout layoutLetters= (LinearLayout) findViewById(R.id.layoutLetters);
        for(int i=0; i<word.length();i++)
        {
            TextView newTextview= (TextView)  getLayoutInflater().inflate(R.layout.dashview,null); //dashviewl is an xml file with "_"
            layoutLetters.addView(newTextview);
        }
    }

    public void showLettersAtIndex(int position,char letterGuessed)
    {
        LinearLayout LinearLayout= (LinearLayout) findViewById(R.id.layoutLetters);
        TextView textView= (TextView) LinearLayout.getChildAt(position);
        textView.setText(Character.toString(letterGuessed));

    }
}
