package pl.bgora.rpn;

import pl.bgora.rpn.exceptions.NoSuchFunctionFound;
import pl.bgora.rpn.exceptions.WrongArgumentException;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Interface used for executing Calculation on RPN String
 *
 * @author Bartłomiej Góra (bartlomiej.gora@gmail.com)
 */
public interface RPNExecuting {


    /**
     * This method executes arithmetic operator given as first parameter of type String.
     *
     * @param operator Arithmetic operator to execute.
     * @param var1     first variable
     * @param var2     second variable.
     * @param mode     Rounding Mode for operation.
     * @return calculation result.
     * @throws WrongArgumentException if theres is something wrong withe the input.
     */
    BigDecimal executeOperator(String operator, String var1, String var2, RoundingMode mode) throws WrongArgumentException;

    /**
     * This method executes Arithmetic Functions.
     * The first parameter is Function name.
     *
     * @param functionName Name of the function to execute.
     * @param mode         Rounding mode for calculations.
     * @param arguments    List of arguments for the called function.
     * @return Calculation result as BigDecimal.
     * @throws NoSuchFunctionFound thrown if Executing object cannot find method.
     */
     BigDecimal executeFunction(String functionName, RoundingMode mode, String... arguments) throws NoSuchFunctionFound;
}
