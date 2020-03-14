package com.example.learninglanguage;

public class ResultAdapter {

    private String username;
    private String result;
    private String score;

    public ResultAdapter()
    {

    }

    public ResultAdapter(String username, String result, String score) {
        this.username = username;
        this.result = result;
        this.score = score;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

}
