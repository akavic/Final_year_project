package com.example.bobby_000.dcu_orientation;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.bobby_000.dcu_orientation.R.id.linearLayout;

public class WeekTwoActivity extends AppCompatActivity {

    ListView focusthisweeklist;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_two);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        print();


    }
    void print()
    {
        ExtractValues value = new ExtractValues(this);
        LinksPattern linksPattern = new LinksPattern(this);
        linearLayout = (LinearLayout) findViewById(R.id.wk_steps_wk2);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        focusthisweeklist = (ListView)findViewById(R.id.list2_1);
        ArrayAdapter focus_this_week_adapter = new ArrayAdapter<String>(this,R.layout.focusthisweekfont,value.getFocus_this_week(".*\\borientationWeek2\\b.*"));
        focusthisweeklist.setAdapter(focus_this_week_adapter);

        ArrayList<String> weeksteps = value.getWeek_steps();
        //method to print out textview
        for(String i: weeksteps) {

            TextView myCustomLink = new TextView(this);
            myCustomLink.setText(i);
            LinksPattern.addLinks(myCustomLink);
            linearLayout.addView(myCustomLink);
        }

    }

}
