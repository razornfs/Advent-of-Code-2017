package com.aoc2017.day1;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    static String input;

    public static void main(String[] args) {
        try {
            input = Files.readAllLines(Paths.get("./src/com/aoc2017/day1/input.txt")).get(0);
        } catch (IOException e) {
            throw new RuntimeException();
        }
        part1();
        part2();
    }

    private static void part1() {
        int captchaSum = 0;
        for (int i = 0; i < input.length(); i++) {
            char first = input.charAt(i);
            char second = input.charAt((i + 1) % input.length());
            if (first == second) {
                captchaSum += Character.getNumericValue(first);
            }
        }
        System.out.println(captchaSum);
    }

    private static void part2() {
        int captchaSum = 0;
        for (int i = 0; i < input.length(); i++) {
            char first = input.charAt(i);
            char second = input.charAt((i + input.length() / 2) % input.length());
            if (first == second) {
                captchaSum += Character.getNumericValue(first);
            }
        }
        System.out.println(captchaSum);
    }
}
