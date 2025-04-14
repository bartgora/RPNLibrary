package com.github.bgora.rpnlibrary;

import com.github.bgora.rpnlibrary.exceptions.RPNException;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.MathContext;

public class CalculatorFactoriesTest {
    @Test
    public void testCalculate() throws RPNException {
        RPNCheckerFactory.createRPNChecker();
        Calculator calc = Calculator.createCalculator(RPNCheckerFactory.createRPNChecker(), RPNExecutionerFactory.createRPNExecutioner(),
                MathContext.DECIMAL64, 2);


        BigDecimal result = calc.calculate("2^3*(12/6)+18/3+5.0/2");
        Assertions.assertThat(result).isEqualTo(new BigDecimal("24.50"));
    }
}
