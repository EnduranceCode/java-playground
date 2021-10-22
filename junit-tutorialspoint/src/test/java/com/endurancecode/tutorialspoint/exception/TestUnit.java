package com.endurancecode.tutorialspoint.exception;

import static org.junit.Assert.assertEquals;

import com.endurancecode.MessageUtil;
import org.junit.Test;

/**
 * Tutorialspoint: Learn Junit
 * https://www.tutorialspoint.com/junit/
 *
 * Chapter: JUnit - Exceptions Test
 * https://www.tutorialspoint.com/junit/junit_exceptions_test.htm
 */
public class TestUnit {
    String message = "Robert";
    MessageUtil messageUtil = new MessageUtil(message);

    @Test(expected = ArithmeticException.class)
    public void testPrintMessageAndThrowException() {
        System.out.println("Inside testPrintMessageForever()");
        messageUtil.printMessageAndThrowException();
    }

    @Test
    public void testSalutationPrintMessage() {
        message = "Hi! " + message;

        assertEquals(message, messageUtil.salutationMessage());
    }
}
