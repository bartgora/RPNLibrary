package com.github.bgora.rpnlibrary.utils.transformer;

import com.github.bgora.rpnlibrary.exceptions.WrongArgumentException;
import com.github.bgora.rpnlibrary.utils.TransformContext;

public class ErrorHandler extends InputTransformerHandler {
    public ErrorHandler(final InputTransformerHandler next) {
        super(next);
    }

    @Override
    public TransformContext transformContext(final TransformContext context, final char character) {
        throw new WrongArgumentException("Element \"" + character + "\" is not recognized by the Checker");
    }
}
