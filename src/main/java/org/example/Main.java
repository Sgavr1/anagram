package org.example;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String line = new Scanner(System.in).nextLine();
        line = Arrays
                .stream(line.split("\\s+"))
                .map(Main::reverse)
                .collect(Collectors.joining(" "));
        System.out.println(line);
    }
    private static String reverse(String word){
        return new StringBuilder(word).reverse().toString();
    }
}