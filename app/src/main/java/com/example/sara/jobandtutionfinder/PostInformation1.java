package com.example.sara.jobandtutionfinder;

public class PostInformation1 {
    public String uid, time, date, description, profileimage, fullname,postID,studentidd;

    public PostInformation1(String uid, String time, String date, String description, String profileimage, String fullname, String postID, String studentidd) {
        this.uid = uid;
        this.time = time;
        this.date = date;
        this.description = description;
        this.profileimage = profileimage;
        this.fullname = fullname;
        this.postID = postID;
        this.studentidd = studentidd;
    }

    public String getPostID() {
        return postID;
    }

    public void setPostID(String postID) {
        this.postID = postID;
    }

    public String getStudentidd() {
        return studentidd;
    }

    public void setStudentidd(String studentidd) {
        this.studentidd = studentidd;
    }

    public PostInformation1() {
    }

    public String getTime() {
        return time;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProfileimage() {
        return profileimage;
    }

    public void setProfileimage(String profileimage) {
        this.profileimage = profileimage;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setTime(String time) {
        this.time = time;
    }


}
