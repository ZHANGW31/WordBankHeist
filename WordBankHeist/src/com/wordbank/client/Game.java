package com.wordbank.client;

import com.wordbank.Player;
import com.wordbank.Prompts;
import com.wordbank.QuestionFactory;
import com.wordbank.WordBankCollection;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.Set;


public class Game {

    QuestionFactory questionFactory = new QuestionFactory(); //

    WordBankCollection wordBankCollection = new WordBankCollection();// instance of wordBankCollection
    Player player = new Player(); // creating new instance of player

    Prompts prompts = new Prompts();
    Scanner scanner = new Scanner(System.in);

    public Game() throws IOException {
    }

    public void start() throws InterruptedException, IOException {

        showBanner();//This method reads from the data folder a text document that contains the banner and displays it to the user.

        //Ask for name, create player object and then set the player name
        String name = getPlayerName();

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

        showRules(name); //If the user decides that they want to see the rules and objectives, this method handles whether to display the rules or continue.

        Thread.sleep(2000);
        System.out.println("HackAssistAI: Initializing hack...injecting package... loading... success!");
        Thread.sleep(2000);

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
            System.out.println(prompts.status(playerCash,playerLives));

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
                System.out.println(prompts.rightAnswer() + prompts.amountWon(awardedCash));
                Thread.sleep(1500);

            } else { //If the user's answer is incorrect.

                System.out.println(prompts.wrongAnswer());
                Thread.sleep(1000);
                consecutiveCorrectAnswers = 0;
                playerLives--;
                answeredWrong++;
            }
            if (answeredWrong > playerStartingLife){
                consecutiveCorrectAnswers = 0;
                System.out.println(prompts.gameOver());
                Thread.sleep(1000);
                break;
            }

            //Options to cash out Phase
            System.out.println(prompts.retryTokenConsumed(playerLives));
            Thread.sleep(1000);
            System.out.println(prompts.cashOutOptionMessage());
            String playerChoice = scanner.nextLine().toLowerCase();
                if (playerChoice.equals("cashout")){
                    cashOut = true;
                    break;
                }
            System.out.println(prompts.nextStep());
            Thread.sleep(1500);

        }

        if (cashOut){
            for (int i = 0; i < prompts.cashOutMessagesWinnings.length; i++){
                Thread.sleep(1500);
                System.out.println(prompts.cashOutMessagesWinnings[i]);
            }
            System.out.println(prompts.endGameWin(playerCash));
        }
        System.out.println("Thank you for playing! - From the JavaNinjas");

    }

    private String getPlayerName() {
        System.out.println(prompts.name());
        String name = scanner.nextLine();
        if (name.isEmpty() | name.isBlank()){
            getPlayerName();
        }
        return name;
    }

    private void showRules(String name) throws IOException {
        System.out.println(prompts.begin());
        String viewTheRules = scanner.nextLine().toLowerCase();
        if (viewTheRules.equals("y")){
            Files.lines(Path.of("data","Rules of the Game.txt")).forEach(line -> {
                System.out.println(line);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        } else if (!viewTheRules.equals("y") && !viewTheRules.equals("n")){

            System.out.println("Please enter Y or N");
            showRules(name);
        }
    }

    private void showBanner() throws IOException {
        Files.lines(Path.of("data","Welcome_Banner.txt")).forEach(line -> {
            System.out.println(line);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    // Main method
    public static void main (String[]args) throws IOException, InterruptedException { // this IO exception needs to be removed, it is only for
        // getting compile error away.

        Game game = new Game();
        game.start();

    }
}