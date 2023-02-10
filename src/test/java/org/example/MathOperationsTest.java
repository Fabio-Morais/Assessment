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