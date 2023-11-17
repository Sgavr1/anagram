package org.example;

public class AnagramMaker {
    public String make(String text){

        if (text == null) {
            throw new IllegalArgumentException("Value is null");
        }

        StringBuilder anagramLine = new StringBuilder();

        for (String word : text.split("\\s+")) {

            char[] chars = word.toCharArray();

            int firstIndex = 0;
            int lastIndex = chars.length - 1;

            while (firstIndex < lastIndex){

                char firstChar = chars[firstIndex];
                char lastChar = chars[lastIndex];

                boolean firstIsLetter = isEnglishLetter(firstChar);
                boolean lastIsLetter = isEnglishLetter(lastChar);

                if (firstIsLetter && lastIsLetter){
                    chars[firstIndex] = lastChar;
                    chars[lastIndex] = firstChar;

                    firstIndex++;
                    lastIndex--;

                } else if (firstIsLetter) {

                    lastIndex--;

                } else if (lastIsLetter) {

                    firstIndex++;

                } else {

                    firstIndex++;
                    lastIndex--;

                }
            }

            anagramLine.append(chars).append(" ");
        }

        return anagramLine.toString().trim();
    }

    private boolean isEnglishLetter(char value){

        if ((value > 64 && value < 91) || (value > 96 && value < 123)){
            return true;
        }
        return false;
    }
}