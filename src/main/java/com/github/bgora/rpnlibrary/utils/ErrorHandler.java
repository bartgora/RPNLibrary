package com.github.bgora.rpnlibrary.utils;

import com.github.bgora.rpnlibrary.exceptions.WrongArgumentException;

public class ErrorHandler extends AbstractInputTransformerChain {
    public ErrorHandler(final AbstractInputTransformerChain next) {
        super(next);
    }

    @Override
    public TransformContext transformContext(final TransformContext context, final char character) {
        throw new WrongArgumentException("Element \"" + character + "\" is not recognized by the Checker");
    }
}
