package com.example.learninglanguage;

public class uploadLevel {

    private String levelId;
    private String levelName;

    public uploadLevel(String levelId, String levelName) {
        this.levelId = levelId;
        this.levelName = levelName;
    }

    public String getLevelId() {
        return levelId;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelId(String levelId) {
        this.levelId = levelId;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }


}
