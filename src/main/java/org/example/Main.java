package org.example;

import org.example.string.StringToInteger;

public class Main {
    public static void main(String[] args) {
        String s = " -042";
        StringToInteger solution = new StringToInteger();
        System.out.println(solution.myAtoi(s));
    }
}