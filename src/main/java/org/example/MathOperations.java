package org.example;

public class MathOperations {

    private boolean isDivisibleBy3(int num) {
        return num % 3 == 0;
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
        int maxProduct = Integer.MIN_VALUE;
        final short productNotFound = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int product = array[i] * array[j];

                if (isDivisibleBy3(product) && product > maxProduct) {
                    maxProduct = product;
                }
            }
        }

        return maxProduct == Integer.MIN_VALUE ? productNotFound : maxProduct;
    }
}
