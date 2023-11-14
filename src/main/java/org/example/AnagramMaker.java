package org.example;

import java.util.Arrays;
import java.util.stream.Collectors;

public class AnagramMaker {
    public String getAnagram(String line){
        if(line == null || line.isEmpty()){
            return "";
        }

        String anagramLine = Arrays.stream(line.split("\\s+")).map(this::make).collect(Collectors.joining(" "));

        return anagramLine;
    }

    private String make(String word){
        if(word == null || word.isEmpty()) {
            return "";
        }

        String anagram = "";

        int lastIndex = word.length()-1;

        for(int firstIndex = 0; firstIndex < word.length(); firstIndex++){
            if(!checkEnglishLetter(word.charAt(firstIndex))){
                anagram+=word.charAt(firstIndex);
                continue;
            }
            for (; lastIndex>-1;lastIndex--){
                if(checkEnglishLetter(word.charAt(lastIndex))){
                    anagram += word.charAt(lastIndex);
                    lastIndex--;
                    break;
                }
            }
        }

        return anagram;
    }

    private boolean checkEnglishLetter(char value){
        if((value > 64 && value < 91) || (value > 96 && value < 123)){
            return true;
        }
        return false;
    }
}