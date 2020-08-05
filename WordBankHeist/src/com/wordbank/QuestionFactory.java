package com.wordbank;

import java.io.IOException;
import java.util.*;


public class QuestionFactory {

    // instances
    private char firstLetter;

    private String question= " Word that starts with:";
    private String wordLength;


    private Level level;

    private String lvl;
    WordBankCollection wordBankCollection = new WordBankCollection();

    public QuestionFactory() throws IOException {
    }


//    public int getRandomNumber(int min, int max){
//        int i;
//
//        Random random = new Random();
//        int randomNumber =  random.nextInt((max-min)+1)+min;
//
//
//        return randomNumber;
//    }

    public Set<String> answerKey(int length, char firstCharacter, Set<String> inputSet){

        int counter = 0;

        Set<String> resultSet = new LinkedHashSet<>();

        for (String word: inputSet) {
            if (word.charAt(0) == firstCharacter && word.length() == length){
                counter++;
                resultSet.add(word);

            }
        }
        System.out.println("HackAssistAI: My scans are showing that there are " + counter + " possible passcodes.\n==================================================================================================================================\n");
        return resultSet;
    }

    public void generateQuestion() {
        String question;
        String randomWord;
        int rand;
        List<String> questionsToBeAsked = new LinkedList<>();
        questionsToBeAsked.addAll(wordBankCollection.getMainWords());
        Collections.sort(questionsToBeAsked);
        Random random = new Random();
        rand = random.nextInt((questionsToBeAsked.size()-1)+1)+1;
        randomWord = questionsToBeAsked.get(rand);
        question = " The word starting with: "+ randomWord.charAt(0)+ ". The word has "+ randomWord.length() + " characters.";
        System.out.println(question);

    }



    public String questionGenerator(String randomWord){
        return "The system is asking for a word that starts with the character: " + randomWord.charAt(0) + " and is the length of: " + randomWord.length() + " characters.";
    }



    public static String getRandomWord(Set<String> set){
        Random random = new Random();
        int randomNum = random.nextInt(set.size());
        int currentIndex = 0;
        for(String word : set){
            if (currentIndex == randomNum){
                return word;
            }
            currentIndex++;
        }
        return null;
    }



//    //
//    public void generateEasyQuestion(){
//
//        String question= " ";
//        String randomWord;
//        int rand;
//        List<String> easyQuestion = new LinkedList<>(); // creating new Linkedlist easyQuestion
//        easyQuestion.addAll(wordBankCollection.getEasyWords()); // adding all easy words to easyQuestion LinkedList
//        Collections.sort(easyQuestion); // sorting the list
//        Random random = new Random();
//        rand = random.nextInt((easyQuestion.size()-1)+1)+1; // gets random integer based on size of
//        randomWord = easyQuestion.get(rand);
//        question = " The word starting with: " + randomWord.charAt(0)+". The word has "+ randomWord.length()+ " character.";
//        System.out.println(question);
//    }
//
//    public void generateMediumQuestion(){
//
//        String question= null;
//        String randomWord = null;
//        int rand;
//        List<String> mediumQuestion = new LinkedList<>();
//        mediumQuestion.addAll(wordBankCollection.getMediumWords()); // adds all medium words to the LinkedList
//        Collections.sort(mediumQuestion); // sorts the Linkedlist
//        Random random = new Random(); // instantiating Random Method
//        rand = random.nextInt((mediumQuestion.size()-1)+1)+1;
//        randomWord = mediumQuestion.get(rand);
//        question = " The word starting with: " + randomWord.charAt(0)+ ". The word has "+ randomWord.length() + " characters.";
//        System.out.println(question);
//    }
//
//    public void generateHardQuestion(){
//
//        String question = null;
//        String randomWord = null;
//        int rand;
//        List<String> hardQuestion = new LinkedList<>(); // create new LinkedList
//        hardQuestion.addAll(wordBankCollection.getHardWords()); // adds all hardWords to the LinkedList
//        Collections.sort(hardQuestion); // sorts the Linkedlist
//        Random random = new Random(); // instantiating Random Method
//        rand = random.nextInt((hardQuestion.size()-1)+1)+1;
//        randomWord = hardQuestion.get(rand);
//        question = " The word starting with: "+ randomWord.charAt(0) + ". The word has " + randomWord.length() +" characters.";
//        System.out.println(question);
//
//    }




    public boolean validateQuestion(int length, char firstCharacter, Set<String> inputSet){
        int counter = 0;
        boolean result = false;

        for (String word: inputSet) {
            if (word.charAt(0) == firstCharacter && word.length() == length){
                counter++;
            }
        }
        if (counter > 0){
            result = false;
        } else {
            result = true;
        }

        return result;
    }


    public String getQuestion() {
        return question;
    }

    //TODO:
    public void setQuestion(String question) {

        this.question = question;
    }
    public Level getLevel() {
        return level;
    }



}