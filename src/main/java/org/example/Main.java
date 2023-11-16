package org.example;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        String line  = new Scanner(System.in).nextLine();
        AnagramMaker anagramMaker = new AnagramMaker();
        System.out.println(anagramMaker.make(line));
    }
}