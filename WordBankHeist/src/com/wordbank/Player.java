package com.wordbank;

public class Player {

    // INSTANCE VARIABLES - Fields, aka, Properties

    private String name;
    private int cash = 0; // current score
    private int currentLives = 3; // player starts with current live


    // CONSTRUCTORS

    public Player() {
        // no - arg constructor
    }

    public Player(String name) {

        setName(name);
    }

    public Player(String name, int cash) {
        this(name);
        setCash(cash);
    }

    public Player(String name, int cash, int currentLives) {
        this(name, cash);
        setCurrentLives(currentLives);
    }


    // ACCESSORS METHOD

    public void setName(String name) {

        this.name = name;
    }

    public int getCash() {

        return cash;
    }

    public void setCash(int cash) {

        this.cash = cash;
    }

    public int getCurrentLives() {

        return currentLives;
    }

    public void setCurrentLives(int currentLives) {

        this.currentLives = currentLives;
    }
}