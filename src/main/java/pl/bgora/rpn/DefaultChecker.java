package pl.bgora.rpn;

import java.util.HashMap;
import java.util.Map;

/**
 * This implementation Extends DefaultChecker with arithmetic funstions.
 *
 * Provided functions are: sin, cos, tg, ctg
 *
 * @author Bartłomiej Góra (bartlomiej.gora@gmail.com)
 */
public class DefaultChecker implements RPNChecking {

    private Map<String, Integer> operators;

    private Map<String, Integer> functions;

    public DefaultChecker() {
        operators = new HashMap<String, Integer>();
        operators.put("+", 1);
        operators.put("-", 1);
        operators.put("*", 2);
        operators.put("/", 2);
        operators.put("^", 3);

        functions = new HashMap<String, Integer>();
        functions.put("sin", 1);
        functions.put("cos", 1);
        functions.put("tg", 1);
        functions.put("ctg", 1);

    }

    /**
     * @see pl.bgora.rpn.RPNChecking#isDigit(java.lang.String)
     */
    @Override
    public boolean isDigit(String input) {
        return Character.isDigit(input.charAt(0));
    }

    /**
     * @see pl.bgora.rpn.RPNChecking#isLeftBracket(java.lang.String)
     */
    @Override
    public boolean isLeftBracket(String input) {
        return "(".equals(input);
    }

    /**
     * Returns true if input = +, or -, or *, or /, or ^, false otherwise.
     *
     * @see pl.bgora.rpn.RPNChecking#isOperator(java.lang.String)
     */
    @Override
    public boolean isOperator(String input) {
        return operators.containsKey(input);
    }

    /**
     * Returns true if input = )
     *
     * @see pl.bgora.rpn.RPNChecking#isRightBracket(java.lang.String)
     */
    @Override
    public boolean isRightBracket(String input) {
        return ")".equals(input);
    }

    /**
     * Returns true, if input is "+ - * /" or bracket "()"
     *
     * @see pl.bgora.rpn.RPNChecking#isOperatorOrBracket(java.lang.String)
     */
    @Override
    public boolean isOperatorOrBracket(String c) {
        return isOperator(c) || isRightBracket(c) || isLeftBracket(c);
    }

    /**
     * @see pl.bgora.rpn.RPNChecking#isLeftAssociativity(java.lang.String)
     */
    @Override
    public boolean isLeftAssociativity(String c) {
        return ("*".equals(c) || "+".equals(c) || "/".equals(c) || "-".equals(c));
    }

    /**
     * @see pl.bgora.rpn.RPNChecking#isRightAssociativity(java.lang.String)
     */
    @Override
    public boolean isRightAssociativity(String c) {
        return "^".equals(c);
    }

    /**
     * @see pl.bgora.rpn.RPNChecking#compareOperators(java.lang.String,
     * java.lang.String)
     */
    @Override
    public int compareOperators(String operato1, String operator2) {
        Integer i1 = operators.get(operato1);
        Integer i2 = operators.get(operator2);
        return i1 - i2;
    }

    /**
     * Checks if input is one of the recognized functions.
     *
     * Recognized functions are: sin, cos, tg, ctg.
     *
     * @see pl.bgora.rpn.RPNChecking#isFunction(java.lang.String)
     */
    @Override
    public boolean isFunction(String input) {
        return functions.keySet().contains(input);
    }

    @Override
    public int getFunctionParamsCount(String functionName) {
        return functions.get(functionName);
    }

}
