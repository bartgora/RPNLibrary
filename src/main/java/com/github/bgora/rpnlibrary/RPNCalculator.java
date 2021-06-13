package com.github.bgora.rpnlibrary;


import com.github.bgora.rpnlibrary.exceptions.NoSuchFunctionFound;
import com.github.bgora.rpnlibrary.exceptions.WrongArgumentException;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Deque;
import java.util.LinkedList;
import java.util.function.Function;

/**
 * RPN Calculator Implementation with functions.
 * This Implementation uses Dijkstra Algorithm to create Reverse Polish Notation.
 *
 * @author Bartłomiej Góra (bartlomiej.gora@gmail.com)
 */
public class RPNCalculator implements Function<String, BigDecimal> {
    public static final String ZERO = "0.0";
    public static final String EMPTY_SPACE = " ";
    public static final String COMMA = ",";
    private final int SCALE;

    protected final RPNChecking checker;
    protected final RPNExecuting executioner;
    protected final MathContext mathContext;

    /**
     *
     * @param scale scale with
     * @param checker
     * @param executioner
     * @param mathContext
     */
    public RPNCalculator(final int scale, final RPNChecking checker, final RPNExecuting executioner, final MathContext mathContext) {
        this.SCALE = scale;
        this.checker = checker;
        this.executioner = executioner;
        this.mathContext = mathContext;
    }

    /**
     * Calculates RPN String into BigDecimal.
     *
     * @param result Input RPN String
     * @return value as {@code java.math.BigDecimal}
     * @throws WrongArgumentException Thrown when typed in character is not recognized
     * @throws NoSuchFunctionFound Thrown when user typed in absent function's name
     */
    public BigDecimal apply(String result) throws WrongArgumentException, NoSuchFunctionFound {
        final String[] factors = result.trim().split(EMPTY_SPACE);
        final Deque<String> stack = new LinkedList<>();
        String temp;
        String variable1;
        String variable2;
        BigDecimal value;
        for (final String factor : factors) {
            temp = factor;
            if (checker.isDigit(temp)) {
                stack.push(temp);
            } else if (checker.isOperator(temp)) {
                variable1 = stack.pop();
                if (!stack.isEmpty()) {
                    variable2 = stack.pop();
                } else {
                    variable2 = ZERO;
                }
                value = executioner.executeOperator(temp, mathContext, variable2, variable1);
                stack.push(value.toPlainString());
            } else if (checker.isFunction(temp)) {
                int count = checker.getFunctionParamsCount(temp);
                String[] table = new String[count];
                String params = stack.pop();
                String[] paramsTable = params.split(COMMA);
                if (count >= 0) System.arraycopy(paramsTable, 0, table, 0, count);
                value = executioner.executeFunction(temp, mathContext, table);
                stack.push(value.toPlainString());
            }
        }
        return new BigDecimal(stack.pop()).setScale(SCALE, mathContext.getRoundingMode());
    }
}
