package com.example.sara.jobandtutionfinder;

public class PostInfo01 {

    String postp,username,datep;

    public PostInfo01(String posth, String username, String dateh) {
        this.postp = posth;
        this.username = username;
        this.datep = dateh;
    }

    public PostInfo01(){

    }

    public String getPostp() {
        return postp;
    }

    public void setPostp(String posth) {
        this.postp = posth;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDatep() {
        return datep;
    }

    public void setDatep(String dateh) {
        this.datep = dateh;
    }
}
