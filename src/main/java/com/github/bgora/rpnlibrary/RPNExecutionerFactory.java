package com.github.bgora.rpnlibrary;

import com.github.bgora.rpnlibrary.functions.AbstractFunctionStrategy;
import com.github.bgora.rpnlibrary.operators.AbstractOperatorStrategy;

import java.util.Map;

public class RPNExecutionerFactory {
    public static RPNExecutioner createRPNExecutioner(
            Map<String, AbstractOperatorStrategy> operators, Map<String, AbstractFunctionStrategy> functions) {
        return new DefaultRPNExecutioner(operators, functions);
    }
}
