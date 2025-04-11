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

        String givenEquation = "(1+2)*5";
        String expected = "( 1 + 2 ) * 5";

        String result = tested.apply(givenEquation);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void shouldReturnTransferredFunctionText() {

        String givenEquation = "sin(15)";
        String expected = "sin ( 15 )";

        String result = tested.apply(givenEquation);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void shouldReturnTransferredTextForFunctionAndEquation() {

        String givenEquation = "sin(15) + (21 *5)";
        String expected = "sin ( 15 ) + ( 21 * 5 )";

        String result = tested.apply(givenEquation);

        assertThat(result).isEqualTo(expected);
    }
}
