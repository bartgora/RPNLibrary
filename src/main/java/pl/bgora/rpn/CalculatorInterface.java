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
     * @param input Input String
     * @return The Calculated value
     * @throws WrongArgumentException If the argument was illegal, like leter, or other unrecognized element
     * @throws NoSuchFunctionFound If there is no function with given name
     */
    BigDecimal calculate(String input) throws WrongArgumentException, NoSuchFunctionFound;
}
