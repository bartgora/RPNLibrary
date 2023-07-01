package com.github.bgora.rpnlibrary.utils;

public class LetterHandler extends AbstractInputTransformerChain {
    public LetterHandler(final AbstractInputTransformerChain next) {
        super(next);
    }

    @Override
    public TransformContext transformContext(final TransformContext context, final char character) {
        if (Character.isLetter(character)) {
            context.lastWasDigit(false);
            context.lastWasOperator(false);
            if (!context.lastWasLetter() && !context.lastWasWhiteSpace()) {
                context.append(" ");
                context.append(character);
            } else {
                context.append(character);
            }
            context.lastWasWhiteSpace(false);
            context.lastWasLetter(true);

        } else if (next != null) {
            return next.transformContext(context, character);
        }
        return context;
    }
}
