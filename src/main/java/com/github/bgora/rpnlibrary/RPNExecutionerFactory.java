package com.github.bgora.rpnlibrary;

import com.github.bgora.rpnlibrary.functions.AbstractFunctionStrategy;
import com.github.bgora.rpnlibrary.functions.DefaultFunctionProvider;
import com.github.bgora.rpnlibrary.operators.AbstractOperatorStrategy;
import com.github.bgora.rpnlibrary.operators.DefaultOperatorsProvider;

import java.util.Map;

/**
 * Factory for creating new instances of RPNExecutioner
 *
 * @see RPNExecutioner
 */
public class RPNExecutionerFactory {
    /**
     * Creates new RPNExecutioner instance with default operators,and functions
     * <p>
     * operators: + ,- ,* , /, ^ (power)
     * functions: sin(), cos(), tg(), ctg(), min(x,y), max(x,y), fib()
     *
     * @return RPNExecutioner
     */

    public static RPNExecutioner createRPNExecutioner() {
        DefaultOperatorsProvider operatorsProvider = new DefaultOperatorsProvider();
        DefaultFunctionProvider functionProvider = new DefaultFunctionProvider();
        return new DefaultRPNExecutioner(operatorsProvider.getOperators(), functionProvider.getFunctions());
    }

    /**
     * Creates new RPNExecutioner instance with given operators,and functions
     * <p>
     * Takes two maps with AbstractOperatorStrategy, and AbstractFunctionStrategy, to calculate.
     *
     * @param operators Map containing AbstractOperatorStrategy identified by it's operator
     * @param functions Map containing AbstractFunctionStrategy identified by it's name
     *
     * @return RPNExecutioner
     */
    public static RPNExecutioner createRPNExecutioner(
            Map<String, AbstractOperatorStrategy> operators, Map<String, AbstractFunctionStrategy> functions) {
        return new DefaultRPNExecutioner(operators, functions);
    }

    /**
     * Creates new RPNExecutioner instance with given operations and functions, also keeping the default one
     *<p>
     * @param operators Map containing AbstractOperatorStrategy identified by it's operator
     * @param functions Map containing AbstractFunctionStrategy identified by it's name
     *
     * @return RPNExecutioner
     */
    public static RPNExecutioner createRPNExecutionerWithDefaults(
            Map<String, AbstractOperatorStrategy> operators, Map<String, AbstractFunctionStrategy> functions) {
        DefaultOperatorsProvider operatorsProvider = new DefaultOperatorsProvider();
        DefaultFunctionProvider functionProvider = new DefaultFunctionProvider();

        Map<String, AbstractOperatorStrategy> defaultOperators = operatorsProvider.getOperators();
        if(!operators.isEmpty()){
            defaultOperators.putAll(operators);
        }
        Map<String, AbstractFunctionStrategy> defaultFunctions = functionProvider.getFunctions();
        if(!functions.isEmpty()){
            defaultFunctions.putAll(functions);
        }

        defaultOperators.putAll(operatorsProvider.getOperators());
        defaultFunctions.putAll(functionProvider.getFunctions());
        return new DefaultRPNExecutioner(defaultOperators, defaultFunctions);
    }
}
