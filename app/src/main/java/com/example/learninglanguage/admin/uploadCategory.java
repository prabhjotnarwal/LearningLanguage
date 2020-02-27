package com.example.learninglanguage.admin;
import com.google.firebase.database.Exclude;

public class uploadCategory {

    public uploadCategory() { }

    private String categoryName;
@Exclude
    public void setcKey(String cKey) { this.cKey = cKey; }

    private String cKey;
@Exclude
    public String getcKey() { return cKey;   }

    public uploadCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }


}
