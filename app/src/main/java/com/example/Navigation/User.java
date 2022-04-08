package com.example.Navigation;

public class User {
    String FullName;
    String EmailAddress;
    String Plateno;

    public User(String FullName, String EmailAddress, String Plateno){
        this.FullName = FullName;
        this.EmailAddress= EmailAddress;
        this.Plateno = Plateno;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getEmailAddress() {
        return EmailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        EmailAddress = emailAddress;
    }

    public String getPlateno() {
        return Plateno;
    }

    public void setPlateno(String plateno) {
        Plateno = plateno;
    }

}
