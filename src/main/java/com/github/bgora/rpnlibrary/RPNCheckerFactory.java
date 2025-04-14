package com.github.bgora.rpnlibrary;

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

        operators.put("+", 1);
        operators.put("-", 1);
        operators.put("*", 2);
        operators.put("/", 2);
        operators.put("^", 3);


        functions.put("sin", 1);
        functions.put("cos", 1);
        functions.put("tg", 1);
        functions.put("ctg", 1);
        functions.put("min", 2);
        functions.put("max", 2);
        functions.put("fib", 1);

        return new DefaultRPNChecker(operators, functions);

    }
}
