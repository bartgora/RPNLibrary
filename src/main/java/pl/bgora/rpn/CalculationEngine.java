package pl.bgora.rpn;

import pl.bgora.rpn.advanced.functions.AbstractFunctionStrategy;
import pl.bgora.rpn.advanced.operators.AbstractOperatorStrategy;

/**
 * Interface tha declares additional operations for new CalculationEngine
 *
 * @see RPNChecking
 * @see RPNExecuting
 */
public interface CalculationEngine extends RPNExecuting, RPNChecking {

    /**
     * Adds new operator strategy to the Engine
     *
     * @param abstractOperatorStrategy
     */
    void addOperator(final AbstractOperatorStrategy abstractOperatorStrategy);

    /**
     * Adds new function startegy to the engine
     *
     * @param abstractFunctionStrategy
     */
    void addFunctionStartegy(final AbstractFunctionStrategy abstractFunctionStrategy);
}
