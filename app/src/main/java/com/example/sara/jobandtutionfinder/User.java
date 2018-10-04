package com.example.sara.jobandtutionfinder;

public class User {
    public String name,emailid, studentid,dept,gender,level,imageUrl;

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public User(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public User(String name, String emailid, String studentid, String dept, String gender, String level, String imageUrl) {
        this.name = name;
        this.emailid = emailid;
        this.studentid = studentid;
        this.dept = dept;
        this.gender = gender;
        this.level = level;
        this.imageUrl = imageUrl;
    }
}
