package pl.bgora.rpn;

import pl.bgora.rpn.factory.AbstractCalculatorFactory;

/**
 * Creates DefaultCalculator instance
 *
 * @author Bartłomiej Góra (bartlomiej.gora@gmail.com)
 * @see Calculator
 */
public class DefaultCalculatorFactory extends AbstractCalculatorFactory {

    @Override
    public CalculatorInterface createCalulator() {
        return Calculator.createDefaultCalculator();
    }
}
