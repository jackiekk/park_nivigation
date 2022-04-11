package com.example.Navigation;

public class User {
    public String FullName;
    public String EmailAddress;
    public String Plateno;
    public String Phone;

    public User(String FullName, String EmailAddress, String Plateno, String Phone){
        this.FullName = FullName;
        this.EmailAddress= EmailAddress;
        this.Plateno = Plateno;
        this.Phone = Phone;
    }
    public User(){

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

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

}
