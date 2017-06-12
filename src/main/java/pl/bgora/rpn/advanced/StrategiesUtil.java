package pl.bgora.rpn.advanced;

import pl.bgora.rpn.advanced.functions.SinusFunctionStrategy;
import pl.bgora.rpn.advanced.operators.AddOperatorStrategy;
import pl.bgora.rpn.advanced.operators.MinusOperatorStrategy;

import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public final class StrategiesUtil {

    public static Map<String, AbstractOperatorStrategy> DEFAULT_OPERATORS = new HashMap<String, AbstractOperatorStrategy>();
    public static Map<String, AbstractFunctionStrategy> DEFAULT_FUNCTIONS = new HashMap<String, AbstractFunctionStrategy>();

    static {
        AbstractFunctionStrategy sinusFunctionStrategy = new SinusFunctionStrategy("sin", 1, RoundingMode.HALF_UP);
        DEFAULT_FUNCTIONS.put(sinusFunctionStrategy.getName(), sinusFunctionStrategy);

        AbstractOperatorStrategy addOperatorStrategy = new AddOperatorStrategy("+");
        AbstractOperatorStrategy minusOperatorStrategy = new MinusOperatorStrategy("-");
        DEFAULT_OPERATORS.put(addOperatorStrategy.getOperator(), addOperatorStrategy);
        DEFAULT_OPERATORS.put(minusOperatorStrategy.getOperator(), minusOperatorStrategy);


    }
}
