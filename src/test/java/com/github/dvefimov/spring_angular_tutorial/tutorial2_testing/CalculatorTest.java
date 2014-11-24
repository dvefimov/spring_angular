package com.github.dvefimov.spring_angular_tutorial.tutorial2_testing;

import com.github.dvefimov.spring_angular_tutorial.tutorial2_testing.Calculator;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created with IntelliJ IDEA.
 * User: техно сити
 * Date: 22.11.14
 * Time: 18:22
 * To change this template use File | Settings | File Templates.
 */
public class CalculatorTest {
    @Mock
    private Calculator calc;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        //calc = new Calculator();
    }

    @Test
    public  void testAbs(){
        when(calc.abs(-20)).thenReturn(20);
        assertEquals(20, calc.abs(-20));
/*
        int expected =  4;
        int actual = calc.abs(-4);
        assertEquals(expected, actual);
*/
    }
}
