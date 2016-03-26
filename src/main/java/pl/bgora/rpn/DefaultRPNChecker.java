/*
    RPNCalculator - Reverse Polish Notation mathematics Library
    Copyright (C) 2011  Bartłomiej "Black007" Góra

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package pl.bgora.rpn;

import java.util.HashMap;
import java.util.Map;

/**
 * Class used for checking input String for Functions, operators, digits, etc.
 * 
 * Checks if input is acceptable for calculations.
 * This implementation distinguishes the following symbols:
 * <p>
 * + - addition
 * - - substraction
 * * - multiplication
 *\/ - division
 * ^ - power (x^n - x to the power n)
 * </p>
 * @author Bartłomiej Góra (bartlomiej.gora@gmail.com)
 *
 */
class DefaultRPNChecker implements RPNChecking{
	
	private Map<String, Integer> operators;
	
	public DefaultRPNChecker(){
		operators = new HashMap<String, Integer>();
		operators.put("+", 1);
		operators.put("-", 1);
		operators.put("*", 2);
		operators.put("/", 2);
		operators.put("^", 3);
	}


	/**
	 * 
	 * @see pl.bgora.rpn.RPNChecking#isDigit(java.lang.String)
	 */
	@Override
	public boolean isDigit(String input) {
		return Character.isDigit(input.charAt(0));
	}
	/**
	 * 
	 * @see pl.bgora.rpn.RPNChecking#isLeftBracket(java.lang.String)
	 */
	@Override
	public boolean isLeftBracket(String input) {
		return "(".equals(input);
	}
	/**
	 * Returns true if input = +, or -, or *, or /, or ^, false otherwise.
	 * @see pl.bgora.rpn.RPNChecking#isOperator(java.lang.String)
	 */
	@Override
	public boolean isOperator(String input) {
		return "*".equals(input) || "+".equals(input) || "/".equals(input) || "-".equals(input) || "^".equals(input);
	}
	/**
	 * Returns true if input = )
	 * @see pl.bgora.rpn.RPNChecking#isRightBracket(java.lang.String)
	 */
	@Override
	public boolean isRightBracket(String input) {
		return ")".equals(input);
	}
	

	/** 
	 * Returns true, if input is "+ - * /" or bracket "()"
	 * @see pl.bgora.rpn.RPNChecking#isOperatorOrBracket(java.lang.String)
	 */
	@Override
	public boolean isOperatorOrBracket(String c) {
		if("(".equals(c)||
		   ")".equals(c) ||
		   "*".equals(c) ||
		   "+".equals(c) ||
		   "/".equals(c) ||
		   "-".equals(c)||
		   "^".equals(c)){
			return true;
		}
		return false;
	}

	/** 
	 * 
	 * @see pl.bgora.rpn.RPNChecking#isLeftAssociativity(java.lang.String)
	 */
	@Override
	public boolean isLeftAssociativity(String c) {
		if("*".equals(c) ||
				"+".equals(c) ||
				"/".equals(c) ||
				"-".equals(c)){
				return true;
			}
		return false;
	}

	/** 
	 * @see pl.bgora.rpn.RPNChecking#isRightAssociativity(java.lang.String)
	 */
	@Override
	public boolean isRightAssociativity(String c) {
		return "^".equals(c);
	}

	/** 
	 * @see pl.bgora.rpn.RPNChecking#compareOperators(java.lang.String, java.lang.String)
	 */
	@Override
	public int compareOperators(String c1, String c2) {
		Integer i1 = operators.get(c1);
		Integer i2 = operators.get(c2);
		return i1-i2;
	}


	/** 
	 * @see pl.bgora.rpn.RPNChecking#isFunction(java.lang.String)
	 */
	@Override
	public boolean isFunction(String input) {	
		return false;
	}


	/** 
	 * @see pl.bgora.rpn.RPNChecking#getFunctionParamsCount(java.lang.String)
	 */
	@Override
	public int getFunctionParamsCount(String functionName) {
		return 0;
	}
}
