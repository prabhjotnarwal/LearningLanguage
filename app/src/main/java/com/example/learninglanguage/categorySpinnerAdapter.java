package com.example.learninglanguage;

import com.google.firebase.database.Exclude;

public class categorySpinnerAdapter {

    private String categoryName;

    public categorySpinnerAdapter() { }

    @Exclude
    public void setcKey(String cKey) { this.cKey = cKey; }

    private String cKey;
    @Exclude
    public String getcKey() { return cKey;   }

    public categorySpinnerAdapter(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }




}
