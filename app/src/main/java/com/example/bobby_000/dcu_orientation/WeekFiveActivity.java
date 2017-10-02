package com.example.bobby_000.dcu_orientation;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class WeekFiveActivity extends AppCompatActivity {
    ListView focusthisweeklist;
    LinearLayout linearLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_five);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        print();


    }
    void print()
    {
        ExtractValues value = new ExtractValues(this);
        focusthisweeklist = (ListView) findViewById(R.id.list5_1);
        ArrayAdapter focus_this_week_adapter = new ArrayAdapter<>(this, R.layout.focusthisweekfont, value.getFocus_this_week(".*\\borientationWeek5\\b.*"));
        focusthisweeklist.setAdapter(focus_this_week_adapter);
        LinksPattern linksPattern = new LinksPattern(this);
        linearLayout = (LinearLayout) findViewById(R.id.wk_steps_wk5);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        ArrayList<String> weeksteps = value.getWeek_steps();
        for (String i : weeksteps) {

            TextView myCustomLink = new TextView(this);
            myCustomLink.setText(i);
            LinksPattern.addLinks(myCustomLink);
            linearLayout.addView(myCustomLink);
        }

    }

}
