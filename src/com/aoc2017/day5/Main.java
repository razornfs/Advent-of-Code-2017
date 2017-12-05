package com.aoc2017.day5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Main {

    private static int[] instructions;

    public static void main(String[] args) throws IOException {
        String[] unparsedInstructions =
                Files.readAllLines(Paths.get("./src/com/aoc2017/day5/input.txt")).toArray(new String[0]);
        instructions = new int[unparsedInstructions.length];
        for (int i = 0; i < unparsedInstructions.length; i++) {
            instructions[i] = Integer.parseInt(unparsedInstructions[i]);
        }

        int curPos = 0;
        int count = 0;
        while (curPos >= 0 && curPos < instructions.length) {
            int temp = curPos;
            if (instructions[curPos] >= 3) {
                curPos += instructions[curPos];
                instructions[temp]--;
            } else {
                curPos += instructions[curPos];
                instructions[temp]++;
            }
            count++;
        }
        System.out.println(count);
    }
}
