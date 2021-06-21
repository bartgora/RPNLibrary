package com.github.bgora.rpnlibrary.operators;


import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.MathContext;

import static org.assertj.core.api.BDDAssertions.then;

class DivideOperatorStrategyTest {

    private DivideOperatorStrategy tested;
    private MathContext mathContext;

    @BeforeEach
    void setup() {
        tested = new DivideOperatorStrategy();
        mathContext = MathContext.DECIMAL64;
    }

    @Test
    void executeShouldReturn4() {

        final String givenFirstNumber = "8";
        final String givenSecondNumber = "2";

        final BigDecimal actual = tested.execute(givenFirstNumber, givenSecondNumber, mathContext);

        then(actual).isCloseTo(BigDecimal.valueOf(4), Percentage.withPercentage(0));
    }

    @Test
    void executeShouldReturnMinus4ForMinus2() {

        final String givenFirstNumber = "8";
        final String givenSecondNumber = "-2";

        final BigDecimal actual = tested.execute(givenFirstNumber, givenSecondNumber, mathContext);

        then(actual).isCloseTo(BigDecimal.valueOf(-4), Percentage.withPercentage(0));
    }

    @Test
    void executeShouldReturn4ForMinus() {

        final String givenFirstNumber = "-8";
        final String givenSecondNumber = "-2";

        final BigDecimal actual = tested.execute(givenFirstNumber, givenSecondNumber, mathContext);

        then(actual).isCloseTo(BigDecimal.valueOf(4), Percentage.withPercentage(0));
    }

    @Test
    void executeShouldReturn025() {

        final String givenFirstNumber = "2";
        final String givenSecondNumber = "8";

        final BigDecimal actual = tested.execute(givenFirstNumber, givenSecondNumber, mathContext);

        then(actual).isCloseTo(BigDecimal.valueOf(0.25), Percentage.withPercentage(0));
    }
}