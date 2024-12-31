package com.endurancecode.tutorialspoint.environment;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tutorialspoint: Learn Junit
 * https://www.tutorialspoint.com/junit/
 *
 * Chapter: JUnit - Environment Setup
 * https://www.tutorialspoint.com/junit/junit_environment_setup.htm
 */
public class TestJunit {
    @Test
    public void testAdd() {
        String str = "Junit is working fine";
        assertEquals("Junit is working fine", str);
    }
}
