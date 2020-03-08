package com.example.learninglanguage;

import com.google.firebase.database.Exclude;

public class uploadLevel {

public uploadLevel(String id, String str1){}
    private String levelName;
@Exclude
    public void setlKey(String lKey) {
        this.lKey = lKey;
    }

    private String lKey;
@Exclude
    public String getlKey() {
        return lKey;
    }



    public uploadLevel( String levelName) {

        this.levelName = levelName;
    }



    public String getLevelName() {
        return levelName;
    }



    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }


}
