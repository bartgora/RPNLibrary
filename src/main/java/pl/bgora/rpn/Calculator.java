/*
    RPNCalculator - Reverse Polish Notation mathematics Library
    Copyright (C) 2011  Bartłomiej "Black007" Góra

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package pl.bgora.rpn;

import pl.bgora.rpn.exceptions.NoSuchFunctionFound;
import pl.bgora.rpn.exceptions.WrongArgumentException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Deque;
import java.util.LinkedList;


/**
 * RPN Calculator Implementation with functions.
 * <p/>
 *
 * @author Bartłomiej Góra (bartlomiej.gora@gmail.com)
 */
public class Calculator implements CalculatorInterface {


    protected RPNChecking checker;

    protected RPNExecuting executioner;

    protected RoundingMode roundingMode;


    /**
     * Factory Method for RPN calculator object. Creates RPN Calulcator with
     * default Chcecker, and Executioner. Executioner Uses
     * {@code java.math.RoundingMode.HALF_EVEN} for calculations. Fallowing is
     * explanation of this: A tie-breaking rule that is even less biased is
     * round half to even, namely
     * <p/>
     * If the fraction of y is 0.5, then q is the even integer nearest to y.
     * <p/>
     * Thus, for example, +23.5 becomes +24, +22.5 becomes +22, 22.5 becomes
     * 22, and 23.5 becomes 24.
     * <p/>
     * This method also treats positive and negative values symmetrically, and
     * therefore is free of overall bias if the original numbers are positive or
     * negative with equal probability. In addition, for most reasonable
     * distributions of y values, the expected (average) value of the rounded
     * numbers is essentially the same as that of the original numbers, even if
     * the latter are all positive (or all negative). However, this rule will
     * still introduce a positive bias for even numbers (including zero), and a
     * negative bias for the odd ones.
     * <p/>
     * This variant of the round-to-nearest method is also called unbiased
     * rounding (ambiguously, and a bit abusively), convergent rounding,
     * statistician's rounding, Dutch rounding, Gaussian rounding, or bankers'
     * rounding. This is widely used in bookkeeping.
     * <p/>
     * This is the default rounding mode used in IEEE 754 computing functions
     * and operators.
     * {@link http://en.wikipedia.org/wiki/Rounding#Round_half_to_even}
     *
     * @return Calculator Object.
     * @see java.math.RoundingMode
     */
    public static Calculator createDefaultCalculator() {
        return createDefaultCalculator(RoundingMode.HALF_EVEN);
    }

    /**
     * Factory Method for RPN calculator object.
     *
     * @param mode Rounding Mode for calculations.
     * @return Calculator Object.
     */
    public static Calculator createDefaultCalculator(RoundingMode mode) {
        return new Calculator(new DefaultChecker(), new DefaultExecutioner(), mode);
    }

    /**
     * Factory method for RPN Calculator object with custom functions, and
     * operations. You should use this factory method if you want to create your
     * own operations. To do so, you have to implement you own objectst, that
     * implementas {@code pl.bgora.rpn.RPNChecking}, and
     * {@code pl.bgora.rpn.RPNExecuting}.
     *
     * @param mode        Rounding Mode for calculations.
     * @param checker     Custom Checker object.
     * @param executioner custom executioner object
     * @return new Instance of {@code pl.bgora.Calculator}
     * @see pl.bgora.rpn.RPNChecking
     * @see pl.bgora.rpn.RPNExecuting
     */
    public static Calculator createCalculator(RoundingMode mode, RPNChecking checker, RPNExecuting executioner) {
        return new Calculator(checker, executioner, mode);
    }


    /**
     * Constructor Creates an instance of the class.
     *
     * @param checker     Object that implementa RPNChecking - Used for checking operations in input.
     * @param executioner Object iplementing RPNExecuting - used for executing operations on input.
     * @param mode        Rounding mode for arithmetic operations.
     */
    Calculator(RPNChecking checker, RPNExecuting executioner, RoundingMode mode) {
        this.checker = checker;
        this.executioner = executioner;
        this.roundingMode = mode;
    }


    /**
     * Calculates RPN String into BigDecimal Object.
     *
     * @throws NoSuchFunctionFound
     * @see pl.bgora.rpn.Calculator#calculate(java.lang.String)
     */
    @Override
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
     *                                unsupported opertians)
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
        // Iteration throght input String.
        for (int i = 0; i < length; i++) {
            c = inputValue.charAt(i);
            if ((Character.isDigit(c) || c == '.' || c == ',') && (lastWasDigit || !lastWasOperator)) {
                //for BigDecimal
                if (c == ',') {
                    c = '.';
                }
                lastWasDigit = true;
                result.append(c);
                lastWasWhiteSpace = false;
                lastWasLetter = false;
                continue;
            } else if (Character.isDigit(c)) {
                lastWasDigit = true;
                lastWasLetter = false;
                lastWasOperator = false;
                if (!lastWasWhiteSpace) {
                    result.append(" ");
                }
                result.append(c);
                lastWasWhiteSpace = false;
                continue;
            } else if (checker.isOperatorOrBracket(String.valueOf(c))) {
                lastWasDigit = false;
                lastWasLetter = false;
                lastWasOperator = true;
                if (!lastWasWhiteSpace) {
                    result.append(" ");
                }
                result.append(c);
                lastWasWhiteSpace = false;
                continue;
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
                continue;
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

    /**
     * Creates String in Reverse Polish Notation.
     *
     * @param input Input String in "Natural" format.
     * @return String formatted into RPN.
     * @throws WrongArgumentException Thrown if the input is incorrect (Incorrect format, or
     *                                unsupported opertians)
     */
    private String createRPN(String input) throws WrongArgumentException {
        input = input.trim();
        StringBuilder result = new StringBuilder();
        Deque<String> stack = new LinkedList<String>();
        String[] factors = input.split(" ");
        int length = factors.length;
        String temp = null;
        String stackOper = null;
        for (int i = 0; i < length; i++) {
            temp = factors[i];
            if (checker.isDigit(temp)) {
                // input String.
                result.append(" ").append(temp);
            } else if (checker.isFunction(temp)) {
                stack.push(temp);
            } else if (",".equals(temp)) {
                do {
                    stackOper = stack.pop();
                    if (!checker.isLeftBracket(stackOper)) {
                        result.append(" ").append(stackOper);
                    }
                } while (!stack.isEmpty() && !checker.isLeftBracket(stackOper));
            } else if (checker.isOperator(temp)) {
                // 1) until the top of the stack is an operator, o2 such that:
                // O1 is the total or left-total and its sequence
                // Execution is less than or equal to the order of execution o2, or
                // O1 is right-total and the order of execution
                // Is less than o2,
                // Remove O2 from the stack and add it to the output queue;
                // 2) o1 put on the stack operators.
                while (!stack.isEmpty() && checker.isOperator(stack.peek())) {
                    stackOper = stack.peek();
                    if (checker.isLeftAssociativity(stackOper) && (checker.compareOperators(stackOper, temp) >= 0)) {
                        stack.pop();
                        result.append(" ").append(stackOper);
                    } else if (checker.isRightAssociativity(stackOper)
                            && (checker.compareOperators(stackOper, temp) > 0)) {
                        stack.pop();
                        result.append(" ").append(stackOper);
                    } else {
                        break;
                    }
                }

                // 2.
                stack.push(temp);
            } else if (checker.isLeftBracket(temp)) {
                // put on stack
                stack.push(temp);
            } else if (checker.isRightBracket(temp)) {
                // Download from the stack and place the items on the exit until you
                // Get a left parenthesis.
                // Left bracket oil (and right too)
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
                // If there is anything that can be recognized ....
                throw new WrongArgumentException("Element \"" + temp + "\" is not recognized by the Checker");
            }
        }
        // End of entry, empty the stack.
        temp = null;
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
        String temp = null;
        String var1 = null;
        String var2 = null;
        BigDecimal value = null;
        for (int i = 0; i < factors.length; i++) {
            temp = factors[i];
            if (checker.isDigit(temp)) {
                stack.push(temp);
            } else if (checker.isOperator(temp)) {
                var1 = stack.pop();
                if (!stack.isEmpty()) {
                    var2 = stack.pop();
                } else {
                    var2 = "0.0";
                }
                value = executioner.executeOperator(temp, var2, var1, roundingMode);
                stack.push(value.toPlainString());
            } else if (checker.isFunction(temp)) {
                int count = checker.getFunctionParamsCount(temp);
                String[] table = new String[count];
                for (int j = 0; j < count; j++) {
                    table[j] = stack.pop();
                }
                value = executioner.executeFunction(temp, roundingMode, table);
                stack.push(value.toPlainString());
            }
        }
        return new BigDecimal(stack.pop());
    }
}
