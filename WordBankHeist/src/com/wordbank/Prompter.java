package com.wordbank;

public class Prompter {

    //The Prompter class contains commonly used Strings of messages that will get printed out to the console.

    public String nameMessage() {
        return "Please Enter Your Name: ";
    }

    public String welcomeMessage() {
        return "Good Luck, ";
    }

    public String rightAnswerMessage() {

        return "Entry accepted! Accessing funds....\n";
    }

    public String wrongAnswerMessage() {
        return "ACCESS DENIED! WARNING, THE SECURITY SYSTEM IS BEING NOTIFIED. \n";
    }

    public String endOfTryMessage() {
        return "Uh oh, looks like you got too greedy! A SWAT team breaks through your windows, GAME OVER!\n";
    }

    public String rightAnswerCashAmount(int cashReward) {
        return "You have received: $" + cashReward + " worth of intCoin. Extracting funds...\n";
    }
    public String wrongAnswerTryTokenConsumed(int remainingTokens){
        return "HackAssistAI: Injected token. Token consumed by the security system. Token accepted, alarms deactivated. Number of Token(s) remaining : " + remainingTokens + "\n";
    }

    public String cashOutMessage(int currentFunds, int currentTryTokens){
        return "|HackAssistAI: Current Amount Hacked : [$" + currentFunds + "] RetryToken(s): ["+ currentTryTokens+ "]";
    }
    public String continueMessage(){
        return "HackAssistAI: accessing systems...\n";
    }

    public String beginningMessage(){
        return "Loading software....\nWould you like to view the objective and rules? Please press <Y> for yes or <N> for no and enter...\n";
    }

    public String cashOutMessagesWinnings[] = {
            "Command accepted.",
            "Transferring funds to your intWallet.",
            "Transaction Successful!"};

    public String cashOutWinMessageFour(int totalWon){
        return "You've received: $" + totalWon + " worth of intCoin!";
    }

    public String cashOutOptionMessage(){
        return "Would you like to cash out? Press 'Y' for yes or 'N' for no to continue hacking.";
    }


}