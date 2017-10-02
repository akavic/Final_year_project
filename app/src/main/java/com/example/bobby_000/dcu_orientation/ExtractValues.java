package com.example.bobby_000.dcu_orientation;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.util.Log;
import android.widget.ListView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by bobby_000 on 15/05/2017.
 */

public class ExtractValues extends ArrayList {

    private XMLPullParserHandler val = new XMLPullParserHandler();
    private Context context;
    private ArrayList<String> focus_this_week;
    private ArrayList<String> week_steps;
    private  String content_data;
    private  ArrayList<XmlPull> xmlVal;
    private String orientationdata;  //share data all methods will parse from

    public static final String focus_this_week_regex = "(?<=<li>).{1,70}?(?=</li>)";  //aseert that what immediately preceds  <=<li>) in the string is li
    public static final String this_week_steps_regex = "(?<=<li>).{1,900}?(?=</li>)";
    public static final String links_regex = "(?:^|[\\W])((ht|f)tp(s?):\\/\\/|www\\.)"
            + "(([\\w\\-]+\\.){1,}?([\\w\\-.~]+\\/?)*"
            + "[\\p{Alnum}.,%_=?&#\\-+()\\[\\]\\*$~@!:/{};']*)";


    public ExtractValues(Context current) {
        this.context = current.getApplicationContext(); //avoid memeory leaks
        focus_this_week = new ArrayList<>();
        week_steps = new ArrayList<>();
        try {

            AssetManager mngr = context.getAssets();
            xmlVal = (ArrayList<XmlPull>) val.parse(mngr.open("file.xml"));
            Log.d("FILE READ SUCESSFULLY", String.valueOf(xmlVal));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ExtractValues() {

        try {
            // supposedly another way to acces the context without having to pass a context argument
            AssetManager mngr =App.getContext().getAssets();
            xmlVal = (ArrayList<XmlPull>) val.parse(mngr.open("file.xml"));
            Log.d("NO CONSTRUCTOR", String.valueOf(xmlVal));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

     String fill(Pattern p) {
        //method is going to take the parameter val of oreiantation and return the right string
        // Log.d("XMLDATA",xmlVal.toString()); // xmlVal has the data

        for (XmlPull pull : xmlVal) {
            // regex to find what week i need
            String title = pull.getTitle();
            Matcher m = p.matcher(title);
            boolean b = m.matches();
            if (b == true) {
                content_data = pull.getMain_content();

                return content_data;
            }
        }
        return content_data;
    }

    //i can create a string that contains the regex pattern
    //Pattern p= Pattern.compile("(?<=&gt;&lt;li&gt;).{1,90}?(?=&lt;/li)");
    ArrayList<String> getFocus_this_week(String set_orientationPattern) {
        //String searchme=">Focus this Week:</strong><ul id=num><li>Writing Assignments</li><li>Citing and Referencing</li><li>Keeping the balance right - Mindfulness Stress Reduction Workshop</li></ul></div><ol><li>&nbsp;";
        Pattern orientationPattern = Pattern.compile(set_orientationPattern);
        orientationdata = fill(orientationPattern);
        //begin to apply regex on data;
        Pattern pattern = Pattern.compile(focus_this_week_regex);
        Matcher m = pattern.matcher(orientationdata);
        Log.d("ORIEANTATIONDATA3", orientationdata);
        while (m.find()) {

            String s = m.group();
            s = s.replace("&nbsp;", " "); // get rid of nbsp from week1
            focus_this_week.add(s);
        }

        Log.d("FOCUSTHISWEEK", focus_this_week.toString());

        return focus_this_week;
    }
    ArrayList<String> getWeek_steps() {
        //int x = focus_this_week.size();
        orientationdata=orientationdata.replace("<li type=\"_moz\">","<li>");
        Pattern pattern = Pattern.compile(this_week_steps_regex);
        Matcher m = pattern.matcher(orientationdata);
        Log.d("TheVALUEIS", String.valueOf(focus_this_week));
        while (m.find()) {
            String s = m.group();
            // all the frequent and messy data
            s = s.replace("&anbsp;", " "); // get rid of nbsp from week1
            s = s.replace("</strong>", ""); // string that represents &nbsp;
            s = s.replace("<strong>", "");
            s = s.replace("</a>", "");
            s = s.replace("<a>", " ");
            s = s.replace("<br>", "");
            s = s.replace("&nbsp;", " ");
            s = s.replaceAll(links_regex, " ");
            s = s.replace("</span>", " ");
            s = s.replace("<a href= \">", " ");
            s = s.replace("<a href=\"mailto:support.support@dcu.ie\">", " ");
            s = s.replace("<a href= \" target=\"_blank\">", "");
            s = s.replace("<span style=\"text-decoration: underline;\">", "");
            s = s.replace("<u>", "");
            s = s.replace("</u>", "");

            s = s.replace("<strong style=\"color: #ee062b;\">", "");
            s = s.replace("<a href=\"/sites/default/files/students_advice/pdfs/SSD_Stepsguide_beginning_2013.pdf\">", "");
            week_steps.add(s);
        }
        //remove the focus this week items in the array
        for(String val: focus_this_week)
        {
            week_steps.remove(val);
        }
        return week_steps;

    }


}

