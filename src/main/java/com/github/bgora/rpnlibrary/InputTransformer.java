package com.github.bgora.rpnlibrary;


import com.github.bgora.rpnlibrary.exceptions.WrongArgumentException;
import com.github.bgora.rpnlibrary.utils.AbstractInputTransformerChain;
import com.github.bgora.rpnlibrary.utils.DigitHandler;
import com.github.bgora.rpnlibrary.utils.DigitOrSeparatorHandler;
import com.github.bgora.rpnlibrary.utils.LetterHandler;
import com.github.bgora.rpnlibrary.utils.OperatorHandler;
import com.github.bgora.rpnlibrary.utils.TransformContext;
import com.github.bgora.rpnlibrary.utils.WhitespaceHandler;

import java.util.function.UnaryOperator;

/**
 * Formats input for further processing:
 * <p>
 * example (1+2)*5 -> ( 1 + 2 ) * 5
 */
public class InputTransformer implements UnaryOperator<String> {

    protected final RPNChecking checker;
    private AbstractInputTransformerChain transformerChain;

    public InputTransformer(final RPNChecking checker) {
        this.checker = checker;
        transformerChain = new DigitOrSeparatorHandler(
                new DigitHandler(
                        new OperatorHandler(
                                new WhitespaceHandler(
                                        new LetterHandler(null)), checker)));
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
        String result = "";
        final String inputValue = input.trim();
        int length = inputValue.length();
        TransformContext context = new TransformContext();
        char character;

        for (int i = 0; i < length; i++) {
            character = inputValue.charAt(i);
            result = transformerChain.transformContext(context, character).getResult();
        }
        return result.trim();

    }


}
