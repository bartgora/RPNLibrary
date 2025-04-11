package com.github.bgora.rpnlibrary.functions;

import java.util.HashMap;
import java.util.Map;

public class DefaultFunctionProvider implements FunctionProvider {
    Map<String, AbstractFunctionStrategy> DEFAULT_FUNCTIONS = new HashMap<String, AbstractFunctionStrategy>();

    @Override
    public Map<String, AbstractFunctionStrategy> getFunctions() {
        AbstractFunctionStrategy sinusFunctionStrategy = new SinusFunctionStrategy();
        DEFAULT_FUNCTIONS.put(sinusFunctionStrategy.getName(), sinusFunctionStrategy);
        AbstractFunctionStrategy cosinusFunctionStrategy = new CosFunctionStrategy();
        DEFAULT_FUNCTIONS.put(cosinusFunctionStrategy.getName(), cosinusFunctionStrategy);
        AbstractFunctionStrategy tanFunctionStrategy = new TanFunctionStrategy();
        DEFAULT_FUNCTIONS.put(tanFunctionStrategy.getName(), tanFunctionStrategy);
        AbstractFunctionStrategy ctgFunctionStrategy = new CtgFunctionStrategy();
        DEFAULT_FUNCTIONS.put(ctgFunctionStrategy.getName(), ctgFunctionStrategy);
        AbstractFunctionStrategy maxFunctionStrategy = new MaxFunctionStrategy();
        DEFAULT_FUNCTIONS.put(maxFunctionStrategy.getName(), maxFunctionStrategy);
        AbstractFunctionStrategy minFunctionStrategy = new MinFunctionStrategy();
        DEFAULT_FUNCTIONS.put(minFunctionStrategy.getName(), minFunctionStrategy);
        AbstractFunctionStrategy fibFunctionStrategy = new FibFunctionStrategy();
        DEFAULT_FUNCTIONS.put(fibFunctionStrategy.getName(), fibFunctionStrategy);
        return DEFAULT_FUNCTIONS;
    }
}
