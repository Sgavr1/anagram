package org.example;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        String line  = new Scanner(System.in).nextLine();

        AnagramMaker anagramMaker = new AnagramMaker();

        line = Arrays.stream(line.split("\\s+")).map(anagramMaker::make).collect(Collectors.joining(" "));

        System.out.println(line);
    }
}