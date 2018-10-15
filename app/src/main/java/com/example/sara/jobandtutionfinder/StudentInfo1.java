package com.example.sara.jobandtutionfinder;

public class StudentInfo1 {
    String postp,username,datep;

    public StudentInfo1(String postp, String username, String datep) {
        this.postp = postp;
        this.username = username;
        this.datep = datep;
    }

    public StudentInfo1(){

    }

    public String getPostp() {
        return postp;
    }

    public void setPostp(String postp) {
        this.postp = postp;
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

    public void setDatep(String datep) {
        this.datep = datep;
    }
}
