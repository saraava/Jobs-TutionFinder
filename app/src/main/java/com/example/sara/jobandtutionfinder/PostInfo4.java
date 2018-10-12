package com.example.sara.jobandtutionfinder;

public class PostInfo4 {
    String posth,username,dateh;

    public PostInfo4(String posth, String username, String dateh) {
        this.posth = posth;
        this.username = username;
        this.dateh = dateh;
    }

    public PostInfo4(){

    }

    public String getPosth() {
        return posth;
    }

    public void setPosth(String posth) {
        this.posth = posth;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDateh() {
        return dateh;
    }

    public void setDateh(String dateh) {
        this.dateh = dateh;
    }
}
