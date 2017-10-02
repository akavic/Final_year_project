package com.example.bobby_000.dcu_orientation;

import android.widget.TextView;

/**
 * Created by bobby_000 on 25/05/2017.
 */

public class Question {

    private int mOptionTrue;
    private int mTextResId;
    private int ansid;

    public Question(int textResId, int optionTrue,int answer) {
        mTextResId = textResId;
        mOptionTrue = optionTrue;
        ansid=answer;
    }

    public int getAnsid() {
        return ansid;
    }

    public void setAnsid(int ansid) {
        this.ansid = ansid;
    }


    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }
    public void setOptionTrue(int optionTrue) {
        mOptionTrue = optionTrue;
    }

    public int isOptionTrue() {
        return mOptionTrue;
    }

}
