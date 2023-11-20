package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class AnagramMakerTest {

    @Test
    public void shouldThrowExceptionWhenAnagramIsNull(){
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
    public void shouldReturnAnagramWhenSomeCharacterLowerAndUpper(){
        AnagramMaker anagramMaker = new AnagramMaker();

        assertEquals("QqqqQQQq", anagramMaker.make("qQQQqqqQ"));
    }

    @Test
    public void shouldReturnAnagramWordWhenWordDifferentLetter(){
        AnagramMaker anagramMaker = new AnagramMaker();

        assertEquals("olleH",anagramMaker.make("Hello"));
        assertEquals("12Hello",anagramMaker.make("12olleH"));
    }

    @Test
    public void shouldReturnNonAnagramsWhenOnlySymbols(){
        AnagramMaker anagramMaker = new AnagramMaker();

        assertEquals("12/!()%%",anagramMaker.make("12/!()%%"));
    }

    @Test
    public void shouldReturnAnagramWordsWhenSeveralWords(){
        AnagramMaker anagramMaker = new AnagramMaker();

        assertEquals("123 qwe 1q2w3e", anagramMaker.make("123 ewq 1e2w3q"));
    }
}