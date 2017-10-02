package com.example.bobby_000.dcu_orientation;

/**
 * Created by bobby_000 on 15/05/2017.
 */

public class XmlPull {
    private String title;
    private String main_content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getMain_content() {
        return main_content;
    }

    public void setMain_content(String main_content) {
        this.main_content = main_content;
    }

    public String toString()
    {
        return title+"/n"+main_content;
    }
}