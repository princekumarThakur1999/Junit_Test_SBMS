package com.anoxi;

import com.anoxi.bo.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private static Calculator cal;

    @BeforeAll
    public static void init(){
        cal = new Calculator();
    }

    @AfterAll
    public static void destory(){
        cal = null;
    }

    @Test
    public void testAdd_01(){
        Integer actualResult = cal.add(10, 20);
        Integer expectedResult = 30;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testAdd_02(){
        Integer actualResult = cal.add(100, 50);
        Integer expectedResult = 150;

       assertEquals(expectedResult, actualResult);
    }

    @Test
    @Disabled("Expected result is wrong. Skipping for now.")
    public void testAdd_03(){
        Integer actualResult = cal.add(100, 50);
        Integer expectedResult = 100;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testdiv_01(){
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> cal.div(10, 0));
       //assertEquals("/ by zero", exception.getMessage());
    }

    @Test()
    public void testdiv_02(){

        assertTimeout(Duration.ofMillis(1000), ()-> {
            Integer actualResult = cal.div(100, 2);
            Integer expectedResult = 50;

            assertEquals(actualResult, expectedResult);
        });

    }
}
