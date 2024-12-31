package com.endurancecode.tutorialspoint.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import junit.framework.AssertionFailedError;
import junit.framework.TestResult;
import org.junit.Test;

/**
 * Tutorialspoint: Learn Junit
 * https://www.tutorialspoint.com/junit/
 *
 * Chapter: JUnit - API
 * https://www.tutorialspoint.com/junit/junit_api.htm
 */
public class ApiTestUnit03 extends TestResult {
    // Add the error
    public synchronized void addError(Test test, Throwable t) {
        super.addError((junit.framework.Test) test, t);
    }

    // Add the failure
    public synchronized void addFailure(Test test, AssertionFailedError t) {
        super.addFailure((junit.framework.Test) test, t);
    }

    @Test
    public void testAdd() {
        int number = 5;
        String nullVariable = null;
        String stringVariable = "Junit is working fine";

        // Check for equality
        assertEquals("Junit is working fine", stringVariable);

        // Check for false condition
        assertFalse(number > 6);

        // Check for null value
        assertNull(nullVariable);

        // Check for not null value
        assertNotNull(stringVariable);
    }

    // Marks that the test run should stop.
    public synchronized void stop() {
        // Stop the test here
    }
}
