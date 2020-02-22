package com.example.learninglanguage.admin;

public class learning {
    private String learningImagePath;
    private String learningName;


    public learning() {

    }

    public learning(String learningImagePath, String learningName) {
        this.learningImagePath = learningImagePath;
        this.learningName = learningName;

    }

    public String getLearningImagePath() {
        return learningImagePath;
    }

    public void setLearningImagePath(String learningImagePath) {
        this.learningImagePath = learningImagePath;
    }

    public String getLearningName() {
        return learningName;
    }

    public void setLearningName(String learningName) {
        this.learningName = learningName;
    }


}
