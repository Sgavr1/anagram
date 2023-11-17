package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnagramMakerTest {
    public AnagramMaker anagramMaker = new AnagramMaker();

    @Test
    void make_Null_ThrowsIllegalArgumentException(){
        assertThrowsExactly(IllegalArgumentException.class,
                ()->{
                    anagramMaker.make(null);
                });
    }

    @Test
    void make_EmptyString_EmptyString(){
        assertEquals("", anagramMaker.make(""));
    }

    @Test
    void make_OneSpace_EmptyString(){
        assertEquals("", anagramMaker.make(" "));
    }

    @Test
    void make_SomeSpace_EmptyString(){
        assertEquals("", anagramMaker.make("  "));
        assertEquals("", anagramMaker.make("   "));
        assertEquals("", anagramMaker.make("    "));
        assertEquals("", anagramMaker.make("     "));
        assertEquals("", anagramMaker.make("      "));
        assertEquals("", anagramMaker.make("       "));
    }

    @Test
    void make_SingleCharacter_Character(){
        assertEquals("q", anagramMaker.make("q"));
        assertEquals("1", anagramMaker.make("1"));
        assertEquals(".", anagramMaker.make("."));
        assertEquals("-", anagramMaker.make("-"));
        assertEquals("!", anagramMaker.make("!"));
    }

    @Test
    void make_MultipleSameLetter_MultipleSameLetter(){
        assertEquals("qqq",anagramMaker.make("qqq"));
        assertEquals("ppppp",anagramMaker.make("ppppp"));
    }

    @Test
    void make_SameCharacterLowerAndUpper_AnagramCharacter(){
        assertEquals("QqqqQQQq", anagramMaker.make("qQQQqqqQ"));
    }

    @Test
    void make_WordDifferentLetter_AnagramWord(){
        assertEquals("olleH",anagramMaker.make("Hello"));
        assertEquals("12Hello",anagramMaker.make("12olleH"));
    }

    @Test
    void make_OnlySymbols_SameTerm(){
        assertEquals("12/!()%%",anagramMaker.make("12/!()%%"));
    }

    @Test
    void make_SeveralWords_AnagramSeveralWords(){
        assertEquals("123 qwe 1q2w3e", anagramMaker.make("123 ewq 1e2w3q"));
    }
}