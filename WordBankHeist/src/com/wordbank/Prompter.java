package com.wordbank;

public class Prompter {

    public String nameMessage() {
        return "Please Enter Your Name: ";
    }

    public String welcomeMessage() {
        return "Good Luck! \n";
    }

    public String rightAnswerMessage() {

        return "Entry accepted! Accessing funds....\n";
    }

    public String wrongAnswerMessage() {
        return "Access denied... Please Try Again... -The computer is getting suspicious of you- \n";
    }

    public String endOfTryMessage() {
        return "Uh oh, looks like you got too greedy! A SWAT team breaks through your windows, GAME OVER!\n";
    }

    public String rightAnswerCashAmount(int cashReward) {
        return "You have received: $" + cashReward + " worth of intCoin. Depositing in your digital wallet now.\n";
    }

    public String cashOutBalanceMessage(int cashOut){
        return "Your cash out balance is: $"+ cashOut;
    }

    public String beginningMessage(){
        return "Loading software....\nWould you like to view the objective and rules? Please press <Y> for yes or <N> for no and enter...\n";
    }



}