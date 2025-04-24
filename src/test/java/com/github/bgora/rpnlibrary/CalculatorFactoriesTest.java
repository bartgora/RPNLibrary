package com.github.bgora.rpnlibrary;

import com.github.bgora.rpnlibrary.exceptions.RPNException;
import com.github.bgora.rpnlibrary.operators.AbstractOperatorStrategy;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Map;

public class CalculatorFactoriesTest {
    @Test
    public void testCalculate() throws RPNException {
        RPNCheckerFactory.createRPNChecker();
        Calculator calc = Calculator.createCalculator(RPNCheckerFactory.createRPNChecker(), RPNExecutionerFactory.createRPNExecutioner(),
                MathContext.DECIMAL64, 2);


        BigDecimal result = calc.calculate("2^3*(12/6)+18/3+5.0/2");
        Assertions.assertThat(result).isEqualTo(new BigDecimal("24.50"));


    }

    @Test
    public void testCalculateWithDefaults() throws RPNException {
        var rpnChecker = RPNCheckerFactory.createRPNCheckerWithDefaults(Map.of("%", 1), Map.of());
        AbstractOperatorStrategy modulo = new AbstractOperatorStrategy("%") {

            @Override
            public BigDecimal execute(final String first, final String second, final MathContext mathContext) {
                var firstDec = new BigDecimal(first, mathContext);
                var secondDec = new BigDecimal(second, mathContext);
                return firstDec.remainder(secondDec);
            }
        };
        var rpnExecutioner = RPNExecutionerFactory.createRPNExecutionerWithDefaults(Map.of("%", modulo), Map.of());

        var calc = Calculator.createCalculator(rpnChecker,rpnExecutioner, MathContext.DECIMAL64, 2);

        BigDecimal result = calc.calculate("4%17");
        Assertions.assertThat(result).isEqualTo(new BigDecimal("4.00"));

    }
}
