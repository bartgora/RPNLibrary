package pl.bgora.rpn;

import pl.bgora.rpn.exceptions.NoSuchFunctionFound;
import pl.bgora.rpn.exceptions.WrongArgumentException;

import java.math.BigDecimal;

/**
 * Interface for the Calculator
 *
 * @author Bartłomiej Góra (bartlomiej.gora@gmail.com)
 */
public interface CalculatorInterface {

    /**
     * Calculates RPN String into BigDecimal Object.
     *
     * @throws NoSuchFunctionFound
     * @see pl.bgora.rpn.Calculator#calculate(java.lang.String)
     */
    BigDecimal calculate(String input) throws WrongArgumentException, NoSuchFunctionFound;
}
