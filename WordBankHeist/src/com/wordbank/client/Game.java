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
    Player player = new Player(); // creating new instance of player

    Prompter prompter = new Prompter();
    Scanner scanner = new Scanner(System.in);

    public Game() throws IOException {
    }


    public void start() throws InterruptedException {


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
        int playerCash = player.getCash();
        int awardedCash;
        int answeredWrong = 0;
        int playerStartingLife = player.getCurrentLives();
        int consecutiveCorrectAnswers = 0;
        boolean cashOut = false;

        //WordBank MainWords Setup
        Set<String> mainWords = wordBankCollection.getMainWords();

        System.out.println(prompter.welcomeMessage() + name + "\n" + prompter.beginningMessage());
        String viewTheRules = scanner.nextLine().toLowerCase();
        if (viewTheRules.equals("y")){
            try (BufferedReader reader = new BufferedReader(new FileReader("Rules of the Game.txt"))) {
                Stream<String> line = reader.lines();
                line.forEach(System.out::println);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Thread.sleep(2000);
        System.out.println("HackAssistAI: Initializing hack...injecting package... loading... success!");
        Thread.sleep(2000);

        //Todo create the rules and objectives.

        while(playerLives >= 0){

            //Game logic starts here
            String word = questionFactory.getRandomWord(mainWords);
            Set<String> answerKey = questionFactory.answerKey(word.length(),word.charAt(0),mainWords);
            Thread.sleep(2000);
            //Beginning Phase

            if (consecutiveCorrectAnswers == 5){
                playerLives += 1;
                consecutiveCorrectAnswers = 0;
            }
            System.out.println(prompter.cashOutMessage(playerCash,playerLives));


            //Question Phase
            Thread.sleep(2000);
            System.out.println(questionFactory.questionGenerator(word));



            //User Answer Phase
            String playerAnswer = scanner.nextLine().toLowerCase();
            if (answerKey.contains(playerAnswer)){ //If the user's answer is correct
                mainWords.remove(playerAnswer);
                awardedCash = 100 * playerAnswer.length();
                playerCash += awardedCash;
                consecutiveCorrectAnswers++;
                System.out.println(prompter.rightAnswerMessage() + prompter.rightAnswerCashAmount(awardedCash));
                Thread.sleep(1500);

            } else { //If the user's answer is incorrect.

                System.out.println(prompter.wrongAnswerMessage());
                Thread.sleep(1000);
                consecutiveCorrectAnswers = 0;
                playerLives--;
                answeredWrong++;
            }
            if (answeredWrong > playerStartingLife){
                consecutiveCorrectAnswers = 0;
                System.out.println(prompter.endOfTryMessage());
                Thread.sleep(1000);
                break;
            }

            //Options to cash out Phase
            System.out.println(prompter.wrongAnswerTryTokenConsumed(playerLives));
            Thread.sleep(1000);
            System.out.println(prompter.cashOutOptionMessage());
            String playerChoice = scanner.nextLine().toLowerCase();
                if (playerChoice.equals("y")){
                    cashOut = true;
                    break;
                } else if (playerChoice.equals("n")){

                    System.out.println(prompter.continueMessage());
                    Thread.sleep(1500);
                }

        }

        if (cashOut == true){
            for (int i = 0; i < prompter.cashOutMessagesWinnings.length; i++){
                Thread.sleep(1500);
                System.out.println(prompter.cashOutMessagesWinnings[i]);
            }
            System.out.println(prompter.cashOutWinMessageFour(playerCash));
        }
        System.out.println("Thank you for playing! - From the JavaNinjas");

    }
    // Main method
    public static void main (String[]args) throws IOException, InterruptedException { // this IO exception needs to be removed, it is only for
        // getting compile error away.

        Game game = new Game();
        game.start();

    }

}