package com.example.bobby_000.dcu_orientation;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SharedPreferences preferences = getSharedPreferences("MYPREFERNCE", Context.MODE_PRIVATE);


        String scores=preferences.getString("SCORES","NO SCORES"); // if we try get the prefrence but there is no preference with a key this is default



        TextView textViewScores= (TextView) findViewById(R.id.textViewScores); //video 45 kinda lost

        textViewScores.setText(scores);
    }

}
