package pl.bgora.rpn;

import pl.bgora.rpn.factory.AbstractCalculatorFactory;

public class DefaultCalculatorFactory extends AbstractCalculatorFactory {

    @Override
    public CalculatorInterface createCalulator() {
        return Calculator.createDefaultCalculator();
    }
}
