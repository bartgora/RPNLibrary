package com.github.bgora.rpnlibrary;

import com.github.bgora.rpnlibrary.exceptions.NoSuchFunctionFound;
import com.github.bgora.rpnlibrary.exceptions.WrongArgumentException;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * Default Executioner using StrategyProvider
 */
public class DefaultRPNExecutor implements RPNExecuting {

    private final StrategyProvider strategyProvider;

    public DefaultRPNExecutor(final StrategyProvider strategyProvider) {
        this.strategyProvider = strategyProvider;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal executeOperator(final String operator, final MathContext mathContext, final String var1, final String var2) throws WrongArgumentException {
        return strategyProvider.getOperator(operator).execute(var1, var2, mathContext);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal executeFunction(final String functionName, final MathContext mathContext, final String... arguments) throws NoSuchFunctionFound {
        return strategyProvider.getFunction(functionName).execute(mathContext, arguments);
    }
}
