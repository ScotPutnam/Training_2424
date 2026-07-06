package com.revature.unittest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// provides human readable test name for reports
@DisplayName("Basic unit tests")
public class Junit6_demo_basics {
    // AAA pattern - Arrange, Act, Assert
    // System under test


    private final Calculator calculator = new Calculator();

    @Test
    @DisplayName("Adding two positive numbers"){
        // ARRANGE - Set up the test data
        int a = 1;
        int b = 2;

        // ACT - Execute the method under test
        int result = calculator.add(a, b);

        // ASSERT -
        assertEquals()
    }


}
