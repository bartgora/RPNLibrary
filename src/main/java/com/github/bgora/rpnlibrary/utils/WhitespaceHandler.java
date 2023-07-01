package com.github.bgora.rpnlibrary.utils;

public class WhitespaceHandler extends AbstractInputTransformerChain {
    public WhitespaceHandler(final AbstractInputTransformerChain next) {
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
