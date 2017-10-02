package com.example.bobby_000.dcu_orientation;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MatchQuizActivity extends AppCompatActivity {

    private Button mOption1Button;
    private Button mOption2Button;
    private Button mOption3Button;
    private Button mOption4Button;
    private int mCurrentIndex = 0;
    private TextView mQuestionTextView;
    private TextView livesView;


    private int points=0;
    private int messageResId = 0;

    private Question[] mQuestionBank = new Question[] {
            new Question(R.string.question_1, R.id.option_2,R.string.answer_1),
            new Question(R.string.question_2, R.id.option_2,R.string.answer_2),
            new Question(R.string.question_3, R.id.option_3,R.string.answer_3),
            new Question(R.string.question_4, R.id.option_3,R.string.answer_4),
            new Question(R.string.question_5, R.id.option_4,R.string.answer_4),
    };
    private int lives=mQuestionBank.length+1;
    private int lives2=mQuestionBank.length;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_quiz);
        playGame();
    }
    private void update_answer(int option) {


        int answer = mQuestionBank[mCurrentIndex].isOptionTrue();
        if(answer == option) {

            messageResId = R.string.correct_toast;
            mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
            int question = mQuestionBank[mCurrentIndex].getTextResId();
            mQuestionTextView.setText(question);
            gameOver();
            points++;
            lives--;
            lives2--;
        }
        else {

            messageResId = R.string.incorrect_toast;
            mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
            int question = mQuestionBank[mCurrentIndex].getTextResId();
            gameOver();
            lives--;
            lives2--;
            mQuestionTextView.setText(question);
        }
        livesView.setText(String.valueOf(lives));
        gameOver();
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT)
                .show();
    }
    private void playGame()
    {

        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/KGBlankSpaceSketch.ttf");
        mQuestionTextView = (TextView) findViewById(R.id.millionaire_question);
        livesView=(TextView)findViewById(R.id.questioncount);
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        Log.d("Question VALUE", String.valueOf(question));
        String s =String.valueOf(question);
        mQuestionTextView.setText(question);
        mQuestionTextView.setTypeface(custom_font);
        livesView.setText(String.valueOf(lives));
        livesView.setTypeface(custom_font);
        gameOver();
        mOption1Button = (Button) findViewById(R.id.option_1);
        mOption1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update_answer(R.id.option_1);
            }
        });
        mOption2Button = (Button) findViewById(R.id.option_2);
        mOption2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update_answer(R.id.option_2);
            }
        });
        mOption3Button = (Button) findViewById(R.id.option_3);
        mOption3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update_answer(R.id.option_3);
            }
        });
        mOption4Button = (Button) findViewById(R.id.option_4);
        mOption4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update_answer(R.id.option_4);
            }
        });
        Log.d("MquestionLength", String.valueOf(mCurrentIndex));

    }
    void gameOver(){

        if(lives2==-1)
        {
            Intent gameOverIntent = new Intent(this, GameOverActivity.class);
            gameOverIntent.putExtra("Points_identifier", points);
            startActivity(gameOverIntent);
            finish();
        }

    }
}

