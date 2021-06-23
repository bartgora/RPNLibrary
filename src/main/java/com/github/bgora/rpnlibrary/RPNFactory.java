package com.github.bgora.rpnlibrary;

import com.github.bgora.rpnlibrary.exceptions.WrongArgumentException;

import java.util.Deque;
import java.util.LinkedList;
import java.util.function.UnaryOperator;

/**
 * Creates String in Reverse Polish Notation.
 *  example:  (2+3)*5 = 2 3 + 5 *
 *  First input must be transformed by InputTransformer, to add empty space
 *  between numbers, operator, and brackets
 *
 * @see InputTransformer
 */
public class RPNFactory implements UnaryOperator<String> {

    public static final String EMPTY_SPACE = " ";
    public static final String COMMA = ",";
    protected final RPNChecking checker;


    public RPNFactory(final RPNChecking checker) {
        this.checker = checker;
    }

    /**
     * Creates String in Reverse Polish Notation.
     *
     * example:  (2+3)×5 = 2 3 + 5 ×
     *
     * @param input Input String in "Natural" format.
     * @return String formatted into RPN.
     * @throws WrongArgumentException Thrown if the input is incorrect (Incorrect format, or
     *                                unsupported opertians)
     */
    public String apply(String input) throws WrongArgumentException {
        final String trimmed = input.trim();
        final StringBuilder result = new StringBuilder();
        final Deque<String> stack = new LinkedList<>();
        final String[] factors = trimmed.split(EMPTY_SPACE);
        for (String factor : factors) {
            if (checker.isDigit(factor)) {
                result.append(EMPTY_SPACE).append(factor);
            } else if (checker.isFunction(factor)) {
                stack.push(factor);
            } else if (COMMA.equals(factor)) {
                processComma(result, stack);
            } else if (checker.isOperator(factor)) {
                processOperator(result, stack, factor);
            } else if (checker.isLeftBracket(factor)) {
                stack.push(factor);
            } else if (checker.isRightBracket(factor)) {
                processRightBracket(result, stack);
            } else {
                throw new WrongArgumentException("Element \"" + factor + "\" is not recognized by the Checker");
            }
        }
        while (!stack.isEmpty()) {
            result.append(EMPTY_SPACE).append(stack.pop());
        }

        return result.toString().trim();
    }

    private void processRightBracket(final StringBuilder result, final Deque<String> stack) {
        String factor;
        do {
            factor = stack.pop();
            if (!checker.isLeftBracket(factor)) {
                result.append(EMPTY_SPACE).append(factor);
            }
        } while (!checker.isLeftBracket(factor));
        if (!stack.isEmpty() && checker.isFunction(stack.peek())) {
            result.append(EMPTY_SPACE).append(stack.pop());
        }
    }

    private void processComma(final StringBuilder result, final Deque<String> stack) {
        String stackOperator;
        do {
            stackOperator = stack.pop();
            if (!checker.isLeftBracket(stackOperator)) {
                result.append(EMPTY_SPACE).append(stackOperator);
            }
        } while (!stack.isEmpty() && !checker.isLeftBracket(stackOperator));
    }

    private void processOperator(final StringBuilder result, final Deque<String> stack, final String temp) {
        String stackOperator;
        while (!stack.isEmpty() && checker.isOperator(stack.peek())) {
            stackOperator = stack.peek();
            if (checker.isLeftAssociativity(stackOperator)
                    && (checker.compareOperators(stackOperator, temp) >= 0)) {
                appendEmptySpace(result, stack, stackOperator);
            } else if (checker.isRightAssociativity(stackOperator)
                    && (checker.compareOperators(stackOperator, temp) > 0)) {
                appendEmptySpace(result, stack, stackOperator);
            } else {
                break;
            }
        }
        stack.push(temp);
    }

    private void appendEmptySpace(final StringBuilder result, final Deque<String> stack, final String stackOperator) {
        stack.pop();
        result.append(EMPTY_SPACE).append(stackOperator);
    }
}
