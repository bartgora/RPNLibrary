package com.github.bgora.rpnlibrary;

import com.github.bgora.rpnlibrary.functions.AbstractFunctionStrategy;
import com.github.bgora.rpnlibrary.functions.CosFunctionStrategy;
import com.github.bgora.rpnlibrary.functions.CtgFunctionStrategy;
import com.github.bgora.rpnlibrary.functions.FibFunctionStrategy;
import com.github.bgora.rpnlibrary.functions.MaxFunctionStrategy;
import com.github.bgora.rpnlibrary.functions.MinFunctionStrategy;
import com.github.bgora.rpnlibrary.functions.SinusFunctionStrategy;
import com.github.bgora.rpnlibrary.functions.TanFunctionStrategy;
import com.github.bgora.rpnlibrary.operators.AbstractOperatorStrategy;
import com.github.bgora.rpnlibrary.operators.AddOperatorStrategy;
import com.github.bgora.rpnlibrary.operators.DivideOperatorStrategy;
import com.github.bgora.rpnlibrary.operators.MultiplyOperatorStrategy;
import com.github.bgora.rpnlibrary.operators.PowerOperatorStrategy;
import com.github.bgora.rpnlibrary.operators.SubtractOperatorStrategy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


public class DefaultStrategyProviderTest {
    final StrategyProvider tested = new DefaultStrategyProvider();


    private static Stream<Arguments> operatorStrategies() {
        return Stream.of(
                Arguments.of("+", new AddOperatorStrategy()),
                Arguments.of("-", new SubtractOperatorStrategy()),
                Arguments.of("*", new MultiplyOperatorStrategy()),
                Arguments.of("/", new DivideOperatorStrategy()),
                Arguments.of("^", new PowerOperatorStrategy())
        );
    }


    @ParameterizedTest
    @MethodSource("operatorStrategies")
    void getOperatorShouldReturnOperator(String operator, AbstractOperatorStrategy expectedStrategy) {
        AbstractOperatorStrategy abstractOperatorStrategy = tested.getOperator(operator);

        assertThat(abstractOperatorStrategy).isEqualTo(expectedStrategy);

    }

    @Test
    void getOperatorShouldReturnNullForInvalidName() {
        AbstractOperatorStrategy strategy = tested.getOperator("@");

        assertThat(strategy).isNull();
    }

    @Test
    void isOperatorShouldReturnFalseForNotExistingOperator() {
        boolean operatorAvailable = tested.isOperatorAvailable("@");

        assertThat(operatorAvailable).isFalse();
    }

    private static Stream<Arguments> availableOperators() {
        return Stream.of(
                Arguments.of("+", true),
                Arguments.of("-", true),
                Arguments.of("*", true),
                Arguments.of("/", true),
                Arguments.of("^", true)
        );
    }

    @ParameterizedTest
    @MethodSource("availableOperators")
    void isOperatorShouldReturnTrueForExistingOperator(String operator, boolean expected) {
        boolean operatorAvailable = tested.isOperatorAvailable(operator);

        assertThat(operatorAvailable).isEqualTo(expected);
    }

    private static Stream<Arguments> functionStrategies() {
        return Stream.of(
                Arguments.of("sin", new SinusFunctionStrategy()),
                Arguments.of("cos", new CosFunctionStrategy()),
                Arguments.of("fib", new FibFunctionStrategy()),
                Arguments.of("tg", new TanFunctionStrategy()),
                Arguments.of("ctg", new CtgFunctionStrategy()),
                Arguments.of("max", new MaxFunctionStrategy()),
                Arguments.of("min", new MinFunctionStrategy())
        );
    }

    private static Stream<Arguments> availableFunctions() {
        return Stream.of(
                Arguments.of("sin", true),
                Arguments.of("cos", true),
                Arguments.of("fib", true),
                Arguments.of("tg", true),
                Arguments.of("ctg", true),
                Arguments.of("max", true),
                Arguments.of("min", true)
        );

    }

    @ParameterizedTest
    @MethodSource("functionStrategies")
    void getFunctionShouldReturnStrategy(String function, AbstractFunctionStrategy expectedStrategy) {
        AbstractFunctionStrategy functionStrategy = tested.getFunction(function);

        assertThat(functionStrategy).isEqualTo(expectedStrategy);
    }


    @Test
    void getFunctionShouldReturnNullForInvalidFunctionName() {
        AbstractFunctionStrategy functionStrategy = tested.getFunction("function");

        assertThat(functionStrategy).isNull();
    }


    @Test
    void isFunctionShouldReturnFalseForNotExitingFunction() {
        boolean functionStrategy = tested.isFunctionAvailable("function");

        assertThat(functionStrategy).isFalse();
    }


    @ParameterizedTest
    @MethodSource("availableFunctions")
    void isFunctionAvailableShouldReturnTrueForExistingFunction(String function, boolean expected) {

        boolean operatorAvailable = tested.isFunctionAvailable(function);

        assertThat(operatorAvailable).isEqualTo(expected);
    }

}
