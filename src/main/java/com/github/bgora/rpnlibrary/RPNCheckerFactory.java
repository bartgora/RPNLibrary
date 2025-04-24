package com.github.bgora.rpnlibrary;

import java.util.HashMap;
import java.util.Map;

/**
 * Factory for creating new instances of RPNChecker
 *
 * @see RPNChecker
 */
public class RPNCheckerFactory {

    /**
     * Creates new RPNChecker instance with default operators,and functions
     * <p>
     * operators: + ,- ,* , /, ^ (power)
     * functions: sin(), cos(), tg(), ctg(), min(x,y), max(x,y), fib()
     *
     * @return RPNChecker
     */
    public static RPNChecker createRPNChecker() {
        return new DefaultRPNChecker();
    }

    /**
     * Creates new RPNChecker instance with given operations and functions
     *
     * @param operators Map of operators + order
     * @param functions Map of function names + param count
     * @return RPNChecker
     */
    public static RPNChecker createNewRPNChecker(final Map<String, Integer> operators, final Map<String, Integer> functions) {
        return new DefaultRPNChecker(operators, functions);
    }

    /**
     * Creates new RPNChecker instance with given operations and functions, also keeping the default one
     *
     * @param operators Map of operators + order
     * @param functions Map of function names + param count
     * @return RPNChecker
     */

    public static RPNChecker createRPNCheckerWithDefaults(final Map<String, Integer> operators, final Map<String, Integer> functions) {
        Map<String, Integer> defaultOperators = new HashMap<>();
        defaultOperators.put("+", 1);
        defaultOperators.put("-", 1);
        defaultOperators.put("*", 2);
        defaultOperators.put("/", 2);
        defaultOperators.put("^", 3);
        if (!operators.isEmpty()) {
            defaultOperators.putAll(operators);
        }

        Map<String, Integer> defaultFunctions = new HashMap<>();
        defaultFunctions.put("sin", 1);
        defaultFunctions.put("cos", 1);
        defaultFunctions.put("tg", 1);
        defaultFunctions.put("ctg", 1);
        defaultFunctions.put("min", 2);
        defaultFunctions.put("max", 2);
        defaultFunctions.put("fib", 1);
        if (!functions.isEmpty()) {
            defaultFunctions.putAll(functions);
        }

        return new DefaultRPNChecker(defaultOperators, defaultFunctions);

    }
}
