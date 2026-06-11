package com.revature;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestGreeter {
    @Test
    void testGreet(){
        Greeter greeter = new Greeter();
        String expectedResult = "Hello SCOT";
        String actualResult = greeter.hello("Scot");
        Assertions.assertEquals(expectedResult, actualResult);
    }
}
