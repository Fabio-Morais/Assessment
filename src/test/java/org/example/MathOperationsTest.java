package org.example;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import static org.junit.Assert.assertEquals;

public class MathOperationsTest {

    private MathOperations mathOperations;

    @Before
    public void setUp() throws Exception {
        mathOperations = new MathOperations();

    }

    @Rule
    public TestRule watcher = new TestWatcher() {
        @Override
        protected void succeeded(final Description description) {
            System.out.printf("Success: %s%n", description.toString());
        }

        @Override
        protected void failed(final Throwable e, final Description description) {
            System.out.printf("Failed: %s -> %s%n", description.getDisplayName(), e.toString());
        }
    };

    @Test
    public void normalData() {
        assertEquals("Regular data", mathOperations.maximumProduct(new Integer[]{6, 8, 8, 7, 2, 5}), 48);
        assertEquals("Regular data", mathOperations.maximumProduct(new Integer[]{1, 9, 2, 4}), 36);
        assertEquals("Regular data", mathOperations.maximumProduct(new Integer[]{3, 1}), 3);
        assertEquals("Regular data", mathOperations.maximumProduct(new Integer[]{3, 6, 9, 12, 1}), 108);
        assertEquals("Regular data", mathOperations.maximumProduct(new Integer[]{11, 9, 2, 14, 2}), 126);
        assertEquals("Regular data", mathOperations.maximumProduct(new Integer[]{4, 18, 11, 15, 10, 5, 16}), 288);
        assertEquals("Regular data", mathOperations.maximumProduct(new Integer[]{3, 1, 3, 9, 9}), 81);
        assertEquals("Regular data", mathOperations.maximumProduct(new Integer[]{2, 2, 2, 2, 2, 3}), 6);
        assertEquals("Regular data", mathOperations.maximumProduct(new Integer[]{3, 3, 3, 3, 3, 3}), 9);
        assertEquals("Regular data", mathOperations.maximumProduct(new Integer[]{2}), 0);
        assertEquals("Regular data", mathOperations.maximumProduct(new Integer[]{3}), 0);
        assertEquals("Regular data", mathOperations.maximumProduct(new Integer[]{3,2}), 6);
    }

    @Test
    public void negativeData() {
        assertEquals("Negative data", mathOperations.maximumProduct(new Integer[]{-6, -8, -8, -7, -2, -5}), 48);
        assertEquals("Negative data", mathOperations.maximumProduct(new Integer[]{-6, 8, -8, -7, -2, -5}), 48);
        assertEquals("Negative data", mathOperations.maximumProduct(new Integer[]{-6, 8, 8, -7, -2, -5}), 42);
        assertEquals("Negative data", mathOperations.maximumProduct(new Integer[]{-6, 8, 8, 7, -2, -5}), 30);
        assertEquals("Negative data", mathOperations.maximumProduct(new Integer[]{-6, 8, 8, 7, -2, 5}), 12);
        assertEquals("Negative data", mathOperations.maximumProduct(new Integer[]{-6, 8, 8, 7, 2, 5}), -12);
        assertEquals("Negative data", mathOperations.maximumProduct(new Integer[]{-1, -9, -2, -4}), 36);
    }

    @Test
    public void nullOrEmptyData() {
        assertEquals("Null data", mathOperations.maximumProduct(null), 0);
        assertEquals("Empty data", mathOperations.maximumProduct(new Integer[]{}), 0);
        assertEquals("Return 0", mathOperations.maximumProduct(new Integer[]{3, 0}), 0);
        assertEquals("One value", mathOperations.maximumProduct(new Integer[]{3}), 0);
    }
}