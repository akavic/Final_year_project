package com.example.bobby_000.dcu_orientation;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class GameOverActivity extends AppCompatActivity {

    int mpoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        //second value is a defualt incase the identifer(points_identifier) is unable to give the points val
        int points =getIntent().getIntExtra("Points_identifier",0);

       TextView textViewPoints= (TextView) findViewById(R.id.textviewpoints);
        //cannot use int as a value when using setText method must convert

       textViewPoints.setText(String.valueOf(points));

        mpoints=points;

// todo https://developer.android.com/studio/test/espresso-test-recorder.html
    }

    public void Savescore(View v)
    {
        SharedPreferences prefrence =getSharedPreferences("MYPREFERNCE", Context.MODE_PRIVATE);

       EditText edittext= (EditText) findViewById(R.id.namevalue);

        String name=edittext.getText().toString();

        SharedPreferences.Editor editor= prefrence.edit();

        String previousScore=prefrence.getString("Scores",""); //getting the previous score
        editor.putString("SCORES",name+"  "+mpoints+" "+" POINTS\n"+previousScore );
        editor.commit();//need to call this method the info wont be stored

        finish();
    }

}
