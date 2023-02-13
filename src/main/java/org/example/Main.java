package org.example;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    private static Integer[] generateData(int num) {
        Integer[] randomArray = new Integer[num];
        int min = 0, max = 20;

        for (int i = 0; i < num; i++) {
            int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
            randomArray[i] = randomNum;
        }
        return randomArray;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        MathOperations mathOperations = new MathOperations();

        System.out.println("Random Data, enter the length of the array that you need: ");
        int num = scanner.nextInt();

        Integer[] data = generateData(num);
        System.out.println("Generated array" + Arrays.toString(data));
        System.out.println("Result: "+ mathOperations.maximumProduct(data));
    }
}