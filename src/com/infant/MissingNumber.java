package com.infant;

import java.util.Arrays;
import java.util.Scanner;

public class MissingNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("The Program is to find the missing number in the array");
        System.out.println("Enter the count of numbers:  ");
        int count = sc.nextInt();
        int[] input = new int[count];
        System.out.printf("Enter the %d numbers in any order %n", count);

        for (int i = 0; i < count; i++) {
            input[i] = sc.nextInt();

        }
        int missingNr = missingNumFrSortArr(input);
        System.out.printf("Missing number is %d %n", missingNr);

        //System.out.printf("middle %d %n", mitte);
    }

    private static int missingNumFrSortArr(int[] input) {
        if (input == null || input.length <= 0) {
            throw new IllegalArgumentException("Null or empty array. Try hard");
        }
        int link = 0;
        int recht = input.length - 1;
        while (link <= recht) {
            int mitte = (link + recht) >> 1;
            if (input[mitte] != mitte) {
                if (mitte == 0 || input[mitte - 1] == mitte - 1) {
                    return mitte;
                }
                recht = mitte - 1;
            } else {
                link = mitte + 1;
            }

        }
        throw new RuntimeException("No missing number");
    }
}
