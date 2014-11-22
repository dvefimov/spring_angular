package com.github.dvefimov.spring_angular_tutorial;

import com.github.dvefimov.spring_angular_tutorial.tutorial2_testing.Car;
import com.github.dvefimov.spring_angular_tutorial.tutorial2_testing.Engine;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created with IntelliJ IDEA.
 * User: техно сити
 * Date: 22.11.14
 * Time: 18:57
 * To change this template use File | Settings | File Templates.
 */
public class CarTest {

    @Mock
    private Engine engine;

    @InjectMocks
    private Car car;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testWarning(){
        when(engine.getRpm()).thenReturn(6000);

        car.accelerate();

        assertEquals("Slow Down!", car.getWarningMessage());

    }
}
