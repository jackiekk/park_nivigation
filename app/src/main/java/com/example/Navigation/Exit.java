package com.example.Navigation;

public class Exit {
    String Plateno;
    String Timeout;

    public Exit(String Plateno, String Timeout ){
        this.Plateno = Plateno;
        this.Timeout = Timeout;
    }

    public String getPlateno() {
        return Plateno;
    }

    public void setPlateno(String plateno) {
        Plateno = plateno;
    }

    public String getTimeout() {
        return Timeout;
    }

    public void setTimeout(String timeout) {
        Timeout = timeout;
    }
}
