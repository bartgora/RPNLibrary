package com.github.bgora.rpnlibrary.utils.transformer;

import com.github.bgora.rpnlibrary.RPNChecking;
import com.github.bgora.rpnlibrary.utils.TransformContext;

public class OperatorHandler extends InputTransformerHandler {
    private final RPNChecking checker;


    public OperatorHandler(final InputTransformerHandler next, RPNChecking checker) {
        super(next);
        this.checker = checker;
    }

    @Override
    public TransformContext transformContext(final TransformContext context, final char character) {
        if (checker.isOperatorOrBracket(String.valueOf(character))) {
            context.lastWasDigit(false);
            context.lastWasLetter(false);
            context.lastWasOperator(true);
            if (!context.lastWasWhiteSpace()) {
                context.append(" ");
            }
            context.append(character);
            context.lastWasWhiteSpace(false);
        } else if (next != null) {
            return next.transformContext(context, character);
        }
        return context;
    }
}
