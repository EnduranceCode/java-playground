package com.endurancecode.tutorialspoint.basic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import com.endurancecode.MessageUtil;
import org.junit.Test;

/**
 * Tutorialspoint: Learn Junit
 * https://www.tutorialspoint.com/junit/
 *
 * Chapter: JUnit - Basic Usage
 * https://www.tutorialspoint.com/junit/junit_basic_usage.htm
 */
public class TestUnit {
    String message = "Hello World";
    MessageUtil messageUtil = new MessageUtil(message);


    @Test
    public void testPrintMessage() {
        assertEquals(message, messageUtil.printMessage());
    }

    @Test
    public void testPrintMessageNotEquals() {
        message = "New World";

        assertNotEquals(message, messageUtil.printMessage());
    }
}
