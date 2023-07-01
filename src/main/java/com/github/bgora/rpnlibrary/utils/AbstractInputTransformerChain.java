package com.github.bgora.rpnlibrary.utils;

public abstract class AbstractInputTransformerChain {

    protected AbstractInputTransformerChain next;

    public AbstractInputTransformerChain(final AbstractInputTransformerChain next) {
        this.next = next;
    }

    public abstract TransformContext transformContext(final TransformContext context, final char character);
}
