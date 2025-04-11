package com.github.bgora.rpnlibrary.utils.transformer;

import com.github.bgora.rpnlibrary.utils.TransformContext;

public class DigitOrSeparatorHandler extends InputTransformerHandler {

    public DigitOrSeparatorHandler(final InputTransformerHandler next) {
        super(next);
    }

    @Override
    public TransformContext transformContext(final TransformContext context, final char character) {
        if (isDigitOrSeparator(character) && (context.lastWasDigit() || !context.lastWasOperator())) {
            context.lastWasDigit(true);
            context.lastWasWhiteSpace(false);
            context.lastWasLetter(false);
            context.append(character);
            return context;
        } else if (next != null) {
            return next.transformContext(context, character);
        }
        return context;
    }
    private boolean isDigitOrSeparator(char c) {
        return Character.isDigit(c) || c == '.' || c == ',';
    }
}
