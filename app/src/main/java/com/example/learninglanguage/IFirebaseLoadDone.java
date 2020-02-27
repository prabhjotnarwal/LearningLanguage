package com.example.learninglanguage;

import java.util.List;

public interface IFirebaseLoadDone {

    void onFirebaseLoadSuccess(List<categorySpinnerAdapter> category);
    void onFirebaseLoadFailed(String message);
}
