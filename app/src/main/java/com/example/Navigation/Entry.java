package com.example.Navigation;

public class Entry {
    String Occupation;
    String PArea;
    String Plateno;
    String Timein;

    public Entry(String Occupation, String PArea, String Plateno, String Timein ){
        this.Occupation = Occupation;
        this.PArea = PArea;
        this.Plateno = Plateno;
        this.Timein = Timein;
    }

    public String getOccupation() {
        return Occupation;
    }

    public void setOccupation(String occupation) {
        Occupation = occupation;
    }

    public String getPArea() {
        return PArea;
    }

    public void setPArea(String PArea) {
        this.PArea = PArea;
    }

    public String getPlateno() {
        return Plateno;
    }

    public void setPlateno(String plateno) {
        Plateno = plateno;
    }

    public String getTimein() {
        return Timein;
    }

    public void setTimein(String timein) {
        Timein = timein;
    }
}
