package com.github.bgora.rpnlibrary.next;

import com.github.bgora.rpnlibrary.RPNChecking;
import com.github.bgora.rpnlibrary.RPNExecuting;
import com.github.bgora.rpnlibrary.exceptions.NoSuchFunctionFound;
import com.github.bgora.rpnlibrary.exceptions.WrongArgumentException;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Deque;
import java.util.LinkedList;

public class RPNCalculator {
    public static final String ZERO = "0.0";
    public static final String EMPTY_SPACE = " ";
    public static final String COMMA = ",";
    private final int SCALE;

    protected final RPNChecking checker;
    protected final RPNExecuting executioner;
    protected final MathContext mathContext;

    public RPNCalculator(final int scale, final RPNChecking checker, final RPNExecuting executioner, final MathContext mathContext) {
        SCALE = scale;
        this.checker = checker;
        this.executioner = executioner;
        this.mathContext = mathContext;
    }

    /**
     * Calculates RPN String into BigDecimal.
     *
     * @param result Input RPN String
     * @return value as {@code java.math.BigDecimal}
     * @throws WrongArgumentException
     * @throws NoSuchFunctionFound
     */
    private BigDecimal getResult(String result) throws WrongArgumentException, NoSuchFunctionFound {
        final String[] factors = result.trim().split(EMPTY_SPACE);
        final Deque<String> stack = new LinkedList<String>();
        String temp;
        String variable1;
        String variable2;
        BigDecimal value;
        for (int i = 0; i < factors.length; i++) {
            temp = factors[i];
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
                for (int j = 0; j < count; j++) {
                    table[j] = paramsTable[j];
                }
                value = executioner.executeFunction(temp, mathContext, table);
                stack.push(value.toPlainString());
            }
        }
        return new BigDecimal(stack.pop()).setScale(SCALE, mathContext.getRoundingMode());
    }
}
