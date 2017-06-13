package pl.bgora.rpn.factory;

import pl.bgora.rpn.CalculatorInterface;

/**
 * AbstractCalculatorFactory.
 * <p>
 * It's subclasses are used do provide CalculatorInterace implementations
 *
 * @author Bartłomiej Góra (bartlomiej.gora@gmail.com)
 * @see CalculatorInterface
 */

public abstract class AbstractCalculatorFactory {

    /**
     * Creates Calculator
     * @return an CalculatorInterface instance
     */
    public abstract CalculatorInterface createCalulator();
}
