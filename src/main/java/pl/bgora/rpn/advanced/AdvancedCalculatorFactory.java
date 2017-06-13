package pl.bgora.rpn.advanced;

import pl.bgora.rpn.CalculatorEngine;
import pl.bgora.rpn.CalculatorInterface;
import pl.bgora.rpn.factory.AbstractCalculatorFactory;

import java.math.RoundingMode;

/**
 * factory for AdvancedCalculator
 *
 * @author Bartłomiej Góra (bartlomiej.gora@gmail.com)
 */
public class AdvancedCalculatorFactory extends AbstractCalculatorFactory {

    public CalculatorInterface createCalulator() {
        CalculatorEngine engine = getDefaultEngine();
        return new AdvancedCalculator(RoundingMode.HALF_UP, engine);
    }

    /**
     * Creates AdvanceCalculator with given CalculatorEngine
     *
     * @param engine CalculatorEngine instance
     * @return AdvanceCalculator
     */
    public CalculatorInterface createCalulator(CalculatorEngine engine) {
        return new AdvancedCalculator(RoundingMode.HALF_UP, engine);
    }


    /**
     * Return default CalculatorEngine
     * @return CalculatorEngine
     */
    public CalculatorEngine getDefaultEngine() {
        return new CalculatorEngine(StrategiesUtil.DEFAULT_OPERATORS, StrategiesUtil.DEFAULT_FUNCTIONS);
    }

}
