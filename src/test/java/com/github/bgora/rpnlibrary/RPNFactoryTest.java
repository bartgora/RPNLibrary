package com.github.bgora.rpnlibrary;

import org.junit.jupiter.api.Test;

import java.util.function.UnaryOperator;

import static org.assertj.core.api.Assertions.assertThat;

public class RPNFactoryTest {
    UnaryOperator<String> tested = new RPNFactory(
            new RPNChecker(
                    new DefaultStrategyProvider()));

    @Test
    void shouldReturnRPN() {
        String givenInput = "( 2 + 3 ) * 5";
        String expected = "2 3 + 5 *";
        String result = tested.apply(givenInput);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void shouldReturnRPNForFunctionCall(){
        String expected = "1 sin";
        String result = tested.apply("sin ( 1 )");
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void shouldReturnRPNForFunctionAndEquation(){
        String expected = "1 sin 27 8 * +";
        String result = tested.apply("sin ( 1 ) + 27 * 8");
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void shouldReturnRPNForTwoFunctionsCall(){
        String expected = "1 sin 0 ctg +";
        String result = tested.apply("sin ( 1 ) + ctg ( 0 )");
        assertThat(result).isEqualTo(expected);
    }
}
