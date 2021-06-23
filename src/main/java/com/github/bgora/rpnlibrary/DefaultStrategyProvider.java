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

import java.util.HashMap;
import java.util.Map;

/**
 * Default implementation of StrategyProvider.
 * Provides:
 * operators: +,-,/,*
 * functions:
 * sin(), cos(), tg(), ctg(), fib(), max(), min()
 *
 * @see StrategyProvider
 * @see AbstractFunctionStrategy
 * @see AbstractOperatorStrategy
 */
public class DefaultStrategyProvider implements StrategyProvider {

    private Map<String, AbstractOperatorStrategy> operators;
    private Map<String, AbstractFunctionStrategy> functions;

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

        functions = new HashMap<>();
        AbstractFunctionStrategy cosFunction = new CosFunctionStrategy();
        functions.put(cosFunction.getName(), cosFunction);
        AbstractFunctionStrategy sinFunction = new SinusFunctionStrategy();
        functions.put(sinFunction.getName(), sinFunction);
        AbstractFunctionStrategy tanFunction = new TanFunctionStrategy();
        functions.put(tanFunction.getName(), tanFunction);
        AbstractFunctionStrategy ctgFunction = new CtgFunctionStrategy();
        functions.put(ctgFunction.getName(), ctgFunction);
        AbstractFunctionStrategy fibFunction = new FibFunctionStrategy();
        functions.put(fibFunction.getName(), fibFunction);
        AbstractFunctionStrategy maxFunction = new MaxFunctionStrategy();
        functions.put(maxFunction.getName(), maxFunction);
        AbstractFunctionStrategy minFunction = new MinFunctionStrategy();
        functions.put(minFunction.getName(), minFunction);
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
        return functions.get(name);
    }

    @Override
    public boolean isFunctionAvailable(final String name) {
        return functions.containsKey(name);
    }

}
