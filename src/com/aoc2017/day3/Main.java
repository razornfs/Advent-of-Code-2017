package com.aoc2017.day3;

import java.awt.*;

public class Main {

    private static int input = 368078;
    private static int[][] arr = new int[1000][1000];

    public static void main(String[] args) {
        getSteps(input);
    }

    private static void getSteps(int input) {
        int start = 1;
        int currentStepsAmount = 1;
        arr[500][500] = 1;
        Point currentLoc = new Point(0, 0);
        boolean positive = true;
        outer:
        while (true) {
            for (int i = 0; i < currentStepsAmount; i++) {
                currentLoc.x += positive ? 1 : -1;
                start++;

                int adjacentSum = sumAdjacent(500 + currentLoc.x, 500 + currentLoc.y);
                if (adjacentSum > input) {
                    System.out.println(adjacentSum);
                    break outer;
                }
                arr[500 + currentLoc.x][500 + currentLoc.y] = adjacentSum;

                if (start == input) {
                    System.out.println(Math.abs(currentLoc.x) + Math.abs(currentLoc.y));
                    break outer;
                }
            }
            for (int i = 0; i < currentStepsAmount; i++) {
                currentLoc.y += positive ? 1 : -1;
                start++;

                int adjacentSum = sumAdjacent(500 + currentLoc.x, 500 + currentLoc.y);
                if (adjacentSum > input) {
                    System.out.println(adjacentSum);
                    break outer;
                }
                arr[500 + currentLoc.x][500 + currentLoc.y] = adjacentSum;

                if (start == input) {
                    System.out.println(Math.abs(currentLoc.x) + Math.abs(currentLoc.y));
                    break outer;
                }
            }
            currentStepsAmount++;
            positive = !positive;
        }
    }

    private static int sumAdjacent(int i, int j) {
        return arr[i + 1][j + 1] + arr[i + 1][j] + arr[i + 1][j - 1] +
               arr[i][j + 1] + arr[i][j - 1] +
               arr[i - 1][j + 1] + arr[i - 1][j] + arr[i - 1][j - 1];
    }
}
