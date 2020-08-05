package com.wordbank;

// Enum class
public enum Level {
    EASY("EASY"), MEDIUM("MEDIUM"), HARD("HARD");

    private String value;

    Level(String value){

        this.value =value;
    }

    public String getValue(){

        return value;
    }

}