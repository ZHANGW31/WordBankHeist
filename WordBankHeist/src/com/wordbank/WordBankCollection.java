package com.wordbank;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Stream;

public class WordBankCollection {

    //fields and attributes
    private Set<String> allWords = new LinkedHashSet<>();
    private Set<String> mainWords = new LinkedHashSet<>();
    private Set<String> mediumWords = new LinkedHashSet<>();
    private Set<String> hardWords = new LinkedHashSet<>();

    private static final int EASY_WORD_MIN_LENGTH = 2;
    private static final int MEDIUM_WORD_MAX_LENGTH = 6;
    private static final int HARD_WORD_MIN_LENGTH = 7;

    public WordBankCollection() throws IOException { //No arg constructor

        try (BufferedReader reader = new BufferedReader(new FileReader("WordBank.txt"))) {
            Stream<String> line = reader.lines();
            line.forEach(allWords::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        setMainWords();
        setHardWords();
    }
    //Accessor Methods

    public Set<String> getAllWords() {
        return allWords;
    }

    public Set<String> setMainWords(){

        for (String word : allWords){
            if (word.length() >= EASY_WORD_MIN_LENGTH && word.length() <= MEDIUM_WORD_MAX_LENGTH){
                mainWords.add(word);
            }
        }
        return mainWords;
    }

    public Set<String> setHardWords(){
        for (String word : allWords){
            if (word.length() >= HARD_WORD_MIN_LENGTH){
                hardWords.add(word);
            }
        }
        return hardWords;
    }

    public Set<String> getMainWords() {
        return mainWords;
    }

    public Set<String> getHardWords() {
        return hardWords;
    }

    //Business methods

    public int longestLengthWordInSet(Set<String> inputSet){
        String longestWord;
        int result = 7;

        for (String word : inputSet){
            if (word.length() > result){
                longestWord = word;
                System.out.println("current longest word is: " + longestWord);
                result = word.length();
            }
        }

        return result;

    }







}
