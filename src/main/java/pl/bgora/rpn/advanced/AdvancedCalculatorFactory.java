package pl.bgora.rpn.advanced;

import pl.bgora.rpn.CalculatorInterface;
import pl.bgora.rpn.factory.AbstractCalculatorFactory;

import java.math.RoundingMode;

public class AdvancedCalculatorFactory extends AbstractCalculatorFactory {

    public CalculatorInterface createCalulator() {
        return new AdvancedCalculator(RoundingMode.HALF_UP, null, operators);
    }

}
