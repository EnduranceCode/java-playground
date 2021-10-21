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
public class TestUnitTwo {
    String message = "Robert";
    MessageUtil messageUtil = new MessageUtil(message);

    @Test
    public void testSalutationPrintMessage() {
        System.out.println("Inside testSalutationPrintMessage()");

        message = "Hi! " + message;

        assertEquals(message, messageUtil.salutationMessage());
    }
}
