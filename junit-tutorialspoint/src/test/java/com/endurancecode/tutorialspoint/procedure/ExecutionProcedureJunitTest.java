package com.endurancecode.tutorialspoint.procedure;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Tutorialspoint: Learn Junit
 * https://www.tutorialspoint.com/junit/
 *
 * Chapter: JUnit - Execution Procedure
 * https://www.tutorialspoint.com/junit/junit_execution_procedure.htm
 */
public class ExecutionProcedureJunitTest {
    // Execute only once, in the start
    @BeforeClass
    public static void beforeClass() {
        System.out.println("In before Class");
    }

    // Execute only once, in th end
    @AfterClass
    public static void afterClass() {
        System.out.println("In after Class");
    }

    // Execute for each test, before executing the test
    @Before
    public void before() {
        System.out.println("In before");
    }

    // Execute for each test, after executing the test
    @After
    public void after() {
        System.out.println("In after");
    }

    // First Test Case
    @Test
    public void firstTestCase() {
        System.out.println("Executing the First Test Case");
    }

    // Second Test Case
    @Test
    public void secondTestCase() {
        System.out.println("Executing the Second Test Case");
    }
}
