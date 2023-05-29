package com.example.myapplication.Datasets;

public class TeamsSquad {

    String Name_Full;
    String key1;
    String Position;
    String NameFull;
    String Iscaptain;
    String Iskeeper;

    String Stylebat;
    String Averagebat;
    String Strikeratebat;
    String Runsbat;

    String Stylebowl;
    String Averagebowl;
    String Economyrate;
    String Wickets ;

    public String getName_Full() {
        return Name_Full;
    }

    public void setName_Full(String name_Full) {
        Name_Full = name_Full;
    }

    public String getKey1() {
        return key1;
    }

    public void setKey1(String key1) {
        this.key1 = key1;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public String getNameFull() {
        return NameFull;
    }

    public void setNameFull(String nameFull) {
        NameFull = nameFull;
    }

    public String getIscaptain() {
        return Iscaptain;
    }

    public void setIscaptain(String iscaptain) {
        Iscaptain = iscaptain;
    }

    public String getIskeeper() {
        return Iskeeper;
    }

    public void setIskeeper(String iskeeper) {
        Iskeeper = iskeeper;
    }

    public String getStylebat() {
        return Stylebat;
    }

    public void setStylebat(String stylebat) {
        Stylebat = stylebat;
    }

    public String getAveragebat() {
        return Averagebat;
    }

    public void setAveragebat(String averagebat) {
        Averagebat = averagebat;
    }

    public String getStrikeratebat() {
        return Strikeratebat;
    }

    public void setStrikeratebat(String strikeratebat) {
        Strikeratebat = strikeratebat;
    }

    public String getRunsbat() {
        return Runsbat;
    }

    public void setRunsbat(String runsbat) {
        Runsbat = runsbat;
    }

    public String getStylebowl() {
        return Stylebowl;
    }

    public void setStylebowl(String stylebowl) {
        Stylebowl = stylebowl;
    }

    public String getAveragebowl() {
        return Averagebowl;
    }

    public void setAveragebowl(String averagebowl) {
        Averagebowl = averagebowl;
    }

    public String getEconomyrate() {
        return Economyrate;
    }

    public void setEconomyrate(String economyrate) {
        Economyrate = economyrate;
    }

    public String getWickets() {
        return Wickets;
    }

    public void setWickets(String wickets) {
        Wickets = wickets;
    }

    public TeamsSquad(String name_Full, String key1, String position, String nameFull, String iscaptain, String iskeeper, String stylebat, String averagebat, String strikeratebat, String runsbat, String stylebowl, String averagebowl, String economyrate, String wickets) {
        Name_Full = name_Full;
        this.key1 = key1;
        Position = position;
        NameFull = nameFull;
        Iscaptain = iscaptain;
        Iskeeper = iskeeper;
        Stylebat = stylebat;
        Averagebat = averagebat;
        Strikeratebat = strikeratebat;
        Runsbat = runsbat;
        Stylebowl = stylebowl;
        Averagebowl = averagebowl;
        Economyrate = economyrate;
        Wickets = wickets;
    }
}
