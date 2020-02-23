package com.example.learninglanguage.admin;

public class uploadCategory {

    private String categoryName;


    public uploadCategory() {

    }

    public uploadCategory(String learningName) {

        this.categoryName = learningName;

    }



    public String getLearningName() {
        return categoryName;
    }

    public void setLearningName(String learningName) {
        this.categoryName = learningName;
    }


}
