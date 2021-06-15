package com.github.bgora.rpnlibrary;


import com.github.bgora.rpnlibrary.exceptions.WrongArgumentException;

import java.util.function.UnaryOperator;

/**
 * Formats input for further processing:
 * <p>
 * example (1+2)*5 -> ( 1 + 2 ) * 5
 */
public class InputTransformer implements UnaryOperator<String> {

    public static final String EMPTY_SPACE = " ";
    protected final RPNChecking checker;

    public InputTransformer(final RPNChecking checker) {
        this.checker = checker;
    }

    /**
     * Format input for further processing.
     *
     * @param input Input string.
     * @return Formatted String.
     * @throws WrongArgumentException Thrown if the input is incorrect (Incorrect format, or
     *                                unsupported operations)
     */
    public String apply(String input) throws WrongArgumentException {
        final StringBuilder result = new StringBuilder();
        final String inputValue = input.trim();
        int length = inputValue.length();
        char character;
        boolean lastWasDigit = false;
        boolean lastWasOperator = false;
        boolean lastWasWhiteSpace = false;
        boolean lastWasLetter = false;
        for (int i = 0; i < length; i++) {
            character = inputValue.charAt(i);
            if (isDigitOrSeparator(character) && (lastWasDigit || !lastWasOperator)) {
                lastWasDigit = true;
                result.append(character);
                lastWasWhiteSpace = false;
                lastWasLetter = false;
            } else if (Character.isDigit(character)) {
                lastWasDigit = true;
                lastWasLetter = false;
                lastWasOperator = false;
                if (!lastWasWhiteSpace) {
                    result.append(EMPTY_SPACE);
                }
                result.append(character);
                lastWasWhiteSpace = false;
            } else if (checker.isOperatorOrBracket(String.valueOf(character))) {
                lastWasDigit = false;
                lastWasLetter = false;
                lastWasOperator = true;
                if (!lastWasWhiteSpace) {
                    result.append(EMPTY_SPACE);
                }
                result.append(character);
                lastWasWhiteSpace = false;
            } else if (Character.isWhitespace(character)) {
                if (!lastWasWhiteSpace && !lastWasDigit) {
                    result.append(EMPTY_SPACE);
                    lastWasWhiteSpace = true;
                }
                lastWasDigit = false;
                lastWasOperator = false;
            } else if (Character.isLetter(character)) {
                lastWasDigit = false;
                lastWasOperator = false;
                if (!lastWasLetter && !lastWasWhiteSpace) {
                    result.append(EMPTY_SPACE).append(character);
                } else {
                    result.append(character);
                }
                lastWasWhiteSpace = false;
                lastWasLetter = true;
            } else {
                throw new WrongArgumentException("Element \"" + character + "\" is not recognized by the Checker");
            }
        }

        return result.toString().trim();
    }

    private boolean isDigitOrSeparator(char c) {
        return Character.isDigit(c) || c == '.' || c == ',';
    }

}
