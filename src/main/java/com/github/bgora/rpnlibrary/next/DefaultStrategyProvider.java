package com.github.bgora.rpnlibrary.next;

import com.github.bgora.rpnlibrary.functions.AbstractFunctionStrategy;
import com.github.bgora.rpnlibrary.operators.AbstractOperatorStrategy;
import com.github.bgora.rpnlibrary.operators.AddOperatorStrategy;

public class DefaultStrategyProvider implements StrategyProvider{

    @Override
    public AbstractOperatorStrategy getOperator(final String operator) {
        return new AddOperatorStrategy();
    }

    @Override
    public boolean isOperatorAvailable(final String operator) {
        return false;
    }

    @Override
    public AbstractFunctionStrategy getFunction(final String name) {
        return null;
    }

    @Override
    public boolean isFunctionAvailable(final String name) {
        return false;
    }

    @Override
    public void addFunction(final AbstractFunctionStrategy functionStrategy) {

    }

    @Override
    public void addOperator(final AbstractOperatorStrategy operatorStrategy) {

    }
}
