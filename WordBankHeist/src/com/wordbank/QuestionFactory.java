package com.wordbank;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;


public class QuestionFactory {

    public QuestionFactory() {
    }

    public Set<String> answerKey(int length, char firstCharacter, Set<String> inputSet){

        int counter = 0;

        Set<String> resultSet = new LinkedHashSet<>();

        for (String word: inputSet) {
            if (word.charAt(0) == firstCharacter && word.length() == length){
                counter++;
                resultSet.add(word);

            }
        }
        System.out.println("HackAssistAI: My scans are showing that there are " + counter + " possible passcodes.\n==================================================================================================================================");
        return resultSet;
    }

    public String questionGenerator(String randomWord){
        return "\nHackAssistAI: The system is asking for a word that starts with the character: " + randomWord.charAt(0) + " and is the length of: " + randomWord.length() + " characters.";
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
}