package com.github.bgora.rpnlibrary.utils;

public class DigitHandler extends AbstractInputTransformerChain {

    private static final String EMPTY_SPACE = " ";
    public DigitHandler(final AbstractInputTransformerChain next) {
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
