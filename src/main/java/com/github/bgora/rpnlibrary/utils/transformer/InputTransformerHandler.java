package com.github.bgora.rpnlibrary.utils.transformer;

import com.github.bgora.rpnlibrary.utils.TransformContext;

public abstract class InputTransformerHandler {

    protected InputTransformerHandler next;

    public InputTransformerHandler(final InputTransformerHandler next) {
        this.next = next;
    }

    public abstract TransformContext transformContext(final TransformContext context, final char character);
}
