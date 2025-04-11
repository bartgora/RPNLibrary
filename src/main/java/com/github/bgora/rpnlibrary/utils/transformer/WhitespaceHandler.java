package com.github.bgora.rpnlibrary.utils.transformer;

import com.github.bgora.rpnlibrary.utils.TransformContext;

public class WhitespaceHandler extends InputTransformerHandler {
    public WhitespaceHandler(final InputTransformerHandler next) {
        super(next);
    }

    @Override
    public TransformContext transformContext(final TransformContext context, final char character) {
        if (Character.isWhitespace(character)) {
            if (!context.lastWasWhiteSpace() && !context.lastWasDigit()) {
                context.append(" ");
                context.lastWasWhiteSpace(true);
            }
            context.lastWasDigit(false);
            context.lastWasOperator(false);
        } else if (next != null) {
            return next.transformContext(context, character);
        }
        return context;
    }
}
