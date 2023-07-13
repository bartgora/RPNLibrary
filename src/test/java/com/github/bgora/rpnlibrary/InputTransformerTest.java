package com.github.bgora.rpnlibrary;

import org.junit.jupiter.api.Test;

import java.util.function.UnaryOperator;

import static org.assertj.core.api.Assertions.assertThat;

public class InputTransformerTest {
    UnaryOperator<String> tested = new InputTransformer(
            new RPNChecker(
                    new DefaultStrategyProvider()));

    @Test
    void shouldReturnEmptyText() {
        String result = tested.apply("");
        assertThat(result).isEmpty();
    }

    @Test
    void shouldReturnTransferredText() {
        String expected = "( 1 + 2 ) * 5";
        String result = tested.apply("(1+2)*5");
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void shouldReturnTransferredFunctionText() {
        String expected = "sin ( 15 )";
        String result = tested.apply("sin(15)");
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void shouldReturnTransferredTextForFunctionAndEquation() {
        String expected = "sin ( 15 ) + ( 21 * 5 )";
        String result = tested.apply("sin(15) + (21 *5)");
        assertThat(result).isEqualTo(expected);
    }
}
