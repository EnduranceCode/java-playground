package com.endurancecode.tutorialspoint.writing.business;

import static org.junit.Assert.assertEquals;

import com.endurancecode.writing.business.EmployeeBusinessLogic;
import com.endurancecode.writing.model.EmployeeDetails;
import org.junit.Test;

/**
 * Tutorialspoint: Learn Junit
 * https://www.tutorialspoint.com/junit/
 *
 * Chapter: JUnit - Writing a Test
 * https://www.tutorialspoint.com/junit/junit_writing_tests.htm
 */
public class EmployeeBusinessLogicTest {
    EmployeeDetails employeeDetails = new EmployeeDetails();
    EmployeeBusinessLogic employeeBusinesLogic = new EmployeeBusinessLogic();

    @Test
    public void calculateAppraisalTest() {
        employeeDetails.setName("Zé Manel Pincel");
        employeeDetails.setAge(25);
        employeeDetails.setMonthlySalary(8000);

        double appraisal = employeeBusinesLogic.calculateAppraisal(employeeDetails);

        assertEquals(500, appraisal, 0.0);
    }

    @Test
    public void CalculateYearlySalaryTest() {
        employeeDetails.setName("Zé Manel Pincel");
        employeeDetails.setAge(25);
        employeeDetails.setMonthlySalary(8000);

        double salary = employeeBusinesLogic.calculateYearlySalary(employeeDetails);
        assertEquals(96000, salary, 0.0);
    }
}
