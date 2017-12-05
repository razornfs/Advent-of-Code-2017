package com.aoc2017.day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    private static int sum1 = 0;
    private static int sum2 = 0;

    public static void main(String[] args) {
        part2();
    }

    private static void part1() {
        try {
            Files.readAllLines(Paths.get("./src/com/aoc2017/day2/input.txt"))
                 .forEach(s -> getMinMaxDifference(parse(s)));
        } catch (IOException e) {
            throw new RuntimeException();
        }
        System.out.println(sum1);
    }

    private static void part2() {
        try {
            Files.readAllLines(Paths.get("./src/com/aoc2017/day2/input.txt"))
                 .forEach(s -> findDivisibleNumbers(parse(s)));
        } catch (IOException e) {
            throw new RuntimeException();
        }
        System.out.println(sum2);
    }

    private static int[] parse(String input) {
        String[] unparsedNumbers = input.split("\\s+");
        int[] ret = new int[unparsedNumbers.length];
        for (int i = 0; i < unparsedNumbers.length; i++) {
            ret[i] = Integer.parseInt(unparsedNumbers[i]);
        }
        return ret;
    }

    private static void getMinMaxDifference(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        for (int i : arr) {
            if (i < min) {
                min = i;
            }
            if (i > max) {
                max = i;
            }
        }
        sum1 += max - min;
    }

    private static void findDivisibleNumbers(int[] arr) {
        outer:
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i != j && arr[i] % arr[j] == 0) {
                    sum2 += arr[i] / arr[j];
                    break outer;
                }
            }
        }
    }
}
