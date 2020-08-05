package com.wordbank;

public class Prompts {

    //The Prompts class contains commonly used Strings of messages that will get printed out to the console.

    public static String name() {
        return "Please Enter Your Name: ";
    }

    public static String welcome() {
        return "Good Luck, ";
    }

    public static String rightAnswer() {

        return "Entry accepted! Accessing funds....\n";
    }

    public static String wrongAnswer() {
        return "ACCESS DENIED! WARNING, THE SECURITY SYSTEM IS BEING NOTIFIED. \n";
    }

    public static String gameOver() {
        return "Uh oh, looks like you got too greedy! A SWAT team breaks through your windows, GAME OVER!\n";
    }

    public static String amountWon(int cashReward) {
        return "You have received: $" + cashReward + " worth of intCoin. Extracting funds...\n";
    }
    public static String retryTokenConsumed(int remainingTokens){
        return "HackAssistAI: Injected token. Token consumed by the security system. Token accepted, alarms deactivated. Number of Token(s) remaining : " + remainingTokens + "\n";
    }

    public static String status(int currentFunds, int currentTryTokens){
        return "|HackAssistAI: Current Amount Hacked : [$" + currentFunds + "] RetryToken(s): ["+ currentTryTokens+ "]";
    }
    public static String nextStep(){
        return "HackAssistAI: accessing systems...\n";
    }

    public static String begin(){
        return "Loading software....\nWould you like to view the objective and rules? Please press <Y> for yes or <N> for no and enter...\n";
    }

    public static String cashOutMessagesWinnings[] = {
            "Command accepted.",
            "Transferring funds to your intWallet.",
            "Transaction Successful!"};

    public static String endGameWin(int totalWon){
        return "You've received: $" + totalWon + " worth of intCoin!";
    }

    public static String cashOutOptionMessage(){
        return "Would you like to cash out? Press 'Y' for yes or 'N' for no to continue hacking.";
    }


}