package pl.bgora.rpn.advanced;

import pl.bgora.rpn.CalculatorEngine;
import pl.bgora.rpn.CalculatorInterface;
import pl.bgora.rpn.factory.AbstractCalculatorFactory;

import java.math.RoundingMode;

public class AdvancedCalculatorFactory extends AbstractCalculatorFactory {

    public CalculatorInterface createCalulator() {
        CalculatorEngine engine = getDefaultEngine();
        return new AdvancedCalculator(RoundingMode.HALF_UP, engine);
    }

    public CalculatorInterface createCalulator(CalculatorEngine engine) {
        return new AdvancedCalculator(RoundingMode.HALF_UP, engine);
    }


    public CalculatorEngine getDefaultEngine() {
        return new CalculatorEngine(StrategiesUtil.DEFAULT_OPERATORS, StrategiesUtil.DEFAULT_FUNCTIONS);
    }

}
