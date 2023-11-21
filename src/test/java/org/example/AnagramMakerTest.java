package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class AnagramMakerTest {

    @Test
    public void shouldThrowExceptionWhenTextIsNull(){
        AnagramMaker anagramMaker = new AnagramMaker();

        assertThrowsExactly(IllegalArgumentException.class,
                ()->{
                    anagramMaker.make(null);
                });
    }

    @Test
    public void shouldReturnEmptyStringWhenEmptyString(){
        AnagramMaker anagramMaker = new AnagramMaker();

        assertEquals("", anagramMaker.make(""));
    }


    @ParameterizedTest
    @ValueSource(strings = {" ", "  ", "   ", "    ",  "     ", "      "})
    public void shouldReturnEmptyStringWhenOneOrManySpaces(String str){

        AnagramMaker anagramMaker = new AnagramMaker();

        assertEquals("", anagramMaker.make(str));
    }


    @ParameterizedTest
    @ValueSource(strings = {"q", "1", ".", "-", "!"})
    public void shouldReturnSameSymbolWhenSingleCharacter(String str){
        AnagramMaker anagramMaker = new AnagramMaker();

        assertEquals(str, anagramMaker.make(str));
    }

    @ParameterizedTest
    @ValueSource(strings = {"qqq", "ppppp"})
    public void shouldReturnSameLettersWhenMultipleSameLetter(String str){
        AnagramMaker anagramMaker = new AnagramMaker();

        assertEquals(str,anagramMaker.make(str));
    }

    @Test
    public void shouldReturnReverseWhenSomeCharacterLowerAndUpper(){
        AnagramMaker anagramMaker = new AnagramMaker();

        assertEquals("QqqqQQQq", anagramMaker.make("qQQQqqqQ"));
    }

    @ParameterizedTest
    @CsvSource({"Hello, olleH", "12olleH, 12Hello"})
    public void shouldReturnAnagramWordWhenWordDifferentLetter(String input, String result){
        AnagramMaker anagramMaker = new AnagramMaker();

        assertEquals(result,anagramMaker.make(input));
    }

    @Test
    public void shouldNotReverseWhenOnlySymbols(){
        AnagramMaker anagramMaker = new AnagramMaker();

        assertEquals("12/!()%%",anagramMaker.make("12/!()%%"));
    }

    @Test
    public void shouldReturnAnagramWordsWhenSeveralWords(){
        AnagramMaker anagramMaker = new AnagramMaker();

        assertEquals("123 qwe 1q2w3e", anagramMaker.make("123 ewq 1e2w3q"));
    }
}