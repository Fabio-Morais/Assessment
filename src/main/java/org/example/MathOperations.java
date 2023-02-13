package org.example;

import java.util.Arrays;
import java.util.Collections;

public class MathOperations {

    private boolean isDivisibleBy3(int num) {
        return num % 3 == 0;
    }

    private static int[] twoLargest(Integer[] values) {
        Integer[] aux = Arrays.copyOf(values, 3);
        Arrays.sort(aux, Collections.reverseOrder());

        return new int[]{aux[0], aux[1]};
    }
    private static int[] twoSmallest(Integer[] values) {
        Integer[] aux = Arrays.copyOf(values, 3);
        Arrays.sort(aux);

        return new int[]{aux[0], aux[1]};
    }

    /**
     * This method is used to get the maximum product which is divisible by 3.
     *
     * @param array Array of numbers to get the maximum product
     * @return maximum product
     */
    public int maximumProduct(Integer[] array) {
        if (array == null || array.length == 0) {
            System.out.println("Array passed is empty");
            return 0;
        }

        int[] maxNumberDivisibleBy3 = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
        int[] minNumberDivisibleBy3 = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};

        final short setFirstElement = 0;
        final short setSecondElement = 1;
        short setElement= setFirstElement;

        int maxNumberNotDivisibleBy3 = Integer.MIN_VALUE;
        int minNumberNotDivisibleBy3 = Integer.MAX_VALUE;

        for (Integer integer : array) {
            if (isDivisibleBy3(integer) && setElement == setFirstElement) {
                maxNumberDivisibleBy3[0] = Math.max(maxNumberDivisibleBy3[0], integer);
                minNumberDivisibleBy3[0] = Math.min(minNumberDivisibleBy3[0], integer);
                setElement = setSecondElement;
            } else if (isDivisibleBy3(integer) && setElement == setSecondElement) {
                maxNumberDivisibleBy3[1] = Math.max(maxNumberDivisibleBy3[1], integer);
                minNumberDivisibleBy3[1] = Math.min(minNumberDivisibleBy3[1], integer);
                setElement = setFirstElement;
            } else {
                maxNumberNotDivisibleBy3 = Math.max(maxNumberNotDivisibleBy3, integer);
                minNumberNotDivisibleBy3= Math.min(minNumberNotDivisibleBy3, integer);
            }
        }

        int[] largest = twoLargest(new Integer[]{maxNumberDivisibleBy3[0], maxNumberDivisibleBy3[1], maxNumberNotDivisibleBy3});
        int product = largest[0] * largest[1];

        // This is for the negative numbers, i.e -> {-9,-3} are the smallest numbers, but when it does the product between them,
        // it becomes the largest product.
        int[] smallest = twoSmallest(new Integer[]{minNumberDivisibleBy3[0], minNumberDivisibleBy3[1], minNumberNotDivisibleBy3});
        int product2 = smallest[0] * smallest[1];

        return product == Integer.MIN_VALUE ? 0 : Math.max(product, product2);
    }
}
