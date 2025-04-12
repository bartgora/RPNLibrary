package com.github.bgora.rpnlibrary;

import java.util.Map;

public class RPNCheckerFactory {

    public static RPNChecker createRPNChecker(final Map<String, Integer> operators, final Map<String, Integer> functions) {
        return new DefaultChecker(operators, functions);
    }
}
