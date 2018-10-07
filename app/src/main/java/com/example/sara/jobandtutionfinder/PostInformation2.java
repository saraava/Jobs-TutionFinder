package com.example.sara.jobandtutionfinder;

public class PostInformation2 {

    String cpost,username,cdate;

    public PostInformation2(String cpost, String username, String cdate) {
        this.cpost = cpost;
        this.username = username;
        this.cdate = cdate;
    }
    public PostInformation2(){

    }

    public String getCpost() {
        return cpost;
    }

    public void setCpost(String cpost) {
        this.cpost = cpost;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCdate() {
        return cdate;
    }

    public void setCdate(String cdate) {
        this.cdate = cdate;
    }
}
