package com.endurancecode.tutorialspoint.assertion;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Tutorialspoint: Learn Junit
 * https://www.tutorialspoint.com/junit/
 *
 * Chapter: JUnit - Using Assertion
 * https://www.tutorialspoint.com/junit/junit_using_assertion.htm
 */
public class AnnotationsTest {
    // Execute before class
    @BeforeClass
    public static void beforeClass() {
        System.out.println("In before class");
    }

    // Execute after class
    @AfterClass
    public static void afterClass() {
        System.out.println("In after class");
    }

    // Execute before test
    @Before
    public void before() {
        System.out.println("In before");
    }

    // Execute after test
    @After
    public void after() {
        System.out.println("In after");
    }

    // Test case
    @Test
    public void test() {
        System.out.println("In test");
    }

    // Test case will be ignored and will not execute
    @Ignore
    public void ignoreTest() {
        System.out.println("In ignore test");
    }
}
