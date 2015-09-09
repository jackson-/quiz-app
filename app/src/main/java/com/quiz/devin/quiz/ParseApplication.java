package com.quiz.devin.quiz;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by devin on 9/8/2015.
 */
public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "1ynoAkJUsjHI6smnpqDrfoib58W75sAzdxSryZFG", "LQQ9PNtdGIhUpewnspwUnYIZjtto6Q1KwrNuXKmz");

    }
}
