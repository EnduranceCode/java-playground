package com.endurancecode.tutorialspoint.suite;

import static org.junit.Assert.assertEquals;

import com.endurancecode.MessageUtil;
import org.junit.Test;

/**
 * Tutorialspoint: Learn Junit
 * https://www.tutorialspoint.com/junit/
 *
 * Chapter: JUnit - Suite Test
 * https://www.tutorialspoint.com/junit/junit_suite_test.htm
 */
public class TestUnitOne {
    String message = "Robert";
    MessageUtil messageUtil = new MessageUtil(message);

    @Test
    public void testPrintMessage() {
        System.out.println("Inside testPrintMessage()");

        assertEquals(message, messageUtil.printMessage());
    }
}
