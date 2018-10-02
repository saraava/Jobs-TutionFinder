package com.example.sara.jobandtutionfinder;

public class PostInformation1 {
    String post,username,time;


    public PostInformation1(String post, String username,String time) {
        this.post = post;
        this.username = username;
        this.time=time;
    }

    public PostInformation1() {
    }

    public String getPost() {
        return post;
    }

    public String getUsername() { return username; }

    public void setPost(String post) {
        this.post = post;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
