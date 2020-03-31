/*
 * RPNLibrary - Reverse Polish Notation Library
 * Copyright (C) 2011  Bartłomiej Góra
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * Contact: bartlomiej.gora@gmail.com
 */

package com.github.bgora.rpnlibrary;

import com.github.bgora.rpnlibrary.advanced.StrategiesUtil;
import com.github.bgora.rpnlibrary.exceptions.NoSuchFunctionFound;
import com.github.bgora.rpnlibrary.exceptions.WrongArgumentException;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Deque;
import java.util.LinkedList;


/**
 * RPN Calculator Implementation with functions.
 * This Implementation uses Dijkstra Algorithm to create Reverse Polish Notation.
 *
 * @author Bartłomiej Góra (bartlomiej.gora@gmail.com)
 */
public class Calculator {


    protected RPNChecking checker;
    protected RPNExecuting executioner;
    private MathContext mathContext;


    /**
     * Factory method for RPN Calculator object with custom functions, and
     * operations. You should use this factory method if you want to create your
     * own operations. To do so, you have to implement you own objectst, that
     * implementas {@code RPNChecking}, and
     * {@code RPNExecuting}.
     *
     * @return new Instance of {@code pl.bgora.Calculator}
     * @see RPNChecking
     * @see RPNExecuting
     */
    public static Calculator createCalculator() {
        final CalculationEngine calculationEngine = new CalculatorEngine(StrategiesUtil.DEFAULT_OPERATORS, StrategiesUtil.DEFAULT_FUNCTIONS);
        final MathContext mathContext = new MathContext(2, RoundingMode.HALF_EVEN);
        return new Calculator(calculationEngine, calculationEngine, mathContext);
    }


    /**
     * Constructor Creates an instance of the class.
     *
     * @param checker     Object implementing RPNChecking - Used for checking operations in input.
     * @param executioner Object implementing RPNExecuting - used for executing operations on input.
     * @param mathContext
     */
    private Calculator(RPNChecking checker, RPNExecuting executioner, final MathContext mathContext) {
        this.checker = checker;
        this.executioner = executioner;
        this.mathContext = mathContext;
    }

    public BigDecimal calculate(final String input) throws WrongArgumentException, NoSuchFunctionFound {
        final String temp = prepareInput(input);
        final String result = createRPN(temp);
        return getResult(result);
    }


    /**
     * Format input for further processing.
     *
     * @param input Input string.
     * @return Formatted String.
     * @throws WrongArgumentException Thrown if the input is incorrect (Incorrect format, or
     *                                unsupported operations)
     */
    private String prepareInput(String input) throws WrongArgumentException {
        StringBuilder result = new StringBuilder();
        String inputValue = input.trim();
        int length = inputValue.length();
        char c = 0;
        boolean lastWasDigit = false;
        boolean lastWasOperator = false;
        boolean lastWasWhiteSpace = false;
        boolean lastWasLetter = false;
        // Iteration thought input String.
        for (int i = 0; i < length; i++) {
            c = inputValue.charAt(i);
            if (isDigitOrSeparator(c) && (lastWasDigit || !lastWasOperator)) {
                lastWasDigit = true;
                result.append(c);
                lastWasWhiteSpace = false;
                lastWasLetter = false;
            } else if (Character.isDigit(c)) {
                lastWasDigit = true;
                lastWasLetter = false;
                lastWasOperator = false;
                if (!lastWasWhiteSpace) {
                    result.append(" ");
                }
                result.append(c);
                lastWasWhiteSpace = false;
            } else if (checker.isOperatorOrBracket(String.valueOf(c))) {
                lastWasDigit = false;
                lastWasLetter = false;
                lastWasOperator = true;
                if (!lastWasWhiteSpace) {
                    result.append(" ");
                }
                result.append(c);
                lastWasWhiteSpace = false;
            } else if (Character.isWhitespace(c)) {
                // Check Next digit, if it is digit then
                // erase whitespace
                // and place digit ex.: 12 456 -> 12456
                if (!lastWasWhiteSpace && !lastWasDigit) {
                    result.append(" ");
                    lastWasWhiteSpace = true;
                }
                lastWasDigit = false;
                lastWasOperator = false;
            } else if (Character.isLetter(c)) {
                lastWasDigit = false;
                lastWasOperator = false;
                if (!lastWasLetter && !lastWasWhiteSpace) {
                    result.append(" ").append(c);
                } else {
                    result.append(c);
                }
                lastWasWhiteSpace = false;
                lastWasLetter = true;
            } else {
                throw new WrongArgumentException("Element \"" + c + "\" is not recognized by the Checker");
            }
        }

        return result.toString().trim();
    }

    private boolean isDigitOrSeparator(char c) {
        return Character.isDigit(c) || c == '.' || c == ',';
    }

    /**
     * Creates String in Reverse Polish Notation.
     *
     * @param input Input String in "Natural" format.
     * @return String formatted into RPN.
     * @throws WrongArgumentException Thrown if the input is incorrect (Incorrect format, or
     *                                unsupported opertians)
     */
    private String createRPN(String input) throws WrongArgumentException {
        String trimmed = input.trim();
        StringBuilder result = new StringBuilder();
        Deque<String> stack = new LinkedList<String>();
        String[] factors = trimmed.split(" ");
        int length = factors.length;
        String temp;
        String stackOperator;
        for (int i = 0; i < length; i++) {
            temp = factors[i];
            if (checker.isDigit(temp)) {
                // input String.
                result.append(" ").append(temp);
            } else if (checker.isFunction(temp)) {
                stack.push(temp);
            } else if (",".equals(temp)) {
                do {
                    stackOperator = stack.pop();
                    if (!checker.isLeftBracket(stackOperator)) {
                        result.append(" ").append(stackOperator);
                    }
                } while (!stack.isEmpty() && !checker.isLeftBracket(stackOperator));
            } else if (checker.isOperator(temp)) {
                while (!stack.isEmpty() && checker.isOperator(stack.peek())) {
                    stackOperator = stack.peek();
                    if (checker.isLeftAssociativity(stackOperator) && (checker.compareOperators(stackOperator, temp) >= 0)) {
                        stack.pop();
                        result.append(" ").append(stackOperator);
                    } else if (checker.isRightAssociativity(stackOperator)
                            && (checker.compareOperators(stackOperator, temp) > 0)) {
                        stack.pop();
                        result.append(" ").append(stackOperator);
                    } else {
                        break;
                    }
                }

                stack.push(temp);
            } else if (checker.isLeftBracket(temp)) {
                stack.push(temp);
            } else if (checker.isRightBracket(temp)) {
                do {
                    temp = stack.pop();
                    if (!checker.isLeftBracket(temp)) {
                        result.append(" ").append(temp);
                    }
                } while (!checker.isLeftBracket(temp));
                if (!stack.isEmpty() && checker.isFunction(stack.peek())) {
                    result.append(" ").append(stack.pop());
                }
            } else {
                throw new WrongArgumentException("Element \"" + temp + "\" is not recognized by the Checker");
            }
        }
        while (!stack.isEmpty()) {
            result.append(" ").append(stack.pop());
        }

        return result.toString().trim();
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
        String[] factors = result.trim().split(" ");
        Deque<String> stack = new LinkedList<String>();
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
                    variable2 = "0.0";
                }
                value = executioner.executeOperator(temp, mathContext, variable2, variable1);
                stack.push(value.toPlainString());
            } else if (checker.isFunction(temp)) {
                int count = checker.getFunctionParamsCount(temp);
                String[] table = new String[count];
                String params = stack.pop();
                String[] paramsTable = params.split(",");
                for (int j = 0; j < count; j++) {
                    table[j] = paramsTable[j];
                }
                value = executioner.executeFunction(temp, mathContext, table);
                stack.push(value.toPlainString());
            }
        }
        return new BigDecimal(stack.pop());
    }
}
