package org.example.exercicetdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class FibTest {


    Fib fib;

    @Test
    public void TestFib_WhenRange_1_ThenResultNotEmpty(){
        fib = new Fib(1);

        List<Integer> fibTest = fib.getFibSeries();
        Assertions.assertFalse(fibTest.isEmpty());
    }

    @Test
    public void TestFib_WhenRange_1_ThenResultContain_0(){
        fib = new Fib(1);

        List<Integer> fibTest = fib.getFibSeries();
        Assertions.assertTrue(fibTest.contains(0));
    }

    @Test
    public void TestFib_WhenRange_6_ThenResultContain_3(){
        fib = new Fib(6);

        List<Integer> fibTest = fib.getFibSeries();
        Assertions.assertTrue(fibTest.contains(3));
    }




}
