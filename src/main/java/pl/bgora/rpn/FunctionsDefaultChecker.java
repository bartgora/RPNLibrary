package pl.bgora.rpn;

import java.util.HashMap;
import java.util.Map;

/**
 * This implementation Extends DefaultChecker with arithmetic funstions.
 * 
 * Provided functiona are: sin, cos, tg, ctg
 * 
 * @author Bartłomiej Góra (Black007pl@gmail.com)
 * 
 */
class FunctionsDefaultChecker implements RPNChecking {

	private Map<String, Integer> operators;
	
	private Map<String, Integer> functions;

	public FunctionsDefaultChecker() {
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
	 * 
	 * @see pl.black007.rpn.RPNChecking#isDigit(java.lang.String)
	 */
	@Override
	public boolean isDigit(String input) {
		return Character.isDigit(input.charAt(0));
	}

	/**
	 * 
	 * @see pl.black007.rpn.RPNChecking#isLeftBracket(java.lang.String)
	 */
	@Override
	public boolean isLeftBracket(String input) {
		return "(".equals(input);
	}

	/**
	 * Returns true if input = +, or -, or *, or /, or ^, false otherwise.
	 * 
	 * @see pl.black007.rpn.RPNChecking#isOperator(java.lang.String)
	 */
	@Override
	public boolean isOperator(String input) {
		return operators.containsKey(input);
	}

	/**
	 * Returns true if input = )
	 * 
	 * @see pl.black007.rpn.RPNChecking#isRightBracket(java.lang.String)
	 */
	@Override
	public boolean isRightBracket(String input) {
		return ")".equals(input);
	}

	/**
	 * Returns true, if input is "+ - * /" or bracket "()"
	 * 
	 * @see pl.black007.rpn.RPNChecking#isOperatorOrBracket(java.lang.String)
	 */
	@Override
	public boolean isOperatorOrBracket(String c) {
		return isOperator(c) || isRightBracket(c) || isLeftBracket(c);
	}

	/**
	 * 
	 * @see pl.black007.rpn.RPNChecking#isLeftAssociativity(java.lang.String)
	 */
	@Override
	public boolean isLeftAssociativity(String c) {
		if ("*".equals(c) || "+".equals(c) || "/".equals(c) || "-".equals(c)) {
			return true;
		}
		return false;
	}

	/**
	 * @see pl.black007.rpn.RPNChecking#isRightAssociativity(java.lang.String)
	 */
	@Override
	public boolean isRightAssociativity(String c) {
		return "^".equals(c);
	}

	/**
	 * @see pl.black007.rpn.RPNChecking#compareOperators(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public int compareOperators(String c1, String c2) {
		Integer i1 = operators.get(c1);
		Integer i2 = operators.get(c2);
		return i1 - i2;
	}

	/**
	 * Checks if input is one of the recognized functions.
	 * 
	 * Recognized functions are: sin, cos, tg, ctg.
	 * 
	 * @see net.sf.black007pl.rpnlibrary.RPNChecking#isFunction(java.lang.String)
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
