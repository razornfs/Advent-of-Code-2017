package com.aoc2017.day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Main {

    private static int validPassphrases = 0;

    public static void main(String[] args) throws IOException {
        Files.readAllLines(Paths.get("./src/com/aoc2017/day4/input.txt"))
             .forEach(s -> countValidPassphrases(s.split("\\s+")));
        System.out.println(validPassphrases);
    }

    private static void countValidPassphrases(String[] input) {
        for (int i = 0; i < input.length; i++) {
            char[] temp = input[i].toCharArray();
            Arrays.sort(temp);
            input[i] = Arrays.toString(temp);
        }
        Arrays.sort(input);
        boolean found = false;
        for (int i = 1; i < input.length; i++) {
            if (input[i].equals(input[i - 1])) {
                found = true;
                break;
            }
        }
        if (!found) {
            validPassphrases++;
        }
    }
}
