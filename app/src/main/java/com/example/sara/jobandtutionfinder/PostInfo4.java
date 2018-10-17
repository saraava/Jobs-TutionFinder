package com.example.sara.jobandtutionfinder;

public class PostInfo4 {
    public String uid, time, date, description, profileimage, fullname,postID;

    public PostInfo4() {
    }

    public String getUid() {
        return uid;
    }

    public String getPostID() {
        return postID;
    }

    public void setPostID(String postID) {
        this.postID = postID;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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

    public PostInfo4(String uid, String time, String date, String description, String profileimage, String fullname, String postID) {
        this.uid = uid;
        this.time = time;
        this.date = date;
        this.description = description;
        this.profileimage = profileimage;
        this.fullname = fullname;
        this.postID = postID;
    }
}
