package org.example;

import org.example.string.RomanToInteger;

public class Main {
    public static void main(String[] args) {
        String s = "MCMXCIV";
        RomanToInteger solution = new RomanToInteger();
        System.out.println(solution.romanToInt(s));

    }
}