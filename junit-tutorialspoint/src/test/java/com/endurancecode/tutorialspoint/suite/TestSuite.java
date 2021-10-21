package com.endurancecode.tutorialspoint.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Tutorialspoint: Learn Junit
 * https://www.tutorialspoint.com/junit/
 *
 * Chapter: JUnit - Suite Test
 * https://www.tutorialspoint.com/junit/junit_suite_test.htm
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({TestUnitOne.class, TestUnitTwo.class})
public class TestSuite {
}
