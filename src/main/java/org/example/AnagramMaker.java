package org.example;

import java.util.Arrays;

public class AnagramMaker {
    public String make(String word){

        if (word == null || word.isEmpty()) {
            return "";
        }

        char[] chars = word.toCharArray();

        int firstIndex = 0;
        int lastIndex = chars.length - 1;

        while (firstIndex<lastIndex){
            if (checkEnglishLetter(chars[firstIndex])){
                if (checkEnglishLetter(chars[lastIndex])){

                    char swap = chars[firstIndex];
                    chars[firstIndex] = chars[lastIndex];
                    chars[lastIndex] = swap;

                    firstIndex++;
                    lastIndex--;

                } else {
                    lastIndex--;
                }
            } else {
                firstIndex++;
            }
        }

        return new String(chars);
    }

    private boolean checkEnglishLetter(char value){

        if ((value > 64 && value < 91) || (value > 96 && value < 123)){
            return true;
        }
        return false;
    }
}