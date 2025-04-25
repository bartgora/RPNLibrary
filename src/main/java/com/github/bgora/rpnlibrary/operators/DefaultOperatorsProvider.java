package com.github.bgora.rpnlibrary.operators;

import java.util.HashMap;
import java.util.Map;

public class DefaultOperatorsProvider implements OperatorsProvider {
    Map<String, AbstractOperatorStrategy> DEFAULT_OPERATORS = new HashMap<String, AbstractOperatorStrategy>();

    @Override
    public Map<String, AbstractOperatorStrategy> getOperators() {
        AbstractOperatorStrategy addOperatorStrategy = new AddOperatorStrategy();
        DEFAULT_OPERATORS.put(addOperatorStrategy.getOperator(), addOperatorStrategy);
        AbstractOperatorStrategy minusOperatorStrategy = new MinusOperatorStrategy();
        DEFAULT_OPERATORS.put(minusOperatorStrategy.getOperator(), minusOperatorStrategy);
        AbstractOperatorStrategy multiplyOperatorStrategy = new MultiplyOperatorStrategy();
        DEFAULT_OPERATORS.put(multiplyOperatorStrategy.getOperator(), multiplyOperatorStrategy);
        AbstractOperatorStrategy divideOperatorStrategy = new DivideOperatorStrategy();
        DEFAULT_OPERATORS.put(divideOperatorStrategy.getOperator(), divideOperatorStrategy);
        AbstractOperatorStrategy powerOperatorStrategy = new PowerOperatorStrategy();
        DEFAULT_OPERATORS.put(powerOperatorStrategy.getOperator(), powerOperatorStrategy);
        return DEFAULT_OPERATORS;
    }
}
