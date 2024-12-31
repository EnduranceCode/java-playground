package com.endurancecode.tutorialspoint.time;

import static org.junit.Assert.assertEquals;

import com.endurancecode.MessageUtil;
import org.junit.Test;

/**
 * Tutorialspoint: Learn Junit
 * https://www.tutorialspoint.com/junit/
 *
 * Chapter: JUnit - Time Test
 * https://www.tutorialspoint.com/junit/junit_time_test.htm
 */
public class TestUnit {
    String message = "Robert";
    MessageUtil messageUtil = new MessageUtil(message);


    @Test(timeout = 1000)
    public void testPrintMessageInfiniteLoop() {
        // This test will fail
        System.out.println("Inside testPrintMessageForever()");
        messageUtil.printMessageInfiniteLoop();
    }

    @Test
    public void testSalutationPrintMessage() {
        message = "Hi! " + message;

        assertEquals(message, messageUtil.salutationMessage());
    }
}
