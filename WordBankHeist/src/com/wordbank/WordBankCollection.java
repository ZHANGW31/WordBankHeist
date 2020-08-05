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

    private static final int EASY_WORD_MIN_LENGTH = 2;
    private static final int MEDIUM_WORD_MAX_LENGTH = 6;

    public WordBankCollection() throws IOException { //No arg constructor

        try (BufferedReader reader = new BufferedReader(new FileReader("WordBank.txt"))) {
            Stream<String> line = reader.lines();
            line.forEach(allWords::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        setMainWords();
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

    public Set<String> getMainWords() {
        return mainWords;
    }
}
