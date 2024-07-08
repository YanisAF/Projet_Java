package org.example.exercicetdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GradingCalcutorTest {

    private GradingCalculator calcul;

    @Test
    public void renvoiTest(){
        calcul = new GradingCalculator(95, 90);
        char result = calcul.getGrade();

        Assertions.assertEquals('A', result);
    }

    @Test
    public void renvoiTest2(){
        calcul = new GradingCalculator(85, 90);
        char result = calcul.getGrade();
        Assertions.assertEquals('B', result);
    }

    @Test
    public void renvoiTest3(){
        calcul = new GradingCalculator(65, 90);
        char result = calcul.getGrade();
        Assertions.assertEquals('C', result);
    }



}
