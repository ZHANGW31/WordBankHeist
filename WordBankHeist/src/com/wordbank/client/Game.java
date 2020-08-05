package com.wordbank.client;

import com.wordbank.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;



public class Game {

    QuestionFactory questionFactory = new QuestionFactory(); //

    WordBankCollection wordBankCollection = new WordBankCollection();// instance of wordBankCollection
    private Level level; // instance of Level enum
    Player player = new Player(); // creating new instance of player

    Prompter prompter = new Prompter();
    Scanner scanner = new Scanner(System.in);

    public Game() throws IOException {
    }


    public void start() {


        //This block of code reads and println out the Welcome_Banner.txt file.
        try (BufferedReader reader = new BufferedReader(new FileReader("Welcome_Banner.txt"))) {
            Stream<String> line = reader.lines();
            line.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Ask for name, create player object and then set the player name
        System.out.println(prompter.nameMessage());
        String name = scanner.nextLine();

        //Player setup
        player.setName(name);
        int playerLives = player.getCurrentLives();


        System.out.println(prompter.welcomeMessage() + name + "\n" + prompter.beginningMessage());

        //Todo create the rules and objectives.



        while(playerLives > 0){

            //Game logic starts here
            String word = questionFactory.getRandomWord(wordBankCollection.getMainWords());
            Set<String> answerKey = questionFactory.answerKey(word.length(),word.charAt(0),wordBankCollection.getMainWords());
            System.out.println(questionFactory.questionGenerator(word));
            String playerAnswer = scanner.nextLine();
            if (answerKey.contains(playerAnswer)){
                System.out.println(prompter.rightAnswerMessage() + prompter.rightAnswerCashAmount(100));
            } else {

                System.out.println(prompter.wrongAnswerMessage());
                playerLives--;
            }
            if (playerLives == 0){
                System.out.println(prompter.endOfTryMessage());
            }
        }
    }

/*
    public void askQuestion () throws IOException {
        String lvl = null;
        int balance = 0;
        Scanner scanner = new Scanner(System.in);
        String userInput = " ";
        System.out.println(prompter.selectLevel());
        lvl = scanner.nextLine().toUpperCase();
        int randomNumberStore;
        int cashEarned = 0;
        int cashOutBalance=0;

        List<String> easyWords = new LinkedList<>();
        easyWords.addAll(wordBankCollection.getEasyWords());

        List<String> mediumWords = new LinkedList<>();
        mediumWords.addAll(wordBankCollection.getMediumWords());

        List<String> hardWords = new LinkedList<>();
        hardWords.addAll(wordBankCollection.getHardWords());

        int lives = 3;

        do {

            if (lvl.equals(level.EASY.getValue()) && lives > 0) {
                questionFactory.generateQuestion();
                userInput = scanner.nextLine();
                if (easyWords.contains(userInput)) {
                    System.out.println(prompter.rightAnswerMessage());

                    cashEarned= player.cashEarned(userInput);
                    System.out.println(prompter.rightAnswerCashAmount(cashEarned));
                    ;
                } else {
                    System.out.println(prompter.wrongAnswerMessage());
                    lives-=1;
                }
            }


            if (lvl.equals(level.MEDIUM.getValue()) && lives > 0) {
                questionFactory.generateQuestion();
                userInput= scanner.nextLine();
                if(mediumWords.contains(userInput)){
                    System.out.println(prompter.rightAnswerMessage());
                    cashEarned=player.cashEarned(userInput);
                    System.out.println(prompter.rightAnswerCashAmount(cashEarned));
                    cashOutBalance = cashEarned;
                    System.out.println(prompter.cashOutBalanceMessage(cashOutBalance));
                }else{
                    System.out.println(prompter.wrongAnswerMessage());
                    lives-=1;
                }
            }
            if (lvl.equals(level.HARD.getValue()) && lives > 0) {
                questionFactory.generateQuestion();
                userInput = scanner.nextLine();
                if(hardWords.contains(userInput)){
                    System.out.println(prompter.rightAnswerMessage());
                    cashEarned =player.cashEarned(userInput);
                    System.out.println(prompter.rightAnswerCashAmount(cashEarned));
                    cashOutBalance+=cashEarned;
                    System.out.println(prompter.cashOutBalanceMessage(cashOutBalance));
                }
            }
        } while (lives <= 0);

    }*/
    //System.out.println(prompter.endOfTryMessage());

        /*
        if(lvl.equals(level.EASY.getValue())) {
                questionFactory.generateEasyQuestion();
                userInput = scanner.nextLine().toLowerCase();
                if(easyWords.contains(userInput)){
                    System.out.println(prompter.rightAnswerMessage());
                    cashOutBalance=player.cashEarned(userInput);
                    System.out.println(" Enter to Continue");
                    System.out.println();
                    questionFactory.generateEasyQuestion();
                    userInput=scanner.nextLine().toLowerCase();
                    if(easyWords.contains(userInput)){
                        System.out.println(prompter.rightAnswerMessage());
                        cashOutBalance +=player.cashEarned(userInput);
                        System.out.println(prompter.rightAnswerCashAmount(cashOutBalance));
                    }else{
                        System.out.println(prompter.wrongAnswerMessage());
                        userInput= scanner.nextLine();
                        if(easyWords.contains(userInput)){
                            System.out.println(prompter.rightAnswerMessage());
                        }
                    }
                }else {
                    System.out.println(prompter.wrongAnswerMessage());
                    lives =lives-1;
                    userInput= scanner.nextLine().toLowerCase();
                    if(wordBankCollection.getEasyWords().contains(userInput)){
                        System.out.println(prompter.rightAnswerMessage());
                        cashOutBalance = player.cashEarned(userInput);
                    }
                }
        }  if((lvl.equals(level.MEDIUM.getValue())) && lives >0) {
             questionFactory.generateMediumQuestion();
             userInput= scanner.nextLine().toLowerCase();
             if(wordBankCollection.getMediumWords().contains(userInput)){
                 System.out.println(prompter.rightAnswerMessage());
                 cashOutBalance = player.cashEarned(userInput);
             }else{
                 System.out.println(prompter.wrongAnswerMessage());
                 lives-=1;
                 userInput = scanner.nextLine().toLowerCase();
                 if(wordBankCollection.getMediumWords().contains(userInput)){
                     System.out.println(prompter.rightAnswerMessage());
                     cashOutBalance = player.cashEarned(userInput);
                 }
             }
        }  if((lvl.equals(level.HARD.getValue())) && lives>0) {
            userInput = scanner.nextLine().toLowerCase();
            if(wordBankCollection.getHardWords().contains(userInput)){
                System.out.println(prompter.rightAnswerMessage());
                System.out.println(prompter.rightAnswerCashAmount(player.cashEarned(userInput)));
            }else{
                System.out.println(prompter.wrongAnswerMessage());
                userInput =scanner.nextLine().toLowerCase();
                if(wordBankCollection.getHardWords().contains(userInput)){
                    System.out.println(prompter.rightAnswerMessage());
                    System.out.println(prompter.rightAnswerCashAmount(player.cashEarned(userInput)));
                }else{
                    System.out.println(prompter.endOfTryMessage());
                }
            }
        }
    }
    */



    // Main method
    public static void main (String[]args) throws IOException
    { // this IO exception needs to be removed, it is only for
        // getting compile error away.

        Game game = new Game();
        game.start();
        /*game.askQuestion();*/

    }

}