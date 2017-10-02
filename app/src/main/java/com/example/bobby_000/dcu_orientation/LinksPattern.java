package com.example.bobby_000.dcu_orientation;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.text.Layout;
import android.text.util.Linkify;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * Created by bobby_000 on 27/05/2017.
 */

public class LinksPattern extends Linkify {

    private static final Pattern mental_physical_health=Pattern.compile("\\bMental and Physical Health\\b");
    private static Pattern pathway_to_sucess=Pattern.compile("\\bPathways to Success\\b");
    private static Pattern changing_program =Pattern.compile("\\bChanging Programme\\b");
    private static Pattern student_learning =Pattern.compile("\\bStudent Learning\\b");
    private static Pattern library =Pattern.compile("\\bonline library tutorial\\b");
    private static Pattern timetable=Pattern.compile("\\btimetable\\b");
    private static Pattern workshop=Pattern.compile("\\bacademic skills\\b");
    private static Pattern stress_reduction=Pattern.compile("\\bMindfulness Stress Reduction\\b");
    private static Pattern learning_style=Pattern.compile("\\bLearning Style\\b");
    private static Pattern assignment_writting =Pattern.compile("\\bRegister here\\b");
    private static Pattern assignment_writting2 = Pattern.compile("\\bRegister  here\\b");
    private static Pattern maths_learning_link = Pattern.compile("\\bMaths Learning Centre\\b");
    private static Pattern academic_structure= Pattern.compile("\\bacademic structure\\b");
    private static Context current;


    LinksPattern(Context current) {
        LinksPattern.current = current.getApplicationContext(); //avoid memory leaks
    }

    static void addLinks(TextView myCustomLink) {

            addLinks(myCustomLink, mental_physical_health, current.getString(R.string.mental_physical_wealth).toString());
            addLinks(myCustomLink, pathway_to_sucess,current.getString(R.string.pathway_to_success).toString());
            addLinks(myCustomLink, changing_program, current.getString(R.string.changing_program).toString());
            addLinks(myCustomLink, student_learning,current.getString(R.string.student_learning).toString());
            addLinks(myCustomLink, library,current.getString(R.string.library).toString());
            addLinks(myCustomLink, timetable, current.getString(R.string.timtable).toString());
            addLinks(myCustomLink, stress_reduction, current.getString(R.string.stress_reduction).toString());
            addLinks(myCustomLink, learning_style, current.getString(R.string.learning_style).toString());
            addLinks(myCustomLink, assignment_writting, current.getString(R.string.assignmet_writting).toString());
            addLinks(myCustomLink, assignment_writting2, current.getString(R.string.assignmet_writting).toString());
            addLinks(myCustomLink, student_learning, current.getString(R.string.student_learning).toString());
            addLinks(myCustomLink, workshop, current.getString(R.string.workshop).toString());
            addLinks(myCustomLink, maths_learning_link, current.getString(R.string.maths_learning_center).toString());
            addLinks(myCustomLink, academic_structure, current.getString(R.string.academic_structure).toString());
    }
}
