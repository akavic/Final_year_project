package com.example.bobby_000.dcu_orientation;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class HangManLossActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void hangManLossActivityTest() {
        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.button5), withText("Semester 1"), isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.button11), withText("Games"), isDisplayed()));
        appCompatButton2.perform(click());

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.button15), withText("Hangman"), isDisplayed()));
        appCompatButton3.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.editTextLetter),
                        withParent(allOf(withId(R.id.linearLayout),
                                withParent(withId(R.id.gamept1)))),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("n"), closeSoftKeyboard());

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.button5), withText("Click"),
                        withParent(allOf(withId(R.id.linearLayout),
                                withParent(withId(R.id.gamept1)))),
                        isDisplayed()));
        appCompatButton4.perform(click());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.namevalue),
                        withParent(withId(R.id.linearLayout)),
                        isDisplayed()));
        appCompatEditText2.perform(replaceText("loser"), closeSoftKeyboard());

        ViewInteraction appCompatButton5 = onView(
                allOf(withId(R.id.saveScore), withText("Save score"),
                        withParent(withId(R.id.linearLayout)),
                        isDisplayed()));
        appCompatButton5.perform(click());

        ViewInteraction appCompatButton6 = onView(
                allOf(withId(R.id.button5), withText("Score"), isDisplayed()));
        appCompatButton6.perform(click());

    }

}
