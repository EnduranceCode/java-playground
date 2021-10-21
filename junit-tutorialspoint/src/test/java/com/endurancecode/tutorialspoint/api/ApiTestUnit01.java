package com.endurancecode.tutorialspoint.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

/**
 * Tutorialspoint: Learn Junit
 * https://www.tutorialspoint.com/junit/
 *
 * Chapter: JUnit - API
 * https://www.tutorialspoint.com/junit/junit_api.htm
 */
public class ApiTestUnit01 {
    @Test
    public void testAdd() {
        // Test data
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
}
