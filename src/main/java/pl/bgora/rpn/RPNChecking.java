package pl.bgora.rpn;

/**
 * Interface used to check conditions on input characters for Dijsktra Algorithm

 * @author Bartłomiej Góra (bartlomiej.gora@gmail.com)
 */
public interface RPNChecking {


    /**
     * Checks the parameter is digit
     *
     * @param input
     * @return
     */
    boolean isDigit(String input);

    /**
     * Checks if the parameter is arithmetic operator
     *
     * @param input
     * @return
     */
    boolean isOperator(String input);

    /**
     * Checks if parameter is left bracket
     *
     * @param input
     * @return
     */
    boolean isLeftBracket(String input);

    /**
     * Checks if parameter is right bracket
     * @param input
     * @return
     */
    boolean isRightBracket(String input);

    /**
     * Checks if parameter is bracket or arithmetic operator
     * @param c
     * @return
     */
    boolean isOperatorOrBracket(String c);

    /**
     * Checks if parametr is lest associated
     * @param c
     * @return
     */
    boolean isLeftAssociativity(String c);

    /**
     * Checks if parametr is right associated
     * @param c
     * @return
     */
    boolean isRightAssociativity(String c);

    /**
     * @param operato1
     * @param operator2
     * @return
     */
    int compareOperators(String operato1, String operator2);

    /**
     * Checks if given String is function name
     *
     * @param input function name
     * @return
     */
    boolean isFunction(String input);

    /**
     * Returns parameters count for the given function
     * @param functionName
     * @return parameters count
     */
    int getFunctionParamsCount(String functionName);
}
