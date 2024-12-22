package org.example.string;

public class RomanToInteger {
    public int romanToInt(String s) {
        int res = 0;
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            switch (c) {
                case 'I': {
                    if (i < s.length() - 1) {
                        if (s.charAt(i + 1) == 'V') {
                            res += 4;
                            i += 2;
                        } else if (s.charAt(i + 1) == 'X') {
                            res += 9;
                            i += 2;
                        } else {
                            res += 1;
                            i += 1;
                        }
                    } else {
                        res += 1;
                        i += 1;
                    }
                    break;
                }
                case 'V': {
                    res += 5;
                    i += 1;
                    break;
                }
                case 'X': {
                    if (i < s.length() - 1) {
                        if (s.charAt(i + 1) == 'L') {
                            res += 40;
                            i += 2;
                        } else if (s.charAt(i + 1) == 'C') {
                            res += 90;
                            i += 2;
                        } else {
                            res += 10;
                            i += 1;
                        }
                    } else {
                        res += 10;
                        i += 1;
                    }
                    break;
                }
                case 'L': {
                    res += 50;
                    i += 1;
                    break;
                }
                case 'C': {
                    if (i < s.length() - 1) {
                        if (s.charAt(i + 1) == 'D') {
                            res += 400;
                            i += 2;
                        } else if (s.charAt(i + 1) == 'M') {
                            res += 900;
                            i += 2;
                        } else {
                            res += 100;
                            i += 1;
                        }
                    } else {
                        res += 100;
                        i += 1;
                    }
                    break;
                }
                case 'D': {
                    res += 500;
                    i += 1;
                    break;
                }
                case 'M': {
                    res += 1000;
                    i += 1;
                    break;
                }
                default:
                    System.out.printf("Unknown character at index %d%n", i);
                    break;
            }
        }
        return res;
    }
}