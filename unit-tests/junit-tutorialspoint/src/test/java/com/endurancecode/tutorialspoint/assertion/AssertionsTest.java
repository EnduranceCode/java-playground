package com.endurancecode.tutorialspoint.assertion;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Tutorialspoint: Learn Junit
 * https://www.tutorialspoint.com/junit/
 *
 * Chapter: JUnit - Using Assertion
 * https://www.tutorialspoint.com/junit/junit_using_assertion.htm
 */
public class AssertionsTest {

    @Test
    public void testAssertions() {
        // Test data
        String stringValue1 = new String("abc");
        String stringValue2 = new String("abc");
        String stringValue3 = null;
        String stringValue4 = "abc";
        String stringValue5 = "abc";

        int integerValue1 = 5;
        int integerValue2 = 6;

        String[] expectedArray = {"one", "two", "three"};
        String[] resultArray = {"one", "two", "three"};

        // Check that two objects are equal
        assertEquals(stringValue1, stringValue2);

        // Check that a condition is true
        assertTrue(integerValue1 < integerValue2);

        // Check that a condition is false
        assertFalse(integerValue1 > integerValue2);

        // Check that an object is not null
        assertNotNull(stringValue1);

        // Check that an object is null
        assertNull(stringValue3);

        // Check if two object references point to the same object
        assertSame(stringValue4, stringValue5);

        // Check if two object references doesn't point to the same object
        assertNotSame(stringValue1, stringValue5);

        // Checkif two arrays are equal
        assertArrayEquals(expectedArray, resultArray);
    }
}
