package com.example.Avabilities;

public class Admin {

    final private String userName;
    final private String password;

    Admin(String userName, String password) {

        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {return userName;}
    public String getPassword() {return password;}
}
