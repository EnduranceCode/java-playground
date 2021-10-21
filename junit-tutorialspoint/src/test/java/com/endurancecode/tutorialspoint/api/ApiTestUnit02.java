package com.endurancecode.tutorialspoint.api;

import static org.junit.Assert.assertNotEquals;

import junit.framework.TestCase;
import org.junit.Before;

/**
 * Tutorialspoint: Learn Junit
 * https://www.tutorialspoint.com/junit/
 *
 * Chapter: JUnit - API
 * https://www.tutorialspoint.com/junit/junit_api.htm
 */
public class ApiTestUnit02 extends TestCase {
    protected double firstDoubleValue;
    protected double secondDoubleValue;

    @Before
    public void setUp() {
        firstDoubleValue = 2.0;
        secondDoubleValue = 3.0;
    }

    public void testAdd() {
        // Count the number of tests cases
        System.out.println("Test Case Number = " + this.countTestCases());

        // Test getName
        String name = this.getName();
        System.out.println("Test Case Name = " + name);

        this.setName("testNewAdd");
        String newName = this.getName();
        System.out.println("Updated Test Case Name = " + newName);

        assertNotEquals(name, newName);
    }

    // tearDown used to close the connection or clean up activities
    public void tearDown() {
    }
}
