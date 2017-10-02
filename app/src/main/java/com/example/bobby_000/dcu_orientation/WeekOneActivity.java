package com.example.bobby_000.dcu_orientation;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.util.Linkify;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import  android.content.ContentProvider;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.regex.Pattern;

import static com.example.bobby_000.dcu_orientation.R.id.time;
import static com.example.bobby_000.dcu_orientation.R.id.wk_steps_wk1;

public class WeekOneActivity extends AppCompatActivity {

    ListView focusthisweeklist;
    LinearLayout linearLayout;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        print();

    }

    void print() {
        LinksPattern linksPattern = new LinksPattern(this);
        linearLayout = (LinearLayout) findViewById(R.id.wk_steps_wk1);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        ExtractValues value = new ExtractValues(this);
        focusthisweeklist = (ListView) findViewById(R.id.list1_1);

        ArrayAdapter focus_this_week_adapter = new ArrayAdapter<>(this, R.layout.focusthisweekfont, value.getFocus_this_week(".*\\borientationWeek1\\b.*"));
        focusthisweeklist.setAdapter(focus_this_week_adapter);
        ArrayList<String> weeksteps = value.getWeek_steps();
        // method to print out textview
        for(String i: weeksteps) {

            TextView myCustomLink = new TextView(this);
            myCustomLink.setText(i);
            LinksPattern.addLinks(myCustomLink);
            linearLayout.addView(myCustomLink);
        }
    }
}
