package com.wordbank.test;

import com.wordbank.Prompts;
import com.wordbank.WordBankCollection;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class WordBankCollectionTest {

/*    public static void main(String[] args) throws IOException {

        //Please dont remove those sysouts for the meantime!
        WordBankCollection wordBank = new WordBankCollection();
        System.out.println(wordBank.getEasyWords().size());
        System.out.println(wordBank.getMediumWords().size());
        System.out.println(wordBank.getHardWords().size());
        System.out.println("Total number of words: " + wordBank.getAllWords().size());
        System.out.println(wordBank.longestLengthWordInSet(wordBank.getHardWords()));

    }*/
    public void generateMediumQuestion() throws IOException {

        String question= null;
        String randomWord = null;
        int rand;
        List<String> mediumQuestion = new LinkedList<>();
        WordBankCollection wordBankCollection = new WordBankCollection();
//        mediumQuestion.addAll(wordBankCollection.getMediumWords()); // adds all medium words to the LinkedList
        Collections.sort(mediumQuestion); // sorts the Linkedlist
        Random random = new Random(); // instantiating Random Method
        rand = random.nextInt((mediumQuestion.size()-1)+1);
        randomWord = mediumQuestion.get(rand);
        question = " The word starting with: " + randomWord.charAt(0)+ ". The word has "+ randomWord.length() + " characters.";
        System.out.println(question);
    }

    //    public void generateQuestion(){
//
//    }
    public static void main(String[] args) throws IOException {
        WordBankCollection wordBank = new WordBankCollection();
        Prompts prompter= new Prompts();


        WordBankCollectionTest wordBankCollectionTest = new WordBankCollectionTest();
        wordBankCollectionTest.generateMediumQuestion();
    }


}