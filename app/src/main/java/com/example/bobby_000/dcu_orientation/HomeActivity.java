package com.example.bobby_000.dcu_orientation;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }
    public void week1(View view)
    {
        Intent myIntent = new Intent(this,WeekOneActivity.class);
        startActivity(myIntent);

    }
    public void week2(View view)
    {
        Intent myIntent = new Intent(this,WeekTwoActivity.class);
        startActivity(myIntent);

    }

    public void week3(View view)
    {
        Intent myIntent = new Intent(this,WeekThreeActivity.class);
        startActivity(myIntent);
    }

    public void week4(View view)
    {
        Intent myIntent = new Intent(this,WeekFourActivity.class);
        startActivity(myIntent);
    }
    public void week5(View view)
    {
        Intent myIntent = new Intent(this,WeekFiveActivity.class);
        startActivity(myIntent);
    }
    public void gamemenu(View view)
    {
        Intent myIntent = new Intent(this,GameMenuActivity.class);
        startActivity(myIntent);
    }



}
