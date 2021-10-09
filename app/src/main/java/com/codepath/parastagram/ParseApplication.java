package com.codepath.parastagram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication  extends Application {
    @Override
    public void onCreate() {

        super.onCreate();

        ParseObject.registerSubclass(Post.class);
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("3MIKETXz5obVWTsSG82Zv9OWqqWPFq72FOyBAnVx")
                .clientKey("ApngnSNrwq6XwXbtcyB33pBJmIcTV5QJSH5bylhx")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
