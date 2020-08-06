package com.wordbank;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashSet;
import java.util.Set;

public class WordBankCollection {

    //fields and attributes
    private Set<String> allWords = new LinkedHashSet<>();
    private Set<String> mainWords = new LinkedHashSet<>();

    private static final int EASY_WORD_MIN_LENGTH = 2;
    private static final int MEDIUM_WORD_MAX_LENGTH = 7;

    public WordBankCollection() throws IOException { //No arg constructor

        Files.lines(Path.of("data", "WordBank.txt")).forEach(word -> allWords.add(word));
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
