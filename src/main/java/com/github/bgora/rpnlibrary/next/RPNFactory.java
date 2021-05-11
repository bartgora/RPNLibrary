package com.github.bgora.rpnlibrary.next;

import com.github.bgora.rpnlibrary.RPNChecking;
import com.github.bgora.rpnlibrary.exceptions.WrongArgumentException;

import java.util.Deque;
import java.util.LinkedList;

public class RPNFactory {

    public static final String ZERO = "0.0";
    public static final String EMPTY_SPACE = " ";
    public static final String COMMA = ",";
    protected final RPNChecking checker;


    public RPNFactory(final RPNChecking checker) {
        this.checker = checker;
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
        final String trimmed = input.trim();
        final StringBuilder result = new StringBuilder();
        final Deque<String> stack = new LinkedList<>();
        final String[] factors = trimmed.split(EMPTY_SPACE);
        final int length = factors.length;
        String temp;
        String stackOperator;
        for (int i = 0; i < length; i++) {
            temp = factors[i];
            if (checker.isDigit(temp)) {
                result.append(EMPTY_SPACE).append(temp);
            } else if (checker.isFunction(temp)) {
                stack.push(temp);
            } else if (COMMA.equals(temp)) {
                do {
                    stackOperator = stack.pop();
                    if (!checker.isLeftBracket(stackOperator)) {
                        result.append(EMPTY_SPACE).append(stackOperator);
                    }
                } while (!stack.isEmpty() && !checker.isLeftBracket(stackOperator));
            } else if (checker.isOperator(temp)) {
                while (!stack.isEmpty() && checker.isOperator(stack.peek())) {
                    stackOperator = stack.peek();
                    if (checker.isLeftAssociativity(stackOperator) && (checker.compareOperators(stackOperator,
                            temp) >= 0)) {
                        stack.pop();
                        result.append(EMPTY_SPACE).append(stackOperator);
                    } else if (checker.isRightAssociativity(stackOperator)
                            && (checker.compareOperators(stackOperator, temp) > 0)) {
                        stack.pop();
                        result.append(EMPTY_SPACE).append(stackOperator);
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
                        result.append(EMPTY_SPACE).append(temp);
                    }
                } while (!checker.isLeftBracket(temp));
                if (!stack.isEmpty() && checker.isFunction(stack.peek())) {
                    result.append(EMPTY_SPACE).append(stack.pop());
                }
            } else {
                throw new WrongArgumentException("Element \"" + temp + "\" is not recognized by the Checker");
            }
        }
        while (!stack.isEmpty()) {
            result.append(EMPTY_SPACE).append(stack.pop());
        }

        return result.toString().trim();
    }
}
