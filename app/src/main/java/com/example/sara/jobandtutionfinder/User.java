package com.example.sara.jobandtutionfinder;

public class User {
    public String name, email, studentid;

    public User(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public User(String name, String email, String studentid) {
        this.name = name;
        this.email = email;
        this.studentid = studentid;




    }
}
