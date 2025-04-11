package com.github.bgora.rpnlibrary.utils.transformer;

import com.github.bgora.rpnlibrary.utils.TransformContext;

public class DigitHandler extends InputTransformerHandler {

    private static final String EMPTY_SPACE = " ";
    public DigitHandler(final InputTransformerHandler next) {
        super(next);
    }

    @Override
    public TransformContext transformContext(final TransformContext context, final char character) {
        if(Character.isDigit(character)) {
            context.lastWasDigit(true);
            context.lastWasOperator(false);
            context.lastWasLetter(false);
            if (!context.lastWasWhiteSpace()) {
                context.append(EMPTY_SPACE);
            }
            context.append(character);
            context.lastWasWhiteSpace(false);
        } else if (next != null) {
            return next.transformContext(context, character);
        }
        return context;
    }


}
