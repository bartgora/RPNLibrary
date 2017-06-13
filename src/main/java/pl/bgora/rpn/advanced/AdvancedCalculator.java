package pl.bgora.rpn.advanced;

import pl.bgora.rpn.Calculator;
import pl.bgora.rpn.CalculatorEngine;
import pl.bgora.rpn.CalculatorInterface;

import java.math.RoundingMode;

/**
 * Advanced Calculator.
 *
 * @author Bartłomiej Góra (bartlomiej.gora@gmail.com)
 */
public class AdvancedCalculator extends Calculator implements CalculatorInterface {

    AdvancedCalculator(RoundingMode mode, CalculatorEngine calculatorEngine) {
        super(calculatorEngine, calculatorEngine, mode);
    }
}
