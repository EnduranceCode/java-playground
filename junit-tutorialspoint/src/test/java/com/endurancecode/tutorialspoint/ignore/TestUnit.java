package com.endurancecode.tutorialspoint.ignore;

import static org.junit.Assert.assertEquals;

import com.endurancecode.MessageUtil;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Tutorialspoint: Learn Junit
 * https://www.tutorialspoint.com/junit/
 *
 * Chapter: JUnit - Ignore Test
 * https://www.tutorialspoint.com/junit/junit_ignore_test.htm
 */
public class TestUnit {
    String message = "Robert";
    MessageUtil messageUtil = new MessageUtil(message);

    @Test
    @Ignore
    public void testPrintMessage() {
        assertEquals(message, messageUtil.printMessage());
    }

    @Test
    @Ignore
    public void testSalutationPrintMessage() {
        message = "Hi! " + message;

        assertEquals(message, messageUtil.salutationMessage());
    }
}
