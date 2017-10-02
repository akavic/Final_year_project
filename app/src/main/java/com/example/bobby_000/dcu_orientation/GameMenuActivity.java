package com.example.bobby_000.dcu_orientation;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class GameMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    public void score(View view)
    {
        Intent myIntent = new Intent(this,ScoreActivity.class);
        startActivity(myIntent);
    }
    public void hangman(View view)
    {
        Intent myIntent = new Intent(this,GameActivity.class);
        startActivity(myIntent);
    }
    public void quiz(View view)
    {
        Intent myIntent = new Intent(this,MatchQuizActivity.class);
        startActivity(myIntent);
    }


}
