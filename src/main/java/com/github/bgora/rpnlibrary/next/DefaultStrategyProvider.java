package com.github.bgora.rpnlibrary.next;

import com.github.bgora.rpnlibrary.functions.AbstractFunctionStrategy;
import com.github.bgora.rpnlibrary.operators.AbstractOperatorStrategy;
import com.github.bgora.rpnlibrary.operators.AddOperatorStrategy;
import com.github.bgora.rpnlibrary.operators.DivideOperatorStrategy;
import com.github.bgora.rpnlibrary.operators.SubtractOperatorStrategy;
import com.github.bgora.rpnlibrary.operators.MultiplyOperatorStrategy;
import com.github.bgora.rpnlibrary.operators.PowerOperatorStrategy;

import java.util.HashMap;
import java.util.Map;

public class DefaultStrategyProvider implements StrategyProvider{

    private Map<String, AbstractOperatorStrategy> operators;

    public DefaultStrategyProvider() {
        operators = new HashMap<>();
        AbstractOperatorStrategy addOperatorStrategy = new AddOperatorStrategy();
        operators.put(addOperatorStrategy.getOperator(), addOperatorStrategy);
        AbstractOperatorStrategy subtractOperatorStrategy = new SubtractOperatorStrategy();
        operators.put(subtractOperatorStrategy.getOperator(), subtractOperatorStrategy);
        AbstractOperatorStrategy multiplyOperatorStrategy = new MultiplyOperatorStrategy();
        operators.put(multiplyOperatorStrategy.getOperator(), multiplyOperatorStrategy);
        AbstractOperatorStrategy divideOperatorStrategy = new DivideOperatorStrategy();
        operators.put(divideOperatorStrategy.getOperator(), divideOperatorStrategy);
        AbstractOperatorStrategy powerOperatorStrategy = new PowerOperatorStrategy();
        operators.put(powerOperatorStrategy.getOperator(), powerOperatorStrategy);
    }

    @Override
    public AbstractOperatorStrategy getOperator(final String operator) {
        return operators.get(operator);
    }

    @Override
    public boolean isOperatorAvailable(final String operator) {
        return operators.containsKey(operator);
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
