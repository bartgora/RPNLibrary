package com.github.bgora.rpnlibrary;

import com.github.bgora.rpnlibrary.functions.AbstractFunctionStrategy;
import com.github.bgora.rpnlibrary.operators.AbstractOperatorStrategy;

/**
 * Provides Operators, and Functions strategies
 *
 * @see AbstractOperatorStrategy
 * @see AbstractFunctionStrategy
 */
public interface StrategyProvider {

    AbstractOperatorStrategy getOperator(String operator);

    boolean isOperatorAvailable(String operator);

    AbstractFunctionStrategy getFunction(String name);

    boolean isFunctionAvailable(String name);

}
